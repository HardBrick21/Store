<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-类型</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
</head>
<body>
<h1 class="lead text-center">添加枪械类型</h1>

<form action="${pageContext.request.contextPath}/book/addbooktype" method="get">

    <div class="form-group">
        <strong>${requestScope.msg}</strong>
        <label class="col-sm-2 control-label"></label>
        <div class="col-xs-4"><input type="text" name="tname" placeholder="请输入枪械类型" class="form-control"></div>
    </div>
        <input type="submit" value="提交" class="btn btn-info">
</form>
<br>



<table align="center" class="table table-striped table-bordered table-condensed">
    <c:forEach items="${requestScope.types}" var="type">
        <tr>
            <td class="text-center">${type.tid}</td>
            <td>${type.tname}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>