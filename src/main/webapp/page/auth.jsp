<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.online == 'true'}">
    <c:redirect url="/main"/>
</c:if>
<html>
<head>
    <title>Auth</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <div class="row" style="margin-bottom: 20%">
            <div class="col-sm-2"></div>
            <div class="col-sm-5">
                <h2>${sessionScope.lang['login']}</h2>
                <form action="${pageContext.request.contextPath}/auth" method="post">
                    <div class="form-group">
                        <input type="email" class="form-control" name="email"
                               placeholder="${sessionScope.lang['your_email']}">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="pass" placeholder="${sessionScope.lang['pass']}">
                    </div>
                    <button type="submit" class="btn btn-success">${sessionScope.lang['login']}</button>
                    <div class="form-group">
                        ${requestScope.AuthStatus}
                    </div>
                </form>
            </div>
            <div class="col-sm-5">
                <h2>${sessionScope.lang['reg']}</h2>
                <form action="${pageContext.request.contextPath}/reg" method="post">
                    <div class="form-group">
                        <input type="text" required class="form-control" name="reg_name" placeholder="${sessionScope.lang['name']}">
                    </div>
                    <div class="form-group">
                        <label></label>
                        <input type="email" required class="form-control" name="reg_email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label></label>
                        <input type="password" required class="form-control" name="reg_pass" placeholder="${sessionScope.lang['pass']}">
                    </div>
                    <div class="form-group">
                        <label></label>
                        <input type="text" required class="form-control" name="reg_phone" placeholder="${sessionScope.lang['phone']}">
                    </div>
                    <button type="submit" class="btn btn-success">${sessionScope.lang['sign_up']}</button>
                    <div class="form-group">
                        ${requestScope.Status}
                    </div>
                </form>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
