package servlet;

import dao.Localization;
import servlet.valid.Online;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/main")

public class Main extends HttpServlet{

    private HttpSession session;
    //private Localization localization;

/*    @Override
    public void init() throws ServletException {
        localization = Localization.getInstance();
    }*/

/*
    private void initLanguage(){
        if(session.getAttribute("lang") == null){
            session.setAttribute("lang", localization.getDictionary("english"));
        }
    }
*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        //initLanguage();
        RequestDispatcher dispatcher = req.getRequestDispatcher("page/main.jsp");
        dispatcher.forward(req,resp);
        ServletVariables.previousPath = req.getServletPath();
    }
}
