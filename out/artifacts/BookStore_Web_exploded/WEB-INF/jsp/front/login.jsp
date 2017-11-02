<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商城-登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: rgb(246, 246, 246);
            /*background: url(" ../../../resource/image/back1.png") no-repeat 100% 100%;*/
        }

        form {
            border: 1px solid rgb(204, 204, 204);
            background-color: white;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="userName"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>

<body>
<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="text-center">登陆</h2>

        <h4>${requestScope.msg}</h4>

        <label for="inputUserName" class="label label-default">用户名</label>
        <input type="text" class="form-control" id="inputUserName" placeholder="请输入用户名" name="userName" autofocus>
        <label for="inputPassword" class="label label-default">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" name="passWord">
        <label for="inputCode" class="label label-default">输入验证码</label>
        <input type="code" id="inputCode" class="form-control" placeholder="请输入验证码" name="code">
        <%--<img alt="无" src="${pageContext.request.contextPath}/code">--%>
        <div class="media-left ">
            <a href="#">
                <img class="media-object" src="${pageContext.request.contextPath}/code">
            </a>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住密码
            </label>
        </div>
        <div>

            <button class="btn btn-lg btn-success btn-block " type="submit">登陆</button>
        </div>
        <hr style="margin-top:12px;">
        <div class="form-horizontal">
            <div class="clearfix">
                <div class="pull-left">
                    <p class="form-control-static">还没有账户？</p>
                </div>
                <div class="pull-right"><a href="${pageContext.request.contextPath}/register" class="btn btn-outline btn-default">注册</a></div>
            </div>
        </div>

    </form>

</div>
</body>
</html>