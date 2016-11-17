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

<title>登录测试</title>
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
		<h1>登录测试</h1>
		<h5><a href="index.jsp">测试主页</a></h5>	
	</div>
		
	</div>
	<div class="col-md-6">
		<form class="form-horizontal" role="form" action="LoginComfirm.jsp"  method="post">
			<div class="form-group">
				<label  class="col-sm-2 control-label">账户</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="username"
						placeholder="请输入账户">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password"
						placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default btn-block">登录</button>
				</div>
			</div>
		</form>
		</div>
	</div>
</body>
</html>
