<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>详情</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
    <style type="text/css">
        body {
            min-height: 1000px;
            padding-top: 70px;
            padding-bottom: 40px;
			padding-left: 250px;
            color: #5a5a5a;
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
				<li class="active"><a href="#">图书详情</a></li>
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

<div class="row">
    <div class="col-md-4 clearfix"><img src="${book.icon}" style="width:250px; height:auto" class="img-responsive center-block"></div>
    <div class="col-md-4">
        <div class="row"><h2>${book.bname }</h2></div>
        <div class="row">---------------------</div>
        <div class="row">${book.description }</div>
        <div class="row">---------------------</div>
        <div class="row">制造商：${book.press}</div>
        <div class="row">---------------------</div>
        <a href="${pageContext.request.contextPath}/buy/addcart/${book.bid}" class="btn btn-primary btn-lg">加入购物车</a>
    </div>

    <div class="col-md-4"></div>

</div>

	<%--<section>--%>
		<%--<aside>--%>
			<%--<img src="${book.icon}" style="width:200px; height:auto" class="img-responsive">--%>
			<%----%>
		<%--</aside>--%>
		<%----%>
		<%--<section>--%>
			<%--<p>${book.bname }</p>--%>
			<%--<p>${book.description }</p>--%>
			<%--<p>--%>
				<%--<span>作者：${book.author}</span>--%>
				<%--<span>出版社： ${book.press}</span>--%>
				<%--<span>出版日期： ${book.date}</span>--%>
			<%--</p>--%>
			<%--<p>${book.price}</p>--%>
			<%--<p><a href="${pageContext.request.contextPath}/buy/addcart${bood.bid}">加入购物车</a></p>--%>
		<%--</section>--%>
	<%--</section>--%>
</body>
</html>