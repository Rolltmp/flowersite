package servlet;

import dao.DAOFactory;
import dao.ProductDAO;
import entity.Product;
import servlet.valid.Verification;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/flowers")

public class Flowers extends HttpServlet {

    private HttpSession session;
    private DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
    private ProductDAO productDAO;
    private String off;

    /**
     * Filter
     **/
    private int price;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        productDAO = dao.getProductDAO();
        off = req.getParameter("off");
        showProduct();
        RequestDispatcher dispatcher = req.getRequestDispatcher("page/flowers.jsp");
        dispatcher.forward(req, resp);
        ServletVariables.previousPath = req.getServletPath();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param = req.getParameter("price");
        if (Verification.isNumber(param,4))
            price = Integer.valueOf(req.getParameter("price"));
        resp.sendRedirect(req.getContextPath() + "/flowers");
    }

    private void showProduct() {

        List<Product> products;
        if (price == 0 || "true".equals(off)) {
            price = 0;
            products = productDAO.showProducts(0);
            session.setAttribute("products", products);
        } else {
            products = productDAO.showProducts(price);
            session.setAttribute("products", products);
        }
        int[] prices =
                productDAO.priceMinMax();
        //prices[0] = products.get(0).getPrice();
        //prices[1] = products.get(products.size()-1).getPrice();
        session.setAttribute("max_price", prices[1]);
        session.setAttribute("min_price", prices[0]);
        session.setAttribute("value_price", (prices[0] + prices[1]) / 2);
    }
}

