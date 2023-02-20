<%@page import="com.lec.member.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>		<%-- post 한글로 바꾸기 --%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>		<%-- bean 사용, scope는 현재 페이지로 설정 --%>
	<jsp:setProperty property="*" name="dto"/>		<%-- 데이터 값 설정 --%>
	<%
		String tempBirth = request.getParameter("tempBirth");	// ""이거나 "2000-02-02"
		if(!tempBirth.equals("")){
			dto.setBirth(Date.valueOf(tempBirth));
			// dto의 birth가 Timestamp형이면 : dto.setBirth(Timestamp.valueOf(tempBirth + "00:00:00"));
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmId(dto.getId());	// ID 중복체크
		if(result == MemberDao.MEMBER_NONEXISTENT){
			// 사용가능한 ID => 회원가입 진행
			result = mDao.joinMember(dto);	// 회원가입
			if(result == MemberDao.SUCCESS){
				// 회원가입 성공
				session.setAttribute("id", dto.getId());
	%>
				<script>
					alert('회원가입 감사합니다');
					location.href='login.jsp';
				</script>
	<%		}else{
				// 회원가입 실패
	%>
			<script>
				alert('회원가입 실패. id가 너무 깁니다')
				history.back();		// 이전 데이터 남아있음
				// location.href='koin.jsp';	// 새 페이지
			</script>
	<%	}
		}else{
			// 중복된 ID => 회원가입 불가
	%>	
		<script>
			alert('중복된 ID입니다. 다른 아이디를 사용하세요');
			history.back();
		</script>				
	<% }%>	
</body>
</html>