<%--
  Created by IntelliJ IDEA.
  User: Houlixuan
  Date: 2017/11/1
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
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

                    <li><a href="#">欢迎！ ${sessionScope.user.nickName}</a></li>
                    <li><img src="${sessionScope.user.photo}" alt="无头像"
                             style="width: auto; height: 40px; margin-top: 5px;"
                             class="img-circle"></li>
                    <li><a href="${pageContext.request.contextPath}/buy/cart">我的购物车</a></li>
                    <li><a href="${pageContext.request.contextPath}/myOrder">我的订单</a></li>

                </c:if>

            </ul>
        </div>
    </div>
</nav>
</body>
</html>
