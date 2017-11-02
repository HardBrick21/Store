<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商城首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
    <style type="text/css">
        body {
            min-height: 2000px;
            padding-top: 70px;
            padding-bottom: 40px;
            color: #5a5a5a;
            background-color: #f5f5f5;
        }

        figure {
            float: left;
            text-align: center;
            padding: 30px;
        }

        .navbar-wrapper > .container {
            padding-right: 0;
            padding-left: 0;
        }

        .navbar-wrapper .navbar {
            padding-right: 15px;
            padding-left: 15px;
        }

        .navbar-wrapper .navbar .container {
            width: auto;
        }

        .carousel .item {
            height: 500px;
            background-color: #777;
        }

        .carousel-inner > .item > img {
            position: absolute;
            top: 0;
            left: 0;
            min-width: 100%;
            height: 500px;
        }

        .marketing .col-lg-4 {
            margin-bottom: 20px;
            text-align: center;
        }

        .marketing h2 {
            font-weight: normal;
        }

        .marketing .col-lg-4 p {
            margin-right: 10px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header"">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">军火商城</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">主页</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.user == null }">
                    <li><a href="${pageContext.request.contextPath}/register">欢迎光临请 注册</a></li>

                    <li><a href="${pageContext.request.contextPath}/login">登陆</a></li>

                </c:if>
                <c:if test="${sessionScope.user != null }">

                    <li><a href="${pageContext.request.contextPath}/logout">注销</a></li>

                    <li><a href="${pageContext.request.contextPath}/userCenter/${sessionScope.user.uid}">欢迎！ ${sessionScope.user.nickName}</a></li>
                    <li><img src="${sessionScope.user.photo}" alt="无头像"
                             style="width: auto; height: 40px; margin-top: 5px;"
                             class="img-circle"></li>
                    <li><a href="${pageContext.request.contextPath}/buy/cart">我的购物车</a></li>
                    <li><a href="${pageContext.request.contextPath}/myOrder">我的订单</a></li>
                    <form class="navbar-form navbar-left" method="post"
                          action="${pageContext.request.contextPath}/book/search">
                        <div class="col-lg-15">
                            <div class="input-group">

                                    <%--条件搜索。。以后再说吧--%>
                                    <%--<div class="input-group-btn">--%>
                                    <%--<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">枪名 <span class="caret"></span></button>--%>
                                    <%--<ul class="dropdown-menu">--%>
                                    <%--<li><a href="#">产地</a></li>--%>
                                    <%--</ul>--%>
                                    <%--</div>--%>

                                <input type="text" class="form-control" placeholder="请输入搜索内容..." name="search">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">搜索!</button>
                                </span>
                            </div><!-- /input-group -->
                        </div><!-- /.col-lg-6 -->
                    </form>

                </c:if>

            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img class="first-slide" src="/icon/fj1.jpg" alt="First slide">
            </div>
            <div class="item">
                <img class="second-slide" src="/icon/fj2.jpg" alt="Second slide">
            </div>
            <div class="item">
                <img class="third-slide" src="/icon/fj3.jpg" alt="Third slide">
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <hr style="border: 1px solid #c0c0c0">
    <div class="row">
        <h2>步枪</h2>
        <hr>
    </div>
    <div class="visible-lg-inline-block">
        <c:forEach items="${hotbooks}" var="book">
            <c:if test="${book.tid == 1}">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="${pageContext.request.contextPath}/bookinfo/${book.bid}"> <img src="${book.icon}"
                                                                                                alt="..."
                                                                                                style="height: 230px; width:300px;"></a>
                        <div class="caption">
                            <h3>${book.bname }</h3>
                            <p>${book.price }元</p>
                            <p><a href="${pageContext.request.contextPath}/bookinfo/${book.bid}" class="btn btn-primary"
                                  role="button">查看详情</a>
                                <a href="${pageContext.request.contextPath}/buy/addcart/${book.bid}"
                                   class="btn btn-default" role="button">加入购物车</a></p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <div class="row">
        <h2>冲锋枪</h2>
        <hr>
    </div>
    <div class="visible-lg-inline-block">
        <c:forEach items="${hotbooks}" var="book">
            <c:if test="${book.tid == 2}">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="${pageContext.request.contextPath}/bookinfo/${book.bid}"> <img src="${book.icon}"
                                                                                                alt="..."
                                                                                                style="height: 230px; width:300px;"></a>
                        <div class="caption">
                            <h3>${book.bname }</h3>
                            <p>${book.price }元</p>
                            <p><a href="${pageContext.request.contextPath}/bookinfo/${book.bid}" class="btn btn-primary"
                                  role="button">查看详情</a>
                                <a href="${pageContext.request.contextPath}/buy/addcart/${book.bid}"
                                   class="btn btn-default" role="button">加入购物车</a></p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <div class="row">
        <h2>机枪</h2>
        <hr>
    </div>
    <div class="visible-lg-inline-block">
        <c:forEach items="${hotbooks}" var="book">
            <c:if test="${book.tid == 3}">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="${pageContext.request.contextPath}/bookinfo/${book.bid}"> <img src="${book.icon}"
                                                                                                alt="..."
                                                                                                style="height: 230px; width:300px;"></a>
                        <div class="caption">
                            <h3>${book.bname }</h3>
                            <p>${book.price }元</p>
                            <p><a href="${pageContext.request.contextPath}/bookinfo/${book.bid}" class="btn btn-primary"
                                  role="button">查看详情</a>
                                <a href="${pageContext.request.contextPath}/buy/addcart/${book.bid}"
                                   class="btn btn-default" role="button">加入购物车</a></p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <div class="row">
        <h2>手枪</h2>
        <hr>
    </div>
    <div class="visible-lg-inline-block">
        <c:forEach items="${hotbooks}" var="book">
            <c:if test="${book.tid == 4}">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="${pageContext.request.contextPath}/bookinfo/${book.bid}"> <img src="${book.icon}"
                                                                                                alt="..."
                                                                                                style="height: 230px; width:300px;"></a>
                        <div class="caption">
                            <h3>${book.bname }</h3>
                            <p>${book.price }元</p>
                            <p><a href="${pageContext.request.contextPath}/bookinfo/${book.bid}" class="btn btn-primary"
                                  role="button">查看详情</a>
                                <a href="${pageContext.request.contextPath}/buy/addcart/${book.bid}"
                                   class="btn btn-default" role="button">加入购物车</a></p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <div class="row">
        <h2>散弹枪</h2>
        <hr>
    </div>
    <div class="visible-lg-inline-block">
        <c:forEach items="${hotbooks}" var="book">
            <c:if test="${book.tid == 5}">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="${pageContext.request.contextPath}/bookinfo/${book.bid}"> <img src="${book.icon}"
                                                                                                alt="..."
                                                                                                style="height: 230px; width:300px;"></a>
                        <div class="caption">
                            <h3>${book.bname }</h3>
                            <p>${book.price }元</p>
                            <p><a href="${pageContext.request.contextPath}/bookinfo/${book.bid}" class="btn btn-primary"
                                  role="button">查看详情</a>
                                <a href="${pageContext.request.contextPath}/buy/addcart/${book.bid}"
                                   class="btn btn-default" role="button">加入购物车</a></p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <hr style="border: 1px solid #c0c0c0">
    <div class="text-center">已经到底了哦</div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>