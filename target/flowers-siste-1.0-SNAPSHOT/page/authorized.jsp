<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.online == 'true'}">
    <c:redirect url="/main"/>
</c:if>
<%--<c:choose>
    <c:when test="${sessionScope.online != 'true'}">
        <c:redirect url="/auth"/>
    </c:when>
    <c:otherwise>
        <c:redirect url="/main"/>
    </c:otherwise>
</c:choose>--%>
