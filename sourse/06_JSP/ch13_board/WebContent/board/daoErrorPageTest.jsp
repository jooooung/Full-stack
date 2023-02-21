<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
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
	<a href='xx/jsp'>에러페이지 되는지</a>	
	<%
		BoardDao bDao = BoardDao.getInstance();
		out.println("<h2>1. 글개수 : " + bDao.getBoardTotalCnt() + "</h2>");		// 1번 테스트
		out.println("<h2>2. 글목록</h2>");
		ArrayList<BoardDto> dtos = bDao.listBoard();	// 2번 테스트
		for(BoardDto dto : dtos){
			out.println(dto + "<br>");
		}
		out.println("<h2>3. 원글쓰기</h2>");
		BoardDto dto = new BoardDto(0, "김계란", "헬스란", "운동", null,0,  "111", 0,		// 3번테스트
																0, 0, "192.0.0.1", null);
		int result = bDao.insertBoard(dto);
		out.println(result == BoardDao.SUCCESS ? "글쓰기 성공" : "글쓰기실패");
		out.println("<h2>4,5. 조회수 올리기, 글번호로 dto가져오기</h2>");
		bDao.readCountUp(3);	// 3번글 조회
		dto = bDao.getBoardOneLine(3);	// 3번글 상세보기
		out.println("수정전의 3번글 : " + dto);
		out.println("<h2>6. 글수정</h2>");
		dto = new BoardDto(3, "김계란", "수정함", "수정내용", "e@e.com", 0, "111",		// 6번테스트
				0, 0, 0, "192.0.0.1", null);
		result = bDao.updateBoard(dto);
		if(result == BoardDao.SUCCESS){
			dto = bDao.getBoardOneLine(3);
			out.println("수정후의 3번글 : " + dto);
		}else{
			out.println("수정실패");
		}
		out.println("<h2>7. 2번글 삭제</h2>");
		result = bDao.deleteBoard(2, "1");
		out.println(result == BoardDao.SUCCESS? "2번글 삭제 성공<br>" : "2번글 삭제 실패<br>");
		result = bDao.deleteBoard(2, "111");
		out.println(result == BoardDao.SUCCESS? "2번글 삭제 성공<br>" : "2번글 삭제 실패<br>");
	%>
</body>
</html>