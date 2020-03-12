package servlet;

import dao.DAOFactory;
import dao.OrderDAO;
import dao.UserDAO;
import entity.User;
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
import java.util.Objects;

@WebServlet("/account")

public class Account extends HttpServlet{

    private HttpSession session;
    private DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
    private UserDAO userDAO;
    private User user;
    private OrderDAO orderDAO;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;

        session = req.getSession();
        if(!Online.online(session)){
            resp.sendRedirect(req.getContextPath() + "/auth");
            return;
        }
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        session = req.getSession();

        String type = req.getParameter("type");
        if(type != null){
            switch (type){
                case "edit":{
                    dispatcher = req.getRequestDispatcher("page/edit.jsp");
                    dispatcher.forward(req,resp);
                    break;
                }
                case "order":{
                    if(session.getAttribute("user") != null &&
                            session.getAttribute("user") instanceof User) {
                        user = (User) session.getAttribute("user");
                    }else {
                        resp.sendRedirect(req.getContextPath() + "/auth");
                        return;
                    }
                    orderDAO = dao.getOrderDAO();
                    session.setAttribute("orders",orderDAO.orders(user.getEmail()));
                    dispatcher = req.getRequestDispatcher("page/my-order.jsp");
                    dispatcher.forward(req,resp);
                    break;
                }
                default:
                    resp.sendRedirect(req.getContextPath() + "/main");

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        session = req.getSession();

        String type = req.getParameter("type_request");
        if(type != null){

            userDAO = dao.getUserDAO();
            if(session.getAttribute("user") != null &&
                    session.getAttribute("user") instanceof User) {
                user = (User) session.getAttribute("user");
            }else {
                resp.getWriter().print("NON_AUTHORIZED");
                return;
            }

            switch (type){
                case "edit":{
                    if(!Objects.equals(req.getParameter("name"), "") &&
                            !Objects.equals(req.getParameter("phone"), "")){
                        String name = req.getParameter("name");
                        String phone = req.getParameter("phone");
                        if(Verification.correctPhone(phone)){
                                user.setUserName(name);
                                user.setUserPhone(phone);
                                boolean res = userDAO.updateUser(user);
                                if(res){
                                    resp.getWriter().print("SUCCESS");
                                }else {
                                    resp.getWriter().print("ERROR");
                                }
                        }else {
                            resp.getWriter().print("INCORRECT");
                        }
                    }else {
                        resp.getWriter().print("INCORRECT");
                    }
                    break;
                }
                case "change":{
                    if(req.getParameter("password") != null &&
                    req.getParameter("password2") != null){
                        String password = req.getParameter("password");
                        String password2 = req.getParameter("password2");
                        if(Verification.correctPassword(password)){
                            if(Verification.equalsPassword(password,password2)){
                                user.setUserPass(password);
                                boolean res = userDAO.changePassword(user);
                                if(res){
                                    resp.getWriter().print("SUCCESS");
                                }else {
                                    resp.getWriter().print("ERROR");
                                }
                            }else {
                                resp.getWriter().print("NOT_MATCH");
                            }
                        }else {
                            resp.getWriter().print("INCORRECT");
                        }
                    }
                    break;
                }
                default:
                    resp.getWriter().print("ERROR");
                    break;
            }
        }
    }
}
