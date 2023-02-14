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
			font-size: 32px;
			text-align: center;
			width: 600px;
			margin: 0 auto;
			color: #D4A190;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<jsp:include page="../member/header.jsp"/>
	<div id="mainForm_wrap">
		main 화면
	</div>		
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>