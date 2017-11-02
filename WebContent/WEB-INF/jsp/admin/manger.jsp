<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
<style type="text/css">

	body {
		padding-top: 50px;
	}

	.navbar-fixed-top {
		border: 0;
	}

	.sidebar {
		display: none;
	}
	@media (min-width: 768px) {
		.sidebar {
			position: fixed;
			top: 51px;
			bottom: 0;
			left: 0;
			z-index: 1000;
			display: block;
			padding: 20px;
			overflow-x: hidden;
			overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
			background-color: #f5f5f5;
			border-right: 1px solid #eee;
		}
	}

	.nav-sidebar {
		margin-right: -21px; /* 20px padding + 1px border */
		margin-bottom: 20px;
		margin-left: -20px;
	}
	.nav-sidebar > li > a {
		padding-right: 20px;
		padding-left: 20px;
	}
	.nav-sidebar > .active > a,
	.nav-sidebar > .active > a:hover,
	.nav-sidebar > .active > a:focus {
		color: #fff;
		background-color: #428bca;
	}

	@media (min-width: 768px) {
		.main {
			padding-right: 40px;
			padding-left: 40px;
		}
	}
	.main .page-header {
		margin-top: 0;
	}

	.placeholders h4 {
		margin-bottom: 0;
	}
	.placeholder img {
		display: inline-block;
		border-radius: 50%;
	}

    frame{
        border: none;

    }
</style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">后台管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <%--<li><a href="#">Dashboard</a></li>--%>
                <%--<li><a href="#">Settings</a></li>--%>
                <%--<li><a href="#">Profile</a></li>--%>
                <li><a href="${pageContext.request.contextPath}/">退出</a></li>
            </ul>
            <%--<form class="navbar-form navbar-right">--%>
                <%--<input type="text" class="form-control" placeholder="Search...">--%>
            <%--</form>--%>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li onclick="addBook(this)"><a href="#">添加枪械 <span class="sr-only">(current)</span></a></li>
                <li onclick="bookList(this)"><a href="#">枪械列表</a></li>
                <li onclick="bookType(this)"><a href="#">枪械类型</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 ">
        <iframe id="iframe"
                src="${pageContext.request.contextPath}/book/addBook" width="100%" height="1155px"></iframe>
        </div>

	<script type="text/javascript">
		var iframe = document.getElementById("iframe");
		function addBook(oli) {
			iframe.src = "${pageContext.request.contextPath}/book/addBook"
		}
		function bookList(oli) {
			iframe.src = "${pageContext.request.contextPath}/book/bookList"
		}
		function bookType(oli) {
			iframe.src = "${pageContext.request.contextPath}/book/bookType"
		}
	</script>
</body>
</html>