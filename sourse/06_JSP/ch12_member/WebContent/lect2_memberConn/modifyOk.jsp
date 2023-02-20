<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDto"%>
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
	<%-- modify.jsp에서 전달받은 파라미터 : 
			id, pw(새비번), name, phone1, phone2, phone3, gender, email, address (MemberDaoConn)
			tempBirth, oldPw(현비번) (dto에 없는 파라미터변수)			
	 --%>
	 <% request.setCharacterEncoding("UTF-8"); %>
	 <jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	 <jsp:setProperty name="dto" property="*" />
	 <%
	 	String tempBirth = request.getParameter("tempBirth");
	 	if(!tempBirth.equals("")){
	 		dto.setBirth(Date.valueOf(tempBirth));
	 	}
	 	MemberDto member = (MemberDto)session.getAttribute("member");	// 세션의 pw가 필요
	 	String sessionPw = null;
	 	if(member!=null){
		 	sessionPw = member.getPw();	// session의 member의 pw (현pw)
	 	}
	 	String oldPw = request.getParameter("oldPw");
	 	if(sessionPw.equals(oldPw)){
	 		// 현 비밀번호를 맞게 입력
	 		if(dto.getPw()==null){
	 			// 비밀번호 유지하기
	 			dto.setPw(oldPw);
	 		}
	 		MemberDaoConn mDao = new MemberDaoConn();
	 		int result = mDao.modifyMember(dto);
	 		if(result == MemberDaoConn.SUCCESS){
	 			// 정보 수정성공
	 			session.setAttribute("member", dto);	// 수정된 정보를 session 속성으로 수정
	 %>		
	 			<script>
	 				alert('정보수정 완료');
	 				location.href='main.jsp';
	 			</script>
	 		}else{
	 			// 정보 수정실패
	 			<script>
					alert('회원정보 수정이 실패되었습니다');	 
					location.href='modify.jsp';
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