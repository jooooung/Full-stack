<%@page import="com.lec.dao.BoardDao"%>
<%@page import="java.sql.Timestamp"%>
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
	<% request.setCharacterEncoding("UTF-8"); %>	
	<!-- bean 객체 사용시에는 dto에매개변수 없는 생성자가 있어야한다 -->
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto" scope="page"/>  
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr());	// 클라이언트가 요청한 컴퓨터 ip
		// dto.setRdate(new Timestamp(System.currentTimeMillis()));	  
		// 테이블에서 default sysdate가 지정 안되있다면 현재 시간 가져오기	
		BoardDao bDao = BoardDao.getInstance();	
		int result = bDao.insertBoard(dto);	// 저장
		if(result == BoardDao.SUCCESS){	// 글쓰기 성공 시 리스트 페이지로 이동
	%>
			<script>
				alert('글쓰기 완료');
				location.href='<%=conPath%>/board/list.jsp';
			</script>
	<%}else{%>
			<script>
				alert('글쓰기 실패');
				history.go(-1);
			</script>
	<%}%>
</body>
</html>