package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/about")

public class About extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // this is just a comment to see hoe the branches work
        RequestDispatcher dispatcher = req.getRequestDispatcher("page/about.jsp");
        dispatcher.forward(req,resp);
        ServletVariables.previousPath = req.getServletPath();

    }
}
