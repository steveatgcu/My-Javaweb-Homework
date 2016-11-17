<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="me.shaobin.bean.*" %>
<%@ page import="me.shaobin.entity.*" %>
<%
if(request.getDispatcherType()!=DispatcherType.FORWARD){
	response.sendRedirect("student.do");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>学生管理系统 Powered By Oub Framework</title>
<meta charset="UTF-8">
<link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/res/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/res/js/jquery-2.1.4.min.js"></script>
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
			<h3 class="text-center">Student Manager System 0.0.1</h3>
			<h4>学生信息</h4>
			<h5>Student Informations</h5>
			<a href="add.do" style="float:right;margin-right:15px;" class="btn btn-default">添加学生</a>
			<a href="downloadXML.do" target="_blank" style="float:right;margin-right:15px;" class="btn btn-default">导出学生</a>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>专业</th>
						<th>年级</th>
						<th>班级</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.page.data}"  var="detail">
						<tr>
							<td>${detail.studentNumber }</td>
							<td>${detail.studentName }</td>
							<td>${detail.gender }</td>
							<td>${detail.major }</td>
							<td>${detail.grade }</td>
							<td>${detail.className }</td>
							<td>
								<a href="detail.do?studentNumber=${detail.studentNumber }" class="btn btn-info">查看/修改</a>
								<a href="removeStudent.do?studentNumber=${detail.studentNumber }" class="btn btn-danger">删除该学生</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav>
			<p class="text-left">
				  <ul class="pager">
				  <c:if test="${requestScope.page.hasPrev}">
    				<li><a href="${pageContext.request.contextPath}/student.do?page=${requestScope.page.prevPage}">上一页</a></li>
    			  </c:if>
    			  <c:if test="${requestScope.page.hasNext}">
    				<li><a href="${pageContext.request.contextPath}/student.do?page=${requestScope.page.nextPage}">下一页</a></li>
  				  </c:if>
  				</ul>
			</nav>
			</p>
		</div>
	</div>
	</div>
</body>
</html>
