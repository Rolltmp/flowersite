package servlet;

import dao.DAOFactory;
import dao.Localization;
import dao.UserDAO;
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

@WebServlet("/auth")

public class Auth extends HttpServlet{

    private DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
    private UserDAO userDAO;
    private HttpSession session;
    private String authStatus = "";
    //private Localization localization;

/*    @Override
    public void init() throws ServletException {
        localization = Localization.getInstance();
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        req.setAttribute("AuthStatus",authStatus);
        session = req.getSession();
        if(Online.online(session)){
            resp.sendRedirect(req.getContextPath() + "/main");
        }else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("page/auth.jsp");
            dispatcher.forward(req, resp);
        }
        ServletVariables.previousPath = req.getServletPath();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        userDAO = dao.getUserDAO();
        session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        if (email != null && password != null) {
            if (Verification.correctEmail(email)) {
                boolean result = userDAO.loginUser(email, password);
                if (result) {
                    session.setAttribute("online","true");
                    session.setAttribute("user",userDAO.getUser(email));
                    resp.sendRedirect(req.getContextPath() +  "/main");
                    return;
                } else {
                    authStatus = "\nInvalid login/password";
                }
            } else {
                authStatus = "\nIncorrect email/password";
            }
        }else {
            authStatus = "\nIncorrect email/password";
        }
        resp.sendRedirect(req.getContextPath() + "/auth");
    }

}
