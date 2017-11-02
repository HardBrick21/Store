<%--
  Created by IntelliJ IDEA.
  User: Houlixuan
  Date: 2017/11/1
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户中心</title>
    <meta charset="utf-8" />
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/main.css" />
    <noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/noscript.css" /></noscript>

</head>
<body class="is-loading">
<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <section id="main">
        <header>
            <span class="avatar"><img src="${user.photo}" alt="无头像" /></span>
            <h1>${user.nickName}</h1>
            <p>${user.userName}</p>
        </header>

        <hr />
        <h2>修改信息</h2>
        <form method="post" action="${pageContext.request.contextPath}/alertInfor/${user.uid}">
            <div class="field">
                <input type="text" name="nickName" id="name" placeholder="昵称" />
            </div>
            <ul class="actions">
                <li><input type="submit" class="button" value="修改"></li>
                <li><a href="${pageContext.request.contextPath}/" class="button">返回首页</a></li>
            </ul>
        </form>
        <hr />

        <footer>
            <ul class="icons">
                <li><a href="#" class="fa-twitter">Twitter</a></li>
                <li><a href="#" class="fa-instagram">Instagram</a></li>
                <li><a href="#" class="fa-facebook">Facebook</a></li>
            </ul>
        </footer>
    </section>


</div>

<script>
    if ('addEventListener' in window) {
        window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
        document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
    }
</script>


</body>
</html>
