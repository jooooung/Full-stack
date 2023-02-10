<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex5.css" rel="stylesheet">
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id==null || !id.equals("aaa") || pw==null || !pw.equals("1111")){
			String msg = "아이디와 비밀번호를 확인하세요";
			msg = URLEncoder.encode(msg, "utf-8");	// 한글 encode 하기
 			response.sendRedirect("ex5_loginFrm.jsp?msg="+msg);
		}
	%>	
	<h2>
		아이디는 <%=id %> 이고 <br> 비밀번호는  <%=pw %> 입니다<br><br>반갑습니다
	</h2>
</body>
</html>