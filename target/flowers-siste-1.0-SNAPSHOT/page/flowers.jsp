<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flowers</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <div class="row">
            <form action="${pageContext.request.contextPath}/flowers" method="post" class="form-inline">
                <div class="form-group">
                    <label>${sessionScope.lang['filter_price']}</label>
                    <div class="range range-success" style="width: 40%;">
                        <input type="range" name="price" min="${sessionScope.min_price}"
                               max="${sessionScope.max_price}" value="${sessionScope.value_price}"
                               onchange="rangeSuccess.value=value">
                        <output id="rangeSuccess">${sessionScope.value_price}</output>
                    </div>
                </div>
                <button class="btn margin-btn btn-success" type="submit">${sessionScope.lang['find']}</button>
            </form>
            <form class="form-inline" method="get">
                <input type="hidden" name="off" value="true">
                <button type="submit" class="btn margin-btn btn-success">
                ${sessionScope.lang['filter_off']}</button>
            </form>
        </div>
        <c:forEach items="${sessionScope.products}" var="product">
            <div class="col-sm-6 col-md-4">
                <div class="product">
                    <form id="${product.flowerNumber}" action="flower"><a
                            onclick="submitForm('${product.flowerNumber}')" href="#">
                    <div class="image">
                        <img class="img-responsive" src="<c:out value="${product.imageUrl}"/>"/>
                    </div>
                    </a>
                        <input type="hidden" value="${product.flowerNumber}" name="flower_num">
                    </form>
                    <h4 class="text-center"><c:out value="${product.flowerName}"/></h4>
                    <h4 class="text-center"><c:out value="${product.price}"/> $</h4>
                </div>
            </div>
        </c:forEach>
    </div>
    <script>
        function submitForm(id) {
            document.getElementById(id).submit();
        }
    </script>
    <jsp:include page="footer.jsp"/>
    <script type="text/javascript" src="/js/tawk-to.js"></script>
</body>
</html>
