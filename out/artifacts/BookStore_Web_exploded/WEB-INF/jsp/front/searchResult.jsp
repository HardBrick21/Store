<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Houlixuan
  Date: 2017/10/30
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
    <style type="text/css">
        body {
            min-height: 900px;
            padding-top: 70px;
            padding-bottom: 40px;
            color: #5a5a5a;
            background-color: #f5f5f5;
        }

    </style>
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
                <li class="active"><a href="#">搜索结果</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                    <li><a href="${pageContext.request.contextPath}/">返回首页</a></li>

                <%--<li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>--%>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <table class="table table-bordered text-center ">
        <tr>
            <th class="text-center">图片</th>
            <th class="text-center">名字</th>
            <th class="text-center">生产商</th>
            <th class="text-center">价格</th>
            <th></th>
        </tr>
        <c:forEach items="${searchReault}" var="searchReault">
        <tr>
            <td class="text-center"><img src="${searchReault.icon}" alt="无图片" style="width: 80px; height: auto"></td>
            <td class="text-center">${searchReault.bname}</td>
            <td class="text-center">${searchReault.press}</td>
            <td class="text-center">${searchReault.price}元</td>
            <td class="text-center"><a href="${pageContext.request.contextPath}/buy/addcart/${searchReault.bid}" class="btn btn-primary btn-lg">加入购物车</a></td>
        </tr></c:forEach>
    </table>

</div>
</body>
</html>
