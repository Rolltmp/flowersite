package servlet;

import entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/flower")

public class FlowerPage extends HttpServlet{

    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int flowerNum;
        session = req.getSession();
        if(req.getParameter("flower_num") != null) {
            flowerNum = Integer.parseInt(req.getParameter("flower_num"));
            session.setAttribute("flower_num",flowerNum);
        }else {
            if(session.getAttribute("flower_num") == null){
                resp.sendRedirect(req.getContextPath() + "/flowers");
                return;
            }
            flowerNum = (Integer)session.getAttribute("flower_num");
        }
        if(session.getAttribute("products") == null){
            resp.sendRedirect(req.getContextPath() +  "/flowers");
            return;
        }
        List<Product> products = (List<Product>) session.getAttribute("products");
        Product product = getProduct(products,flowerNum);
        if(product != null)  session.setAttribute("flower",product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("page/flower.jsp");
        dispatcher.forward(req,resp);
        ServletVariables.previousPath = req.getServletPath();

    }

    private Product getProduct(List<Product> products ,int num){
        for (Product p:products) {
            if(p.getFlowerNumber() == num) return p;
        }
        return null;
    }

}
