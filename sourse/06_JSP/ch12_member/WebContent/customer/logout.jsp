<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap{
			height: 600px;
			line-height: 600px;
			font-size: 20px;
			text-align: center;
			width: 600px;
			margin: 0 auto;
			color: #D4A190;
		}
	</style>
	<script>
		function next(){
			location = "main.jsp";
		}
	</script>
</head>
<body onload = "setTimeout('next()', 3000)">
	<%
		session.invalidate();
	%>
	<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		로그아웃되었습니다. 3초 후 페이지 이동이 있겠습니다
	</div>		
	<jsp:include page="footer.jsp"/>
</body>
</html>