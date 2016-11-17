<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Oushaoin's JSP Test</title>
<meta charset="UTF-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" text="text/css" href="res/css/common.css">
<link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
<script src="res/js/jquery-2.1.4.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
<style type="text/css">
	
.container{
	font-size:20px;;	
}
</style>
</head>

<body>
<div class="header text-center"><h1>JSP 编程测试</h1></div>
	<div class="container">
	<ol>
		<li><a href="Sushu.jsp">素数输出测试</a></li>
		<li><a href="Login.jsp">登录注册测试</a></li>
		<li><a href="Counter.jsp">网站计数器测试</a></li>
		<li><a href="Cart.jsp">购物车测试</a></li>
	</ol>
	</div>
</body>
</html>
