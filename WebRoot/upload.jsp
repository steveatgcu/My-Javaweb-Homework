<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>文件上传测试</title>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" text="text/css" href="res/css/common.css">
<link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
<script src="res/js/jquery-2.1.4.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
<style>
body{
	background:#fefefe;
}
.container{
	height : 100%;
	padding-top:180px;
}
</style>
</head>

<body>
	<div class="container">
	<div class="col-md-6">
	<div class="text-center">
		<h1>文件上传测试</h1>
		<h5><a href="${path}">测试主页</a></h5>	
	</div>
		
	</div>
	<div class="col-md-6">
		<form class="form-horizontal" role="form" action="upload.action"  method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label  class="col-sm-12 control-label" style="color:red">${requestScope.status }</label>
			</div>
			<div class="form-group">
				<label  class="col-sm-3 control-label">请选择文件</label>
				<div class="col-sm-9">
					<input type="file" class="form-control" name="myfile"
						placeholder="请选择文件">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<button type="submit" class="btn btn-primary btn-block">上传 Upload</button>
				</div>
			</div>
		</form>
		</div>
	</div>
</body>
</html>
