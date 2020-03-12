<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${sessionScope.product.flowerName}"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="product">
                    <img class="img-responsive" src="${sessionScope.flower.imageUrlBig}"/>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="title">
                    <h2>${sessionScope.flower.flowerName}</h2>
                    <h3>${sessionScope.flower.price} $</h3>
                    <c:set value="${sessionScope.flower.quantity}" scope="session" var="quantity"/>
                    <h3>${sessionScope.lang['quantity']} <c:out value="${quantity}"/></h3>
                </div>
                <div class="description">
                    <c:set value="${sessionScope.flower.description}" scope="session" var="description"/>
                    <h5>${sessionScope.lang.get(description)}</h5>
                </div>
                <div class="consist">
                    <c:set value="${sessionScope.flower.consisting}" scope="session" var="consisting"/>
                    <h6>${sessionScope.lang.get(consisting)}</h6>
                </div>
                <br>
                <hr>
                <div class="input-group" style="margin-bottom: 50px;">
                         <span class="input-group-btn">
                            <button style="margin-right: 45px;" id="add-cart" onclick="add('${sessionScope.flower.flowerNumber}','${sessionScope.lang['product_in_cart']}',
                                    '${sessionScope.lang['quantity_big']}','${sessionScope.lang['incorrect_cart']}')" class="btn btn-success">
                                ${sessionScope.lang['cart_add']}</button>
                         </span>
                        <span class="input-group-btn" >
                                <button type="button" class="btn btn-danger btn-number"  data-type="minus" data-field="quant[2]">
                                    <span class="glyphicon glyphicon-minus"></span>
                                </button>
                        </span>
                            <input style="width: 50px;
                                    border-radius: 15px;" type="text" id="quantity" name="quant[2]" class="form-control input-number" value="1" min="1" max="3">
                        <span class="input-group-btn">
                                <button type="button" class="btn btn-success btn-number" data-type="plus" data-field="quant[2]">
                                    <span class="glyphicon glyphicon-plus"></span>
                                </button>
                        </span>
                </div>
                <div class="result">
                    <h4 id="res"></h4>
                </div>
                <script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.js"></script>
                <script type="text/javascript" src="${pageContext.request.contextPath}/js/quantity.js"></script>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
    <script type="text/javascript" src="/js/tawk-to.js"></script>
</body>
</html>
