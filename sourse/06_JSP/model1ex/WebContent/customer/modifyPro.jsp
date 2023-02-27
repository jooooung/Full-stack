<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
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
	 <% request.setCharacterEncoding("UTF-8"); %>
	 <jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	 <jsp:setProperty name="dto" property="*" />
	 <%
	 	String tempBirth = request.getParameter("tempBirth");
	 	if(!tempBirth.equals("")){
	 		dto.setCbirth(Date.valueOf(tempBirth));
	 	}
	 	CustomerDto customer = (CustomerDto)session.getAttribute("customer");	// 세션의 pw가 필요
	 	String sessionPw = null;
	 	if(customer!=null){
		 	sessionPw = customer.getCpw();	// session의 member의 pw (현pw)
	 	}
	 	String oldcpw = request.getParameter("oldcpw");
	 	if(sessionPw.equals(oldcpw)){
	 		// 현 비밀번호를 맞게 입력
	 		if(dto.getCpw()==null){
	 			// 비밀번호 유지하기
	 			dto.setCpw(oldcpw);
	 		}
	 		CustomerDao cDao = CustomerDao.getInstance();
	 		int result = cDao.updateCustomer(dto);
	 		if(result == CustomerDao.SUCCESS){
	 			// 정보 수정성공
	 			session.setAttribute(conPath + "/main/main.jsp", dto);	// 수정된 정보를 session 속성으로 수정
	 %>		
	 			<script>
	 				alert('정보수정 완료');
	 				location.href='<%=conPath%>/main/main.jsp';
	 			</script>
	 		}else{
	 			// 정보 수정실패
	 			<script>
					alert('회원정보 수정이 실패되었습니다');	 
					location.href='<%=conPath%>/customer/modifyForm.jsp';
				</script>
	 	<%}%>
	 <% }else{
	 		// 현 비밀번호를 틀린 경우 정보수정페이지로
	 %>
	 		<script>
	 			alert('비밀번호가 틀립니다');
	 			history.back();
	 		</script>
	<%}%>
</body>
</html>