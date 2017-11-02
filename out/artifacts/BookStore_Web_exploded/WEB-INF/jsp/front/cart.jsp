<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
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
                <li class="active"><a href="#">我的购物车</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--<c:if test="${sessionScope.user == null }">--%>
                <%--<li><a href="${pageContext.request.contextPath}/register">欢迎光临请 注册</a></li>--%>

                <%--<li><a href="${pageContext.request.contextPath}/login">登陆</a></li>--%>

                <%--</c:if>--%>
                <%--<c:if test="${sessionScope.user != null }">--%>

                <%--<li><a href="${pageContext.request.contextPath}/logout">注销</a></li>--%>

                <%--<li><a href="#">欢迎！ ${sessionScope.user.nickName}</a></li>--%>

                <%--</c:if>--%>

                <%--<li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>--%>
            </ul>
        </div>
    </div>
</nav>

<h1 class="lead text-center">我的购物车</h1>

<div class="container">
    <form action="${pageContext.request.contextPath}/order" method="post">
        <table class="table table-bordered">
            <tr >
                <th class=" text-center">选择</th>
                <th class=" text-center">枪械名称</th>
                <th class=" text-center">制造商</th>
                <th class=" text-center">单价</th>
                <th class=" text-center">数量</th>
                <th class=" text-center">小计</th>
            </tr>
            <c:set var="money" value="0"></c:set>
                <c:forEach items="${carts}" var="cart">
                    <tr>
                        <td class=" text-center"><input type="checkbox" name="cid" value="${cart.cid}" checked></td>
                        <td><img src="${cart.icon}" style="width:70px; height:auto;">${cart.bname}</td>
                        <td class=" text-center">${cart.press}</td>
                        <td class=" text-center">${cart.price}</td>
                        <td class=" text-center">${cart.num}</td>
                        <td class=" text-center">${cart.price*cart.num} 元</td>
                    </tr>
                <c:set var="money" value="${money+cart.price*cart.num}"></c:set>
            </c:forEach>
            <tr>
                <td class=" text-center">总计：${money} 元</td>
                <input type="hidden" name="money" value="${money}">
                <td><input class="btn btn-primary btn-lg " type="submit" value="结算"></td>
            </tr>

        </table>
    </form>
</div>

</body>
</html>