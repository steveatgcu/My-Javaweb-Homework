<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="me.shaobin.bean.Cricle" %>
<%
	double r = 0;
	boolean isPost = false;
	Cricle cricle = null;
	if(request.getParameter("r")!=null){
		try{
		 r = Double.valueOf(request.getParameter("r"));
		 isPost = true;
		 }catch(Exception e){
		 	isPost = false;
		 }
		 cricle = new Cricle(r);
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>圆形面积计算测试-Cricle</title>
  <meta charset="UTF-8">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/res/css/common.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/res/js/jquery-2.1.4.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
  <style type="text/css">
  .container {
  	font-size: 20px;;
  }
  .r{
  	width:20%;
  	margin-left:auto;
  	margin-right:auto;s
  	margin-top:30px;
  }
  button{
  	margin-top:20px;
  }
  input{
  	margin-top:20px;
  }
  </style>
</head>
<body>

<div class="header text-center"><h1>圆形计算测试</h1></div>
	<div class="container">
		<form method="post"  >
			<h3 class="text-center">请输入圆形半径</h3>
			<div class="r">
				<%if(isPost){ %>
				<input type="text" name="r" placeholder="请输入圆形的半径" class="form-control" value="<%=r%>">
				<%}else{ %>
				<input type="text" name="r" placeholder="请输入圆形的半径" class="form-control">
				<%} %>
				<button type="submit" class="btn btn-info btn-block form-control">提交</button>
			</div>
		</form>
		<%if(isPost){ %>
		<h3 class="text-center">面积</h3>
		<h4 class="text-center"><%=cricle.getS() %></h4>
		<%} %>
		
		<p  class="text-center"><a href="${pageContext.request.contextPath}">返回主页</a></p>
	</div>
</body>
</html>
