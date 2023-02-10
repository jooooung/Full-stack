<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body{
			width: 500px;
			margin: 0 auto;
			text-align: center;
		}
		button{
			text-align: center;
			margin-left: 50px;
			padding: 30px 30px;
			background-color: lightblue;
		}
		.msg{
			color: red;
			text-align: center;
		}
	</style>
</head>
<body>
	<p>동전이 있는 곳을 맞춰봐</p>
	<hr>
	<form action="examPro.jsp">
		<button name="su" value="1">1번</button>
		<button name="su" value="2">2번</button>
		<button name="su" value="3">3번</button>
	</form>
	<div class="msg">
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.print(msg);
				}
		%>
</body>
</html>