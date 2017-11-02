<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Houlixuan
  Date: 2017/10/31
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
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
                <li class="active"><a href="#">我的订单</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

            </ul>
        </div>
    </div>
</nav>

<h1 class="lead text-center">我的订单</h1>

<div class="container">
        <table class="table table-bordered">
            <tr >
                <th class=" text-center">订单编号</th>
                <th class=" text-center">姓名</th>
                <th class=" text-center">电话</th>
                <th class=" text-center">地址</th>
                <th class=" text-center">总价</th>
                <th class=" text-center"></th>
            </tr>

            <c:forEach items="${orders}" var="order">
                <tr>
                    <td class=" text-center">${order.ono}</td>
                    <td class=" text-center">${order.userName}</td>
                    <td class=" text-center">${order.phone}</td>
                    <td class=" text-center">${order.address}</td>
                    <td class=" text-center">${order.price}</td>
                    <c:if test="${order.status == \"Underway\"}">
                    <td class=" text-center"><a href="${pageContext.request.contextPath}/status/${order.oid}"
                                                class="btn btn-outline btn-default">完成</a></td>
                    </c:if>
                    <c:if test="${order.status == \"OrderCompleted\"}">
                        <td class=" text-center">已完成</td>

                    </c:if>
                </tr>
            </c:forEach>

        </table>
    </form>
</div>
</body>
</html>
