<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
</head>
<style type="text/css">
    body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: rgb(246, 246, 246);
        /*background: url(" ../../../resource/image/back1.png") no-repeat 100% 100%;*/
    }

    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }

    form {
        background-color: white;
        border: 0.1px solid rgb(204, 204, 204);
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
<script type="text/javascript">
    function repassword() {

        var pw = document.getElementById('passWord').value;
        var pw2 = document.getElementById('repassWord').value;

        if (pw != pw2) {
            window.alert("两次密码输入不一致，请重试");
            return false;
        }

        return true;

    }
</script>
<body>
<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/register" method="post"
          enctype="multipart/form-data">
        <h2 class="text-center">注册</h2>
        <c:if test="${requestScope.msg} ">
        <h4 class="alert alert-success" role="alert">${requestScope.msg}</h4>
        </c:if>

        <lable class="label label-default">用户名</lable>
        <input type="text" name="userName" class="form-control" placeholder="请输入用户名" required autofocus>


        <lable class="label label-default">密码</lable>
        <input type="password" name="passWord" id="passWord" class="form-control" placeholder="请输入密码" required>


        <lable class="label label-default">确认密码</lable>
        <input type="password" name="repassWord" id="repassWord" class="form-control" placeholder="请确认密码" onblur='repassword()' required>


        <lable class="label label-default">昵称</lable>
        <input type="text" name="nickName" class="form-control" placeholder="请输入昵称" required>


        <lable class="label label-default">邮箱</lable>
        <input type="text" name="email" class="form-control" placeholder="请输入邮箱" required>

        <div>
            <lable class="label label-default">性别</lable>
            <input type="radio" name="gender" value="man" class="checkbox-inline">男
            <input type="radio" name="gender" value="woman" class="checkbox-inline">女
        </div>

        <lable class="label label-default">头像</lable>
        <input type="file" name="photofile">
        <div>
            <button class="btn btn-lg btn-success btn-block " type="submit">注册</button>
        </div>
        <hr style="margin-top:12px;">
        <div class="form-horizontal">
            <div class="clearfix">
                <div class="pull-left">
                    <p class="form-control-static">已有账户？</p>
                </div>
                <div class="pull-right"><a href="${pageContext.request.contextPath}/login"
                                           class="btn btn-outline btn-default">登陆</a></div>
            </div>
        </div>


</div>

</form>
</div>

</body>
</html>