<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="me.shaobin.bean.*" %>
<%@ page import="me.shaobin.entity.*" %>
<%
if(request.getDispatcherType()!=DispatcherType.FORWARD){
	response.sendRedirect("main");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Lite CRM 客户管理系统</title>
<meta charset="UTF-8">
<link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/res/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}}res/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
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
			<h3 class="text-center">Client Relationship Manager System</3>
			<h4>客户信息</h4>
			<h5>Client Informations</h5>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>姓名 Name</th>
						<th>生日 Birthday</th>
						<th>电话 Phone</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.page.data}"  var="detail">
						<tr>
							<td>${detail.name }</td>
							<td>${detail.birthday }</td>
							<td>${detail.phone }</td>	
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav>
			<p class="text-left">
				  <ul class="pager">
				  <c:if test="${requestScope.page.hasPrev}">
    				<li><a href="${pageContext.request.contextPath}/Customer/main?page=${requestScope.page.prevPage}">上一页</a></li>
    			  </c:if>
    			  <c:if test="${requestScope.page.hasNext}">
    				<li><a href="${pageContext.request.contextPath}/Customer/main?page=${requestScope.page.nextPage}">下一页</a></li>
  				  </c:if>
  				</ul>
			</nav>
			</p>
			<!--  p class="text-right">
				<a class="btn btn-warning" href="${pageContext.request.contextPath}">返回测试首页</a></p>-->
		</div>
	</div>
	</div>
</body>
</html>
