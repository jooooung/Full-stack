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
	<table>
		<caption>게시판</caption>
		<tr>
			<td><a href="<%=conPath%>/board/writeForm.jsp">글쓰기</a></td>
		</tr>
	</table>	
	<table>
		<tr>
			<th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th>
		</tr>
		<%
			BoardDao bDao = BoardDao.getInstance();
			int totalCnt = bDao.getBoardTotalCnt();
			if(totalCnt == 0){
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");
			}else{
				ArrayList<BoardDto> dtos = bDao.listBoard();	// 전체글 가져오기
				for(BoardDto dto : dtos){
					// 글번호
					out.println("<tr><td>" + dto.getNum() + "</td>");
					// 작성자
					out.println("<td>" + dto.getWriter() + "</td>");
					// 글제목(조회수 10 이상이면 hot 이미지와 같이 제목 출력, 제목 클릭 시 상세내용 페이지로)
					out.println("<td class='left'>");
					if(dto.getReadcount() > 10){
						out.println("<img src='" + conPath + "/img/hot.gif'>");
					}
					out.println("<a href='" + conPath + "/board/content.jsp'>" + dto.getContent() + "</a>");
					out.println("</td>");
					// 메일
					String email = dto.getEmail();
					out.println("<td>" + (email==null? "" : email) + "</td>");
					// 조회수
					out.println("<td>" + dto.getReadcount() + "</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>