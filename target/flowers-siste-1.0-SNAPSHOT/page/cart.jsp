<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.online != 'true'}">
    <c:redirect url="/auth"/>
</c:if>
<html>
<head>
    <title>Your cart</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container" style="margin-bottom: 35%">
        <c:forEach items="${sessionScope.cart}" var="entry">
            <div class="row">
                <div class="col-sm-3">
                    <img style="max-height: 300px;" class="img-responsive" src="${entry.key.imageUrl}"/>
                </div>
                <div class="product-cart-text col-sm-2">
                    <h3  >${entry.key.flowerName}</h3>
                </div>
                <div class="product-cart-text col-sm-2">
                    <h3 ><c:out value="${entry.key.price * entry.value}"/> $ </h3>
                </div>
                <div class="product-cart-text col-sm-2">
                    <h3 >${sessionScope.lang['quantity']} ${entry.value}</h3>
                </div>
                <div class="product-cart-text col-sm-3">
                    <button style="margin-top: 10px;" type="button" onclick="del('${entry.key.flowerNumber}')"
                            id="del_product" class="btn btn-warning">
                        ${sessionScope.lang['cart_delete']}
                    </button>
                </div>
            </div>
            <hr>
        </c:forEach>
        <%
            Map map = (Map) session.getAttribute("cart");
            if(map.size() == 0){%>
        <h3>Ваша корзина пуста!</h3>
        <%}else {%>
           <form action="${pageContext.request.contextPath}/issue">
                <button class="btn-success btn" type="submit">${sessionScope.lang['issue']}</button>
           </form>
        <%}
        %>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.js"></script>
    </div>
    <jsp:include page="footer.jsp"/>
    <script type="text/javascript" src="/js/tawk-to.js"></script>
</body>
</html>
