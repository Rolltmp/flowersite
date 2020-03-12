package servlet;

import dao.DAOFactory;
import dao.UserDAO;
import entity.User;
import servlet.valid.Verification;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reg")

public class Registration extends HttpServlet{

    private DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserDAO userDAO = dao.getUserDAO();
        String regStatus;

        String email = req.getParameter("reg_email");
        String phone = req.getParameter("reg_phone");
        String password = req.getParameter("reg_pass");
        String name = req.getParameter("reg_name");

        if(email != null && phone != null && password != null && name != null) {
            if (Verification.correctEmail(email) && Verification.correctPassword(password)
                    && Verification.correctPhone(phone)) {
                boolean result = userDAO.createUser(new User(name, password, phone, email));
                regStatus = (result) ? "Registration was successful" : "Such email already exists!";
            }else {
                regStatus = "Incorrect data";
            }
        }else {
            regStatus = "Incorrect data";
        }
        req.setAttribute("RegStatus",regStatus);
        RequestDispatcher dispatcher = req.getRequestDispatcher("page/information_page.jsp");
        dispatcher.forward(req,resp);
    }
}
