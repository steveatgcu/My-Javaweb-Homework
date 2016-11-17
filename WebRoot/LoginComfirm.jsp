<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
}
</style>
</head>

<body>
	<div class="container">
	<div class="container">
		<div class="message">
		<%
			String username = request.getParameter("username");
			String password = request.getParameter("password");
		 %>
		 <% if((username!=null && username.equals("Admin"))&&(password!=null && password.equals("123456"))){ %>
			<h1 class="text-center">您好<%=username  %>，登陆成功</h1>
			<h2 class="text-center"><a href="index.jsp">返回测试主页</a></h2>
		<%  }else{ %>
			<h1 class="text-center">账户密码错误，请重试</h1>
			<h2 class="text-center"><a href="Login.jsp">返回登陆页面</a></h2>
		<%  } %>
		</div>
	</div>
	</div>
</body>
</html>
