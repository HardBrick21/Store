<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理-列表</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
	<style type="text/css">
		th{text-align: center}
	</style>
</head>

<body>
	<h1 class="lead text-center">枪械列表</h1>
	
	<table class="table table-bordered text-center ">
		<tr>
			<%--<th>删除--%>
			<th>ID
			<th>名称
			<th>图片
			<th>生产商
			<th>价格
			<%--<th>--%>
			
		</tr>
		<c:forEach items="${books}"  var="book">
			<tr>
				<%--<td><input type="checkbox" name="bid"></td>--%>
				<td>${book.bid}</td>
				<td>${book.bname}</td>
				<td><img src="${book.icon}" alt="无封面" 
				style="width:50px; height:auto" ></td>
				<td>${book.press}</td>
				<td>${book.price}</td>
				<%--<td><a href="#">修改</a></td>--%>
			</tr>
		</c:forEach>

	</table>
</body>
</html>