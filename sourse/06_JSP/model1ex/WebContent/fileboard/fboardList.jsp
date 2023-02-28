<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath(); 
	CustomerDto customer = (CustomerDto) session.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/content.css" rel="stylesheet" type="text/css">
  <style>
  	#content_form{ padding-top: 30px;}
  </style>
</head>
<body>
  <jsp:include page="../main/header.jsp"/>
  <div id="content_form">
  	<table>
  		<tr>
				<td colspan="7">
		  		<%if(session.getAttribute("customer") != null){ %>
							<a href="<%=conPath%>/fileboard/fboardWriteForm.jsp?">글쓰기</a>
					<%}%>
				</td>
			</tr>
  		<tr>
  			<th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>IP</th><th>작성일</th><th>조회수</th>
  		</tr>
  		<%
	  		String pageNum = request.getParameter("pageNum");
	  		if(pageNum == null) pageNum = "1";
	  		int currentPage = Integer.parseInt(pageNum);
	  		final int PAGESIZE=10, BLOCKSIZE=10;
	  		int startRow = (currentPage-1) * PAGESIZE + 1;	
	  		int endRow   = startRow + PAGESIZE - 1;			
	  		CustomerDao cDao = CustomerDao.getInstance();
	  		ArrayList<CustomerDto> customers = cDao.listCustomer(startRow, endRow);
	  		FileboardDao fDao = FileboardDao.getInstance();
	  		ArrayList<FileboardDto> dtos = fDao.fileboardList(startRow, endRow);  		
	  		int totCnt = fDao.getFileboardCnt();	// db에 등록된 글 개수
	  		if(totCnt == 0){
	  			out.println("<tr><td colspan='7'>등록된 글이 없습니다</td></tr>");
	  		}else if(dtos.isEmpty()){
  				out.println("<tr><td colspan='7'>해당 페이지에 글이 없습니다</td></tr>");
  			}else{
  				for(FileboardDto dto : dtos){
  			%>
  					<tr>
  						<td><%=dto.getFnum() %>
  						<td><%=dto.getCname() %>
  						<td class="left">
  							<% if(dto.getFre_level()>0){%>
	 									<img src="<%=conPath%>/img/level.gif"  
	 											width="<%=dto.getFre_level()*20 %>" height="10">	<!-- 들여쓰기 -->			 									
  									<img src="<%=conPath%>/img/re.png" height="15">
  							<%}
  								if(dto.getFhit() > 10) {
  							%>
  								<img src="<%=conPath%>/img/hot.gif">
  							<%} %>
  							<a href="<%=conPath %>/fileboard/fboardContent.jsp?fnum=<%=dto.getFnum() %>&pageNum=<%=pageNum %>">
  								<%=dto.getFsubject() %>
  							</a>
  							<%if(dto.getFfilename() != null){ %>
  								<img src="<%=conPath%>/img/fileup.jpg" height="12">
  							<%} %>
  						</td>
  						<td><%=dto.getcemail()==null? "": dto.getcemail() %></td>
  						<td><%=dto.getFip() %></td>
  						<td><%=dto.getFrdate() %></td>
  						<td><%=dto.getFhit() %></td>
  			<%
  				}
  			}
  			%>
  	</table>
  	<div class="paging">
  		<%
  			int pageCnt = (int)Math.ceil((double)totCnt / PAGESIZE);	// 페이지 수
  			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
				int endPage = startPage + BLOCKSIZE - 1;			
  	  	if(endPage > pageCnt){
  	  		endPage = pageCnt;
  	  	}
  	  	if(startPage > BLOCKSIZE){
  	  %>	
  	  	[ <a href="<%=conPath%>/fileboard/fboardList.jsp?pageNum=<%=startPage-1%>">이전</a> ]	
  	  <%}
  	  	for(int i=startPage ; i<=endPage ; i++){
  	  		if(i == currentPage){
  	  			out.println("[<b>" + i + "</b>]");
  	  		}else{
  	  			out.println("[<a href='"+conPath + "/fileboard/fboardList.jsp?pageNum=" + i + "'>" + i + "</a>]");
  	  		}
  	  	}
  	  	if(endPage < pageCnt){
  	  	out.println("[<a href='"+conPath + "/fileboard/fboardList.jsp?pageNum=" + (endPage+1) + "'>다음</a>]");
  	  	}
  		%>
  	</div> 
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>