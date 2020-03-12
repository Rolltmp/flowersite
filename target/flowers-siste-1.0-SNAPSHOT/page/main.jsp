<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <style>
        .navbar{
            margin-bottom: 0;
        }
    </style>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">

            <div class="item active">
                <img class="img-responsive" src="${pageContext.request.contextPath}/image/flower1.jpg" alt="Flower 1">
                <div class="carousel-caption">
                    <a href="${pageContext.request.contextPath}/flowers" target="_blank">
                        <button type="button" class="btn-lg btn button-slide">
                    ${sessionScope.lang['send']}</button></a>
                </div>
            </div>

            <div class="item">
                <img class="img-responsive" src="${pageContext.request.contextPath}/image/flower2.jpg" alt="Flower 2">
                <div class="carousel-caption">
                    <a href="${pageContext.request.contextPath}/about" target="_blank">
                        <button type="button" class="btn-lg btn button-slide">
                            ${sessionScope.lang['about']}</button></a>
                </div>
            </div>

            <div class="item">
                <img class="img-responsive" src="${pageContext.request.contextPath}/image/flower3.jpg" alt="Flower 3">
                <div class="carousel-caption">
                    <a href="${pageContext.request.contextPath}/contact" target="_blank">
                        <button type="button" class="btn-lg btn button-slide">
                            ${sessionScope.lang['contact']}</button></a>
                </div>
            </div>

<%--            <div class="item">
                <img src="http://placehold.it/1400x400" alt="slide">
            </div>--%>

        </div>

    <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>

    </div>
<%--    <div id="myCarousel" class="carousel slide">
        <div class="carousel-buttons">
            <div class="col-xs-3 text-center"><a data-target="#myCarousel" data-slide-to="0" href="#">Go to Slide One</a></div>
            <div class="col-xs-3 text-center"><a data-target="#myCarousel" data-slide-to="1" href="#">Go to Slide Two</a></div>
        </div>
        <div class="carousel-inner">
            <div class="item">
                <img src="${pageContext.request.contextPath}/image/flower2.jpg" alt="Flower 2">
                <div class="container">
                    <div class="carousel-caption">
                    </div>
                </div>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/image/flower1.jpg" alt="Flower 1">
                <div class="container">
                    <div class="carousel-caption">
                    </div>
                </div>
            </div>
        </div>

    </div>--%>
<%--    <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
            </ol>
            <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div style="position: relative;" class="item active">
                        <button  class="button-slide btn btn-success">Button</button>
                        <img  src="${pageContext.request.contextPath}/image/flower1.jpg" alt="Flower 1">
                    </div>
                <div style="position: relative;" class="item">
                    <button  class="button-slide btn btn-success">Button</button>
                    <img
                         src="${pageContext.request.contextPath}/image/flower2.jpg" alt="Flower 2">
                </div>
            </div>
            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>--%>
    <div class="container">
        <div class="row">
            <%--<div class="col-sm-6">
                <div id="slider">
                    <div class="screen">
                        <ul>
                            <li><img src="http://xinkyo.firebird.jp/codepen/iphone_slide01.jpg"></li>
                            <li><img src="http://xinkyo.firebird.jp/codepen/iphone_slide02.jpg"></li>
                        </ul>
                        <img src="http://xinkyo.firebird.jp/codepen/iphone_screen.png" class="scpic">
                    </div>
                    <a href="#" id="sliderNext"><img src="http://xinkyo.firebird.jp/codepen/iphone_arrow_right.png"></a>
                    <a href="#" id="sliderPrev"><img src="http://xinkyo.firebird.jp/codepen/iphone_arrow_left.png"></a>
                </div>
                <script src="${pageContext.request.contextPath}/js/iphone.js"></script>
            </div>--%>
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <h2 class="text-center">${sessionScope.lang['main_title']}</h2>
                <br><br>
                <div class="row">
                    <div class="col-sm-3">
                        <img width="75%" src="${pageContext.request.contextPath}/image/rose.svg"
                             alt="rose">
                    </div>
                    <div class="col-sm-9">
                        <h3>${sessionScope.lang['step1']}</h3>
                        <h5>${sessionScope.lang['step1_txt']}</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3">
                        <img width="75%" src="${pageContext.request.contextPath}/image/car.svg"
                             alt="car">
                    </div>
                    <div class="col-sm-9">
                        <h3>${sessionScope.lang['step2']}</h3>
                        <h5>${sessionScope.lang['step2_txt']}</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3">
                        <img width="75%" src="${pageContext.request.contextPath}/image/happy.svg"
                             alt="happy">
                    </div>
                    <div class="col-sm-9">
                        <h3>${sessionScope.lang['step3']}</h3>
                        <h5>${sessionScope.lang['step3_txt']}</h5>
                    </div>

                </div>
            </div>
                <div class="col-sm-3"></div>
        </div>
        <hr>
        <div class="row">
            <h2 class="text-center">${sessionScope.lang['delivery']}</h2>
            <br>
        </div>
    </div>
    <div class="overlay" onClick="style.pointerEvents='none'"></div>
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d218096.72463565634!2d34.60819865051218!3d31.33796404985433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x150266140149aba9%3A0x4074e3fcb66f7403!2zSGVydHNlbCA5NiwgQmVlcnNoZWJhLCDQhtC30YDQsNGX0LvRjA!5e0!3m2!1suk!2sua!4v1501078993685" width="100%" height="550" frameborder="0" style="border:0" allowfullscreen></iframe>
    <script>
        $(document).ready(function(){
            $('.overlay').click(function() {
                $(this).remove();
            });
        });
    </script>
    <jsp:include page="footer.jsp"/>
    <script type="text/javascript" src="/js/tawk-to.js"></script>
</body>
</html>