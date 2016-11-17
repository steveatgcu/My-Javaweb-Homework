<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>素数输出测试</title>
    <meta charset="UTF-8">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath }es/css/common.css">
	<link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
	<script src="res/js/jquery-2.1.4.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
    <div class="container">
  <h1>1-1000所有的素数:</h1> 
       <h4 style="float:right; display:inline;"><a href="index.jsp" >返回主页</a></h4>
	<table class="table"><tr>
    <%
    	int count = 0;
    	for(int i=2;i<1000;i++){
    		boolean isPer = true;
    		for(int j=2;j<i;j++){
    			if(i%j==0){
    				isPer = false;
    				break;
    			}
    		}
    		if(isPer){
    		   	count ++;
    			out.println("<td>"+i+"</td>");
    			if(count>0&&count%10 ==0){
    				out.print("</tr><tr>");
    			}
    		}
    	}
    
     %>
     </table>

     </div>
  </body>
</html>
