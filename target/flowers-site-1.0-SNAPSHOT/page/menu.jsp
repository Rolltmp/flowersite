<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="language.jsp"/>
<nav class="navbar navbar-light my-menu">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li><a href="
            ${pageContext.request.contextPath}/main">${sessionScope.lang.get("main")}
                <span class="sr-only">(current)</span></a></li>
            <li><a href="${pageContext.request.contextPath}/flowers">${sessionScope.lang["bouquet"]}</a></li>
            <li><a href="${pageContext.request.contextPath}/about">${sessionScope.lang['about']}</a></li>
            <li><a href="${pageContext.request.contextPath}/contact">${sessionScope.lang['contact']}</a></li>
            <li><a href="${pageContext.request.contextPath}/cart">
            ${sessionScope.lang['cart']}</a></li>
            <c:choose>
                <c:when test="${sessionScope.online == 'true'}">
                    <li class="dropdown">
                        <a id="drop2" href="#" class="dropdown-toggle"
                           data-toggle="dropdown">${sessionScope.user.email}
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><form action="${pageContext.request.contextPath}/account">
                                <input type="hidden" name="type" value="edit"/>
                                <button type="submit" class="btn-link text-center"><span class="dp">
                                ${sessionScope.lang['acc_edit']}</span></button></form></li>
                            <li><form action="${pageContext.request.contextPath}/account" method="get">
                                <input type="hidden" name="type" value="order"/>
                                <button type="submit" class="btn-link text-center"><span class="dp">
                                    ${sessionScope.lang['my_order']}
                                </span></button></form></li>
                            <li><a class="btn-link text-center" href="
                                ${pageContext.request.contextPath}/logout">${sessionScope.lang['logout']}</a></li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a class="nav-item nav-link" href="
                    ${pageContext.request.contextPath}/auth">${sessionScope.lang['login']}</a></li>
                </c:otherwise>
            </c:choose>
            <li class="dropdown">
                <a id="drop1" href="#" class="dropdown-toggle"
                       data-toggle="dropdown">${sessionScope.lang['language']}
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><form action="${pageContext.request.contextPath}/switch">
                        <input type="hidden" name="language" value="english"/>
                        <button type="submit" class="btn-link text-center"><span class="dp">
                            <img src="${pageContext.request.contextPath}/image/UK.png"/>
                        </span></button></form></li>
                    <li><form action="${pageContext.request.contextPath}/switch" method="get">
                        <input type="hidden" name="language" value="russian"/>
                        <button type="submit" class="btn-link text-center"><span class="dp"> <img src="${pageContext.request.contextPath}/image/RU.png"/></span></button></form></li>
                   <li> <form action="${pageContext.request.contextPath}/switch">
                       <input type="hidden" name="language" value="hebrew"/>
                       <button type="submit" class="btn-link text-center"><span class="dp"> <img src="${pageContext.request.contextPath}/image/ISR.png"/></span></button></form></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>