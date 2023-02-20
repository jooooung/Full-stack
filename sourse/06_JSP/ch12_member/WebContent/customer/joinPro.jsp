<%@page import="com.lec.customer.CustomerDao"%>
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
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="dto" class = "com.lec.customer.CustomerDto" scope="page"/>
<jsp:setProperty property="*" name="dto"/>
<%
	String tempBirth = request.getParameter("tempBirth");	
	if(!tempBirth.equals("")){
		dto.setCbirth(Date.valueOf(tempBirth));
	}
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.confirmID(dto.getCid());
	if(result == CustomerDao.CUSTOMER_NONEXISTENT){// 사용 가능 아이디
		result = cDao.joinCustomer(dto);
		if(result == CustomerDao.SUCCESS){	// 회원가입 성공
			session.setAttribute("cid", dto.getCid());	// 아이디 세션 
%>
			<script>
				alert('회원가입 감사합니다. 로그인 이후에 서비스를 이용하세요');
				location.href='login.jsp';
			</script>
<%		}else{ %>
		<script>
			alert('회원가입 실패되었습니다. 너무 긴 데이터는 가입 불가입니다. 다시 가입해주세요');
			history.back();		
		</script>
<%	}
	}else{ %>	
	<script>
		alert('이미 사용중인 ID입니다');
		history.back();
	</script>				
<% } %>
</body>
</html>