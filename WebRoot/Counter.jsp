<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	long count;
	if(application.getAttribute("page_count")!=null){
		count = (Long)application.getAttribute("page_count");
		application.setAttribute("page_count", count+1);
	}else{
		count = 1 ;
		application.setAttribute("page_count", count);
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>计数器测试</title>
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
}
</style>
</head>

<body>
	<div class="container">
	<div class="container">
		<div class="message">
			<h1 class="text-center">您好，您是第<%= count+1 %>位访问者 O.o</h1>
			<h2 class="text-center"><a href="index.jsp">返回测试主页</a></h2>
		</div>
	</div>
	</div>
</body>
</html>