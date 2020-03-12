<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div class="col-sm-4"></div>
                <div class="col-sm-4" style="border: 2px solid cadetblue; margin: 20% 0">
                    <h3><c:out value="${requestScope.RegStatus}"/></h3>
                    <script>
                        window.setTimeout(function() {
                            window.location.href = contextPath + '/auth';
                        }, 3000);
                    </script>
                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>
    </div>
</body>
</html>
