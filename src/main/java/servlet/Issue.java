package servlet;


import dao.*;
import entity.Order;
import entity.Product;
import entity.User;
import servlet.mail.Sender;
import servlet.valid.Online;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/issue")

public class Issue extends HttpServlet{

    private HttpSession session;
    private DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private Cart cart = Cart.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        if(!Online.online(session)){
            resp.sendRedirect(req.getContextPath() + "/auth");
            return;
        }

        if(cart.getCart().size() == 0){
            resp.sendRedirect(req.getContextPath() + "/cart");
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("page/issue.jsp");
        dispatcher.forward(req,resp);
        ServletVariables.previousPath = req.getServletPath();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        session = req.getSession();
        int orderNum;
        String address = req.getParameter("address");
        String description = req.getParameter("description");
        if(address == null || "".equals(address)){
            HashMap<String,String> lang = (HashMap<String, String>) session.getAttribute("lang");
            session.setAttribute("puy_error",lang.get("pay_error"));
            resp.sendRedirect(req.getContextPath() + "/pay");
            return;
        }
        if(session.getAttribute("user") != null &&
        session.getAttribute("user") instanceof User){
            User user = (User) session.getAttribute("user");
            if(checkProduct().size() > 0){
                session.setAttribute("remainder",checkProduct());
                resp.sendRedirect(req.getContextPath() + "/issue");
            }else {
                orderDAO = dao.getOrderDAO();
                orderItemDAO = dao.getOrderItemDAO();
                orderNum = orderDAO.createOrder(new Order(user.getEmail(),
                        address,description));
                orderItemDAO.addOrderItems(cart.getCart(),orderNum);
/*                Sender sender = new Sender("simferopolff@gmail.com","rhjkbr610917");
                String msg = "Спасибо что воспользовались нашими услугами." +
                        "\nПосле вашей оплаты цветы будут доставлены по адрессу " +
                        address;
                sender.send("Flower site",msg,"support@flower.com",user.getEmail());*/
                cart.flushCart();
                req.getRequestDispatcher("page/issue_success.jsp").forward(req,resp);
            }
        }else {
            resp.sendRedirect(req.getContextPath() +"/auth");
        }
    }

    private Map<Product,Integer> checkProduct(){

        productDAO = dao.getProductDAO();
        Map<Product,Integer> map = new HashMap<>();
        List<Product> products = new ArrayList<>(cart.getCart().keySet());
        List<Integer> values = new ArrayList<>(cart.getCart().values());
        int q = 0;
        for (int i = 0; i < products.size(); i++) {
            q = productDAO.quantityOfGoods(products.get(i));
            if(q > -1 && q < values.get(i)) map.put(products.get(i),q);
        }
        return map;
    }
}
