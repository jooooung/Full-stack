<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.lec.dto.BoardDto"%>
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
	<%
		// 임의로 데이터 채운 후 insert (for문 이용 70회)
		BoardDto dto = new BoardDto();
		BoardDao bDao = BoardDao.getInstance();
		for(int i=0 ; i<=70 ; i++){
			dto.setWriter("홍길동"+i);
			dto.setSubject("제목"+i);
			dto.setContent("본문"+i);
			if(i%5 != 0){
				dto.setEmail("홍"+i+"@lec.com");
			}else{
				dto.setEmail(null);
			}
			dto.setPw("111");
			dto.setIp("192.0.0." + i);
			int result = bDao.insertBoard(dto);
			System.out.println(i+"번째 insert 성공");
		}
		response.sendRedirect("list.jsp");
	%>
</body>
</html>