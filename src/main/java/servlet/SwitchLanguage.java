package servlet;

import dao.Localization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/switch")

public class SwitchLanguage extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Localization localization = Localization.getInstance();
        String param = req.getParameter("language");
        session.setAttribute("lang",localization.getDictionary(param));
        resp.sendRedirect(req.getContextPath() + ServletVariables.previousPath);
    }

}
