<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/login.css" rel="stylesheet" type="text/css">
	<script>
		function next(){
			location.href="../index.jsp"
		}
	</script>
</head>
<body onload="setTimeout('next()', 3000)">
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw  = request.getParameter("pw");
		if(id==null || !id.equals("aaa") || pw==null || !pw.equals("111")){
			response.sendRedirect("login.jsp?msg=xx");	// id, pw가 안 맞을시 메세지 전송
		}
	%>
	<jsp:include page="../member/header.jsp"/>
	<br><br><br><br><br><br>
	<div id="loginForm_wrap">
		<div id="login_title">로그인 결과</div>
		<div id="login_join">로그인 성공</div>
		<p>3초후 메인 페이지로 이동</p>
	</div>
	<br><br><br><br><br><br>
	<jsp:include page="footer.jsp"/>
</body>
</html>