<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String agree = request.getParameter("agree");
		if("yes".equals(agree)){
			// 약관에 동의한 경우 : 세션 속성값(id,pw,name) 받아 DB(지금은 파일)저장, 세션 제거(pw, name) -> 다음페이지로 이동
			// 세션 속성값 받기
			String id = (String)session.getAttribute("id");	
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			// 파일에 저장(/ch08_session/WebContent/WEB-INF/id.txt)
			String filePath = "C:/JK/sourse/06_JSP/ch08_session/WebContent/WEB-INF/"+id+".txt";
			PrintWriter writer = new PrintWriter(filePath);
			writer.write("오늘은 DB 대신 파일 출력");
			writer.println("아이디 : " + id);
			writer.println("비밀번호 : " + pw);
			writer.println("이름 : " + name);
			writer.close();
			// pw, name 세션 제거
			session.removeAttribute("pw");
			session.removeAttribute("name");
			response.sendRedirect("result.jsp?msg=success");
		}else{
			// 약관 거부한 경우 : 모든 세션 속성 제거 -> 다음 페이지로
			session.invalidate();		// 모든 세션 속성 제거
			response.sendRedirect("result.jsp?msg=fail");	// 다음 페이지로 fail 메세지 보내기
		}
	%>	
</body>
</html>