<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<style>
		#wrap{
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
	<script>
		function position(n){
			location.href="examPro.jsp?su=" + n;
		}
	</script>
</head>
<body>
	<div id="wrap">
		<p>동전이 있는 곳을 맞춰봐</p>
		<hr>
		<button onclick="position(1)">1번</button>
		<button onclick="position(2)">2번</button>
		<button onclick="position(3)">3번</button>
		<br>
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.print(msg);
			}
		%>
	</div>
</body>
</html>