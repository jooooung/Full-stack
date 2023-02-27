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
</head>
<body>
  <jsp:include page="../main/header.jsp"/>
  <div id="content_form">
  	<%
  		// main.jsp 또는 main.jsp?pageNum=1
  		String pageNum = request.getParameter("pageNum");
  		if(pageNum == null) pageNum = "1";
  		int currentPage = Integer.parseInt(pageNum);
  		final int PAGESIZE=5, BLOCKSIZE=2;
  		int startRow = (currentPage-1) * PAGESIZE + 1;	// 페이지의 시작 글  
  		int endRow   = startRow + PAGESIZE - 1;					// 페이지의 마지막 글
  		CustomerDao cDao = CustomerDao.getInstance();
  		ArrayList<CustomerDto> customers = cDao.listCustomer(startRow, endRow);
  		FileboardDao fDao = FileboardDao.getInstance();
  		ArrayList<FileboardDto> fileboards = fDao.fileboardList(startRow, endRow);
  	%>
  	<table>
  		<tr>
				<td colspan="7">
		  		<%if(customer != null){ %>
							<a href="<%=conPath%>/fileboard/fboardWriteForm.jsp?pageNum=<%=pageNum%>">글쓰기</a>
					<%}%>
				</td>
			</tr>
  		<tr>
  			<th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>IP</th><th>작성일</th><th>조회수</th>
  		</tr>
  		<%if(fileboards.size()==0){
  				out.println("<tr><td colspan='7'>등록된 도서가 없습니다</td></tr>");
  			}else{
  				for(int i=0 ; i<fileboards.size() ; i++){
  					String cemail = customers.get(i).getCemail();
  					String caddress = customers.get(i).getCaddress();
  					String cip = request.getRemoteAddr();
  					out.println("<tr>");
  					out.println("<td>" + fileboards.get(i).getFnum() + "</td>");
  					out.println("<td>" + customers.get(i).getCname() + "</td>");
  					out.println("<td>" + fileboards.get(i).getFcontent() + "</td>");
  					out.println("<td>" + (cemail==null? "" : cemail) + "</td>");
  					out.println("<td>" + cip + "</td>");
  					out.println("<td>" + fileboards.get(i).getFrdate() + "</td>");
  					out.println("<td>" + fileboards.get(i).getFhit()+ "</td>");
  					out.println("</tr>");
  				}
  			}
  		%>
  	</table>
  	<div class="paging">
  		<%
  			int totCnt = fDao.getFileboardCnt();
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
  	  			out.println("[" + i + "]");
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