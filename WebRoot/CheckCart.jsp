<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.net.URLDecoder" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Map<String,String> books = new HashMap<String,String>();
	Map<String,Integer> count = (Map<String,Integer>)request.getSession().getAttribute("book");
		
	String bookId = request.getParameter("book");
	String action = request.getParameter("action");
	
	books.put("1001","Thinking in Java");
	books.put("1002","ASP.NET 从小工到专家");
	books.put("1003","大数据日知录");
	books.put("1004","PHP 函数手册");
	books.put("1005","Node.js 从入门到精通");
	books.put("1006","数据库 从建表到跑路");
	
	if(count==null){
		count = new HashMap<String,Integer>();
	}
	
	if(action!=null && action.equals("buy")){
			String bookName = books.get(bookId);
			if(count.containsKey(bookName)){
				count.put(bookName, count.get(bookName)+1);
			}else{
				count.put(bookName, 1);
			}
			request.getSession().setAttribute("book", count);
	}else if(action!=null && action.equals("delete")){
			String bookName = books.get(bookId);
			if(count.containsKey(bookName) && count.get(bookName)>1){
				count.put(bookName, count.get(bookName)-1);
			}else{
				count.remove(bookName);
			}
			request.getSession().setAttribute("book", count);
	}else if(action!=null && action.equals("deleteAll")){
			String bookName = books.get(bookId);
			if(count.containsKey(bookName)){
				count.remove(bookName);
			}
			request.getSession().setAttribute("book", count);
	}else if(action!=null && action.equals("clear")){
			count.clear();
			request.getSession().setAttribute("book", count);
	}

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
			<h2>已购买列表</h2>
			<table class="table">
			<thead>
				<tr><td>书籍</td><td>数目</td><td>操作</td></tr>
			</thead>
			
			<% for(String bookIdTemp: books.keySet()){
				if(count.containsKey(books.get(bookIdTemp))){
			%>
				<tr>
					<td><%= books.get(bookIdTemp)%></td>
					<td><%=count.get(books.get(bookIdTemp)) %>本</td>
					<td>
						<a class="btn btn-info"  href="CheckCart.jsp?book=<%=bookIdTemp %>&action=delete">删除</a>
						<a class="btn btn-danger" href="CheckCart.jsp?book=<%=bookIdTemp %>&action=deleteAll">全部删除</a>
					</td>
				</tr>
			<%
					}
				} %>
			</table>			
			<a class="btn btn-primary" style="float:right;"  href="Cart.jsp">继续购物</a>
			<a class="btn btn-warning" style="float:right; margin-right:10px;"" href="CheckCart.jsp?action=clear">清空购物车</a>
		</div>
	</div>
	</div>
</body>
</html>