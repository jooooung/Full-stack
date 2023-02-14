<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String hiddenParam = request.getParameter("hiddenParam");
	String name  = request.getParameter("name");
	String id 	 = request.getParameter("id");
	String pw 	 = request.getParameter("pw");
	String birth = request.getParameter("birth");
	/* Date birth = Date.valueOf(request.getParameter("birth"));
	Timestamp birthTimestamp = Timestamp.valueOf(request.getParameter("birth")+" 00:00:00"); */
	/* 생년월일 입력 안 할시 오류 잡기 */
	Timestamp birthTimestamp = null;
	if(birth!=null && !birth.equals("")){
		birthTimestamp = Timestamp.valueOf(birth + " 00:00:00");
	}
	String[] hobby = request.getParameterValues("hobby");
	String gender  = request.getParameter("gender");
	String email	 = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");
	// 받은 파라미터 값을 Member DB에 저장
	session.setAttribute("id", id);
%>
<jsp:include page="../member/header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">회원가입정보</div>
			<h2>hiddenParam: <%=hiddenParam %></h2>
			<h2>name : <%=name %></h2>
			<h3>id : <%=id %></h3>
			<h3>pw : <%=pw.replaceAll("[a-zA-Z0-9~`!@#$%^&*()\\-_+=|\\{}\\[\\]:;\"'?/<>,\\.]", "*") %></h3>
			<h3>birth : <%=birthTimestamp %></h3>
			<h3>hobby : <% 
				if(hobby!=null) {
					for(int i=0 ; i<hobby.length ; i++)
						if(i==hobby.length-1)
							out.print(hobby[i]);
						else
							out.print(hobby[i]+", ");
				}else {
					out.print("없음");
				}
		%></h3>
		<h3>gender : <%=gender %></h3>
		<h3>email : <%=email %></h3>
		<h3>mailSend : <%
				if(mailSend!=null){
					out.print(Arrays.toString(mailSend));
				}else{
					out.print("모두 수신 거부");
				}
	%></h3>
	</div>
		<jsp:include page="../member/footer.jsp"/>
</body>
</html>