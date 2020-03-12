<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.online != 'true'}">
    <c:redirect url="/auth"/>
</c:if>
<html>
<head>
    <title>My orders</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
    <jsp:include page="../menu.jsp"/>
    <div class="container">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <%if(session.getAttribute("orders") == null){%>
                <h4>${sessionScope.lang['no_order']}</h4>
            <%}else {%>
            <div class="col-sm-1">
                #
            </div>
            <div class="col-sm-3">
                ${sessionScope.lang['issue_address']}
            </div>
            <div class="col-sm-5">
                ${sessionScope.lang['description']}
            </div>
            <div class="col-sm-3">
                ${sessionScope.lang['date']}
            </div>
                <c:forEach items="${sessionScope.orders}" var="o">
                    <div class="col-sm-1">
                        ${o.orderNum}
                    </div>
                    <div class="col-sm-3">
                        ${o.address}
                    </div>
                    <div class="col-sm-5">
                            ${o.description}
                    </div>
                    <div class="col-sm-3">
                            ${o.orderDate}
                    </div>
                </c:forEach>
            <%}%>
        </div>
        <div class="col-sm-1"></div>
    </div>
    <div style="padding: 200px 0;"></div>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
