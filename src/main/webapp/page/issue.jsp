<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.online != 'true'}">
    <c:redirect url="/auth"/>
</c:if>
<%
    Map map = (Map) session.getAttribute("cart");
    if(map.size() == 0){%>
    <c:redirect url="/cart"/>
    <%}%>
<c:set var="total" value="${0}"/>
<html>
<head>
    <title>Issue</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <div class="col-sm-12">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="order-title">
                    <center>${sessionScope.lang['order']}</center>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>

        <div class="col-sm-12">
            <div class="col-sm-2"></div>
            <div class="col-sm-2"><h3>#</h3></div>
            <div class="col-sm-2"><h3>${sessionScope.lang['title']}</h3></div>
            <div class="col-sm-2"><h3>${sessionScope.lang['quantity']}</h3></div>
            <div class="col-sm-2"><h3>${sessionScope.lang['filter_price']}</h3></div>
            <div class="col-sm-2"></div>
        </div>
        <c:forEach items="${sessionScope.cart}" var="entry">
            <div class="col-sm-12" style="border-bottom: 1px solid silver;">
                <div class="col-sm-2"></div>
                <div class="col-sm-2" style="border-right: 1px solid silver;">
                    <h5>${entry.key.flowerNumber}</h5></div>
                <div class="col-sm-2" style="border-right: 1px solid silver;">
                    <h5>${entry.key.flowerName}</h5></div>
                <div class="col-sm-2" style="border-right: 1px solid silver;">
                    <h5>${entry.value}</h5></div>
                <div class="col-sm-2" style="border-right: 1px solid silver;">
                    <h5>${entry.key.price}</h5></div>
                <div class="col-sm-2"></div>
            </div>
            <c:set var="total" value="${total + entry.key.price}"/>
        </c:forEach>
            <div class="col-sm-12">
                <div class="col-sm-8"></div>
                <div class="col-sm-2" style="margin: 100px 0;">
                    <h5>${sessionScope.lang['total']}: ${total}</h5>
                </div>
                <div class="col-sm-2"></div>
            </div>
        <%if(session.getAttribute("remainder") != null){%>
        <div class="col-sm-12">
            <c:forEach items="map" var="entry">
                <div class="row">
                    <h4>${sessionScope.lang['you_try']} ${entry.key.flowerName}
                    ${sessionScope.lang['only_have']} ${entry.value} ${sessionScope.lang['pt']}</h4>
                </div>
            </c:forEach>
        </div>
        <%}%>
            <div class="col-sm-12">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <div class="center-block order-title">
                        <center>${sessionScope.lang['form']}</center>
                    </div>
                </div>
                <div class="col-sm-3"></div>
            </div>

            <div class="col-sm-12">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <form method="post" action="${pageContext.request.contextPath}/issue">
                        <div class="form-group">
                            <input type="hidden" name="total" value="${total}">
                            <input name="address" placeholder="${sessionScope.lang['issue_address']}"
                                   type="text" class="form-control" maxlength="250" min="2" required>
                        </div>
                        <div class="form-group">
                            <label>${sessionScope.lang['issue_description']}</label>
                            <textarea rows="20" name="description" class="form-control">
                            </textarea>
                        </div>
                        <button style="margin: 75px 0;" type="submit" class="btn-success btn">
                            ${sessionScope.lang['pay']}
                        </button>
                    </form>
                </div>
                <div class="col-sm-3"></div>
            </div>
    </div>
    <%if(session.getAttribute("pay_error") != null){%>
    <script>
        alert('${sessionScope.pay_error}');
    </script>
    <%} session.setAttribute("pay_error", null);%>
    <jsp:include page="footer.jsp"/>
</body>
</html>
