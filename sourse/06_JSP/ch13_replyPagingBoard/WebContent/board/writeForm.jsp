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
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
 	<%
 		String pageNum = request.getParameter("pageNum");
 		int num=0, ref=0, ref_step=0, ref_indent=0;
 		BoardDto dto = new BoardDto(); // 답변글 페이지면 dto에 원글 정보 저장
 		if(request.getParameter("num")!=null){
 			// 답변글 쓰는 경우 dto에 원글의 정보 저장
 			num = Integer.parseInt(request.getParameter("num"));
 			BoardDao bDao = BoardDao.getInstance();
 			dto = bDao.getBoardOneLine(num);	// 원글 정보
 			ref = dto.getRef();
 			ref_step = dto.getRef_step();
 			ref_indent = dto.getRef_indent();
 			System.out.println("writeForm(답글)에서 넘어온 원글의 ref : " + ref);
 			System.out.println("writeForm(답글)에서 넘어온 원글의 ref_step : " + ref_step);
 			System.out.println("writeForm(답글)에서 넘어온 원글의 ref_indent : " + ref_indent);
 			
 		}
 	%>
	<form action="writePro.jsp" method="post">
		<input type="hidden" name="pageNum"	value="<%=pageNum%>">
		<input type="hidden" name="num"	value="<%=num%>">
		<input type="hidden" name="ref"	value="<%=ref%>">
		<input type="hidden" name="ref_step"	value="<%=ref_step%>">
		<input type="hidden" name="ref_indent"	value="<%=ref_indent%>">
		<table>
			<caption><%=num==0? "" : num+"번 글 답변" %>게시판</caption>
			<tr>
				<th>작성자</th>
				<td>	
					<input type="text" name="writer" required="required" autofocus="autofocus">
				</td>			
			</tr>
			<tr>
				<th>글제목</th>
				<td>
					<input type="text" name="subject" required="required" 
						value="<%
							if(dto.getSubject()!=null){
								out.print(dto.getSubject() + " - 답글");
							}
					%>">
				</td>			
			</tr>
			<tr>
				<th>본문</th>
				<td>
					<textarea rows="5" name="content" required="required"></textarea>
				</td>			
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="email" name="eamil">
				</td>			
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pw" required="required">
				</td>			
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="<%=num==0? "글쓰기" : "답글쓰기"%>" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn"
									onclick="location.href='<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>'">
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>