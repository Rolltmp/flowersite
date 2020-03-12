package servlet.valid;

import javax.servlet.http.HttpSession;

public class Online {

    private Online(){}

    public static boolean online(HttpSession session){
        if(session == null) return false;
        String bool = (String) session.getAttribute("online");
        return "true".equals(bool);
    }

}
