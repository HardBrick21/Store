<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-添加</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
</head>
<body>


<form action="${pageContext.request.contextPath}/book/addBook" method="post"  enctype="multipart/form-data"  class="form-horizontal">
    <h1 class="lead text-center">添加枪械</h1>
    <div class="form-group">
        <label class="col-sm-2 control-label">名称：</label>
        <div class="col-xs-4"><input type="text" name="bname" placeholder="请输入名称" class="form-control"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">生产商：</label>
        <div class="col-xs-4"><input type="text" name="press" placeholder="请输生产商" class="form-control"></div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">类型：</label>
        <div class="col-xs-4"><select name="tid" class="form-control">
			<c:forEach items="${types}" var="type"> 
            <option value="${type.tid}">${type.tname }</option>  
            </c:forEach>
        </select></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">价格：</label>
        <div class="col-xs-4"><input type="text" name="price" placeholder="请输入价格" class="form-control" ></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">库存：</label>
        <div class="col-xs-4"><input type="text" name="count" placeholder="请输入入库数" class="form-control" ></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">图片：</label>
        <div class="col-xs-4"><input type="file" name="picfile" class="form-control"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">简介：</label>
        <div class="col-xs-4"><textarea rows="" cols="" name="description" class="form-control" rows="5"></textarea>
        </div>
    </div>
    <div class="form-group">
        <div class="col-xs-10">
            <label class="col-sm-3 control-label"></label>
            <input type="submit" value="提交" class="btn btn-info"></div>
    </div>

</form>
</body>
</html>