<%@ page import="dao.Localization" %><%
    Localization localization = Localization.getInstance();
    if(session.getAttribute("lang") == null){
        session.setAttribute("lang", localization.getDictionary("english"));
    }
%>
