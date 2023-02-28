<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/content.css" rel="stylesheet" type="text/css">
	<style>
  	#content_form{ padding-top: 80px;}
  	#content_form th{ width: 150px;}
 	</style>
</head>
<body>
	<!-- 글상세보기 -->
	<!-- 버튼 : 비로그인 시 목록, 삭제  / 로그인 시 목록 수정(내가 쓴 글만) 답변 삭제-->
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
			String pageNum = request.getParameter("pageNum");
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			FileboardDao fDao = FileboardDao.getInstance();
			fDao.hitUp(fnum);
			FileboardDto fDto = fDao.getBoardOneLine(fnum);
			if (fDto == null) {
				response.sendRedirect(conPath + "/fileboard/fboardList.jsp");
			} else {
		%>
			<table>
				<caption>글 상세보기</caption>
				<tr>
					<th>글번호</th>
					<td><%=fDto.getFnum()%></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=fDto.getFsubject()%></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<%=fDto.getCname() %>
						<%if(fDto.getcemail() == null){%>
							(<a href="mailto:<%=fDto.getcemail() %>">
								<%=fDto.getcemail() %>
							</a>)
						<%}else{ %>
							()
						<%}%>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<%if(fDto.getFfilename()==null){ %>
								없음
						<%}else{ %>
								<a href="<%=conPath%>/fileboardUpload/<%=fDto.getFfilename()%>">
									<%=fDto.getFfilename() %>
								</a>
						<%}%>
					</td>
				</tr>
				<tr>
					<th>본문</th>
					<td>
						<pre><%=fDto.getFcontent()==null? "" : fDto.getFcontent() %></pre>
					</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><%=fDto.getFrdate()%></td>
				<tr>
					<th>조회수</th>
					<td><%=fDto.getFhit()%></td>
				</tr>
				</tr>
				<tr>
					<th>IP</th>
					<td><%=fDto.getFip()%></td>
				</tr>
				<tr>
					<td colspan="2">
					<%
						String cid = null;
						CustomerDto customer = (CustomerDto) session.getAttribute("customer");
						if(customer != null){
							cid = customer.getCid();	// 로그인 한 id
						}
						if(fDto.getCid().equals(cid)){	// 글 쓴 id와 로그인 id가 같을 시 수정 가능 %>
							<button onclick="location='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
								수정
							</button>
					<%} %>
					<%if(customer != null){ %>
						<button onclick="location='fboardWriteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
							답변
						</button>
					<%} %>
						<button onclick="location='fboardDeleteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
							삭제
						</button>
						<button onclick="location='fboardList.jsp?pageNum=<%=pageNum%>'">
							목록
						</button>
					</td>
				</tr>
			</table>
		<%} %>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>