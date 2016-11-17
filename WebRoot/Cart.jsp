<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.net.URLEncoder" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Map<String,Integer> books = new HashMap<String,Integer>();
	books.put("Thinking in Java", 1001);
	books.put("ASP.NET 从小工到专家", 1002);
	books.put("大数据日知录", 1003);
	books.put("PHP 函数手册", 1004);
	books.put("Node.js 从入门到精通", 1005);
	books.put("数据库 从建表到跑路", 1006);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物车测试</title>
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
			<h1 class="text-center">购物车测试</h1>
			<h2>可购买列表</h2> 
			<table class="table">
			<% for(String book: books.keySet()){%>
				<tr><td><%= book%></td><td><a class="btn btn-success" href="CheckCart.jsp?book=<%=books.get(book) %>&action=buy">购买</a></td></tr>
			<%} %>
			</table>
			<p class="text-right">
				<a class="btn btn-info" href="CheckCart.jsp">查看购物车</a>
				<a class="btn btn-warning" href="index.jsp">返回首页</a></p>
		</div>
	</div>
	</div>
</body>
</html>