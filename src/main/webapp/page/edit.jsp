<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.online != 'true'}">
    <c:redirect url="/auth"/>
</c:if>
<html>
<head>
    <title>Edit my profile</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <h2 class="text-center">${sessionScope.lang['profile']}</h2>
        <hr>
        <div class="col-sm-12">
            <h4>${sessionScope.lang['name']}</h4>
            <div class="form-group">
                <input type="text" required id="name" class="form-control" value="${sessionScope.user.userName}">
            </div>
            <h4>${sessionScope.lang['pass']}</h4>
            <div class="form-group">
                <input type="text" required id="phone" class="form-control" value="${sessionScope.user.userPhone}">
            </div>
            <button class="btn btn-success" type="button" onclick="edit(
                    '${sessionScope.lang['update_success']}', 
                '${sessionScope.lang['incorrect_cart']}'
            )"
                    id="edit">${sessionScope.lang['edit']}</button>
            <div style="margin-top: 100px;" id="res_update"></div>
        </div>
        <h2 class="text-center">${sessionScope.lang['change_pass']}</h2>
        <hr>
        <div class="col-sm-12">
            <h4>${sessionScope.lang['enter_password']}</h4>
            <div class="form-group">
                <input class="form-control" required type="password" id="password" value="">
            </div>
            <h4>${sessionScope.lang['enter_password_2']}</h4>
            <div class="form-group">
                <input class="form-control" required type="password" id="password_2" value="">
            </div>
            <button class="btn btn-success" type="button" onclick="changePassword(
                    '${sessionScope.lang['change_success']}',
                    '${sessionScope.lang['incorrect_cart']}',
                    '${sessionScope.lang['dont_match']}'
            )"
                    id="update">${sessionScope.lang['change']}</button>
            <div style="margin-top: 100px;" id="res_change"></div>
        </div>
        <script src="${pageContext.request.contextPath}/js/account.js"></script>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
