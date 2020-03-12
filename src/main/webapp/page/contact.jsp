<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d218096.72463565634!2d34.60819865051218!3d31.33796404985433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x150266140149aba9%3A0x4074e3fcb66f7403!2zSGVydHNlbCA5NiwgQmVlcnNoZWJhLCDQhtC30YDQsNGX0LvRjA!5e0!3m2!1suk!2sua!4v1501078993685" width="100%" height="600" frameborder="0" style="border:0" allowfullscreen></iframe>
        <div class="about">
            ${sessionScope.lang['contact_help']}, email: flower.support@gmail.com
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
