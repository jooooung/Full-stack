<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	String msg = "";
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id != null && id.equals("aaa")){
		// 유효한 아이디
		if(pw!=null && pw.equals("111")){
			// 로그인 처리
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
			/* Member member = new Member(id, pw, "홍길동");
			session.setAttribute("member", member); */
			response.sendRedirect("main.jsp");
		}else{
			// pw가 틀린경우
			msg = URLEncoder.encode("비밀번호를 확인하세요", "utf-8");
			response.sendRedirect("login.jsp?msg="+msg);
		}
	}else{
		// 유효하지 않은 아이디
		msg = URLEncoder.encode("id를 확인하세요", "utf-8");   
		response.sendRedirect("login.jsp?msg="+msg);
	}
	%>
</body>
</html>