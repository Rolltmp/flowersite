<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About us</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6" style="margin: 10% 0">
                ${sessionScope.lang['about_us']}
            </div>
            <div class="col-sm-3"></div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
