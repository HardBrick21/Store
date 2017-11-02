<%--
  Created by IntelliJ IDEA.
  User: Houlixuan
  Date: 2017/10/30
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单处理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
    <style type="text/css">
        body {
            min-height: 2000px;
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
                <li class="active"><a href="#">提交订单</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${user != null }">
                    <li><a href="${pageContext.request.contextPath}/logout">注销</a></li>

                    <li><a href="#">欢迎！ ${user.nickName}</a></li>
                    <li><img src="${user.photo}" alt="无头像" style="width: auto; height: 40px; margin-top: 5px;"
                             class="img-circle"></li>
                    <li><a href="${pageContext.request.contextPath}/buy/cart">我的购物车</a></li>
                </c:if>

                <%--<li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>--%>
            </ul>
        </div>
    </div>
</nav>

<div class="container ">

    <div class="table-bordered">
        <div class="row">

            <h3 class="text-center">订单内容</h3>

        </div>
        <div class="row center-block">
            <div class="col-xs-12">
                <div class="col-md-1"></div>
                <div class="col-md-2"><h4>图片</h4></div>
                <div class="col-md-2"><h4>名称</h4></div>
                <div class="col-md-2"><h4>数量</h4></div>
                <div class="col-md-2"><h4>单价</h4></div>
                <div class="col-md-2"><h4>小计</h4></div>
            </div>
        </div>
        <c:forEach items="${cart}" var="cart">
            <div class="row center-block">
                <div class="col-xs-12">
                    <div class="col-md-1"></div>
                    <div class="col-md-2"><img src="${cart.icon}" alt="无图片" style="width: 60px;height: auto"></div>
                    <div class="col-md-2">${cart.bname}</div>
                    <div class="col-md-2">${cart.num}</div>
                    <div class="col-md-2">${cart.price}</div>
                    <div class="col-md-2">${cart.price*cart.num}元</div>
                </div>

            </div>
        </c:forEach>
        <div class="row center-block">
            <div class="col-xs-12">
                <div class="col-md-4"></div>
                <div class="col-md-4"></div>
                <hr>
            </div>

        </div>
        <div class="row center-block">
            <div class="col-xs-12">
                <div class="col-md-4"><h3>总价：${money} 元</h3></div>
                <div class="col-md-4"></div>
            </div>

        </div>
    </div>
    <form action="${pageContext.request.contextPath}/addOrder" method="post" class="form-horizontal">
        <h1 class="lead text-center">收货信息</h1>
        <div class="form-group">
            <label class="col-sm-2 control-label">用户编号：</label>
            <div class="col-xs-4"><h5>${user.uid}</h5></div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">邮箱：</label>
            <div class="col-xs-4"><h5>${user.email}</h5></div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名：</label>
            <div class="col-xs-4"><input type="text" name="userName" placeholder="请输入姓名" class="form-control" required></div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">电话：</label>
            <div class="col-xs-4"><input type="text" name="phone" placeholder="请输入电话" class="form-control" required></div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">地址：</label>
            <div class="col-xs-4"><input type="text" name="address" placeholder="请输收货地址" class="form-control" required></div>
        </div>
        <div class="form-group">
            <div class="col-xs-10">
                <label class="col-sm-3 control-label"></label>
                <input type="hidden" name="money" id="" value="${money}">
                <input type="submit" value="提交" class="btn btn-info"></div>
        </div>

    </form>
</div>

</body>
</html>
