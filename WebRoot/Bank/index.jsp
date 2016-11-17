<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="me.shaobin.bean.Deposit" %>
<%
	double capital = 0;
	double rate = 0;
	int year = 0;
	boolean isPost = false;
	Deposit deposit = null;
	DecimalFormat df = new DecimalFormat("######0.00");
	if(request.getParameter("year")!=null){
		try{
			capital = Double.valueOf(request.getParameter("capital"));
			year = Integer.valueOf(request.getParameter("year"));
			rate  = Double.valueOf(request.getParameter("rate"))/100;
		 	isPost = true;
		 }catch(Exception e){
		 	isPost = false;
		 }
		 deposit = new Deposit(year,capital,rate);
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>存款计算器-Bank calculator</title>
  <meta charset="UTF-8">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/res/css/common.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/res/js/jquery-2.1.4.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
  <style type="text/css">
  .container {
  	font-size: 16px;;
  }
  button{
  	margin-top:20px;
  }
  .form-horizontal{
  	width:50%;
  	margin:auto;
  }
  </style>
</head>
<body>

<div class="header text-center"><h1>存款计算器</h1></div>
	<div class="container">
		<form method="post" class="form-horizontal"  >
				  <div class="form-group">
    				<label for="year" class="col-sm-2 control-label">存款年限</label>
    				<div class="col-sm-10 input-group">
     					<input type="number" id="year" name="year" class="form-control" value="<%=year%>">
      					<span class="input-group-addon">年</span>
    				</div>
				  </div>
				  <div class="form-group">
 				   <label for="rate" class="col-sm-2 control-label">存款利率</label>
 				   <div class="col-sm-10 input-group">
					  <input type="text" id="rate" name="rate" class="form-control" value="<%=df.format(rate*100) %>">
 				     <span class="input-group-addon">%</span>
 				   </div>
 				 </div>
 				 <div class="form-group">
 				   <label for="capital" class="col-sm-2 control-label">初期存款</label>
  					  <div class="col-sm-10 input-group">
						  <input type="text" id="capital" name="capital" class="form-control" value="<%=df.format(capital)%>">
    					  <span class="input-group-addon">元</span>
    				  </div>
 				 </div>
 				 <div class="col-sm-4"></div>
				<button type="submit" class="btn btn-success col-sm-4">提交</button>
				<div class="col-sm-4"></div>
		</form>
		<div class="col-sm-12">
		<%if(isPost){ %>
		<h3 class="text-center">到期总额</h3>
		<h4 class="text-center"><%=df.format(deposit.getInterest()+capital)  %>元</h4>
		<%} %>
		<p  class="text-center"><a href="${pageContext.request.contextPath}">返回主页</a></p>
		</div>
	</div>
</body>
</html>
