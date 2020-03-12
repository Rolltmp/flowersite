package servlet;

import dao.Cart;
import dao.DAOFactory;
import dao.ProductDAO;
import entity.Product;
import servlet.valid.Online;
import servlet.valid.Verification;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/cart")

public class CartController extends HttpServlet{

    private HttpSession session;
    private DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
    private ProductDAO productDAO;
    private Cart cart = Cart.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        if(!Online.online(session)){
            resp.sendRedirect(req.getContextPath() + "/auth");
            return;
        }
        session.setAttribute("cart",cart.getCart());
        RequestDispatcher dispatcher = req.getRequestDispatcher("page/cart.jsp");
        dispatcher.forward(req,resp);
        ServletVariables.previousPath = req.getServletPath();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        if(!Online.online(session)){
            resp.getWriter().write("NON_AUTHORIZED");
            return;
        }

        String type = req.getParameter("type_request");
        if(type != null){
            productDAO = dao.getProductDAO();
            switch (type){
                case "add":{
                    if(req.getParameter("product") != null &&
                            req.getParameter("quantity") != null &&
                            Verification.isNumber(req.getParameter("quantity"),1)){
                        int num = Integer.parseInt(req.getParameter("product"));
                        int quantity = Integer.parseInt(req.getParameter("quantity"));
                        if(quantity >= 1 && quantity <= 3) {
                            Product product = productDAO.getProduct(num);
                            addToCart(product, quantity);
                            resp.getWriter().write("SUCCESS");
                        }else {
                            resp.getWriter().write("BIG_QUANTITY");
                        }
                    }else {
                        resp.getWriter().write("INCORRECT_VALUE");
                    }
                    break;
                }
                case "del":{
                    if(req.getParameter("product") != null){
                        int num = Integer.parseInt(req.getParameter("product"));
                        Product product  = productDAO.getProduct(num);
                        takeAwayFromCart(product);
                        resp.getWriter().write("SUCCESS");
                    }
                    break;
                }
                default:{
                    break;
                }
            }

        }
    }



    private void addToCart(Product product, int quantity){
        cart.putToCart(product,quantity);
        System.out.println("product added");
    }

    private void takeAwayFromCart(Product product){
        cart.deleteFromCart(product);
        System.out.println("product deleted");
    }

}
