<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
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
		<caption>책 목록</caption>
		<tr>
		  <%
		  	String pageNum = request.getParameter("pageNum");
		  	if(pageNum == null){
		  		pageNum = "1";
		  	}
		  	int currentPage = Integer.parseInt(pageNum);
		  	final int PAGESIZE=3, BLOCKSIZE=2;
		  	int startRow = (currentPage - 1) * PAGESIZE + 1;
		  	int endRow = startRow + PAGESIZE - 1;
		  	BookDao dao = BookDao.getInstance();
		  	ArrayList<BookDto> books = dao.listBook(startRow, endRow);
		  	for(int i=0 ; i<books.size() ; i++){
		  		int bprice = books.get(i).getBprice();
					int bdiscount = books.get(i).getBdiscount();
					int discountPrice = bprice * (100 - bdiscount) / 100;
					if(i != 0 && i % 3 == 0) out.println("</tr><tr>");
			%>	
			<td>
					<a href="detail.jsp?bid=<%=books.get(i).getBid()%>&pageNum=<%=pageNum%>">
						<img alt="표지" src="<%=conPath%>/bookFile/<%=books.get(i).getBimage1()%>"><br>
						<%=books.get(i).getBid() %>. <%=books.get(i).getBtitle() %><br>
					</a>	
					<del><%=bprice %></del>
					<b><%=discountPrice %>원</b>(<%=bdiscount %>%할인)
				</td>
			<%}%>
		</tr>
	</table>
		<a href="ex2_list.jsp">책 1page리스트(게시판 스타일)</a><br>
		<a href="ex4_list.jsp">책 1page리스트(product list 스타일)</a><br>
		<button onclick="location.href='bookRegisterForm.html'">책 등록</button> 
	<div class="paging">
		<%
			int bookTotalCnt = dao.getBookTotalCnt();
			int pageCnt = (int)Math.ceil((double)bookTotalCnt / PAGESIZE);
			int startPage = ((currentPage - 1)/BLOCKSIZE) * BLOCKSIZE + 1;
		  int endPage = startPage + BLOCKSIZE - 1;
		  if(endPage > pageCnt){
			  endPage = pageCnt;
		  }
		  if(startPage > BLOCKSIZE){
		%>
				<a href='ex4_list.jsp?pageNum=<%=startPage-1 %>'>[이전]</a>	  
		  <%}
		  	for(int i=startPage ; i<=endPage ; i++){
		  		if(i == currentPage){
		  			out.println("<b>" + i + "</b>");
		  		}else{
		  			out.println("<a href='ex4_list.jsp?pageNum=" + i + "'>" + i + "</a>");
		  		}
		  	}
		  if(endPage < pageCnt){
		%>	
			<a href='ex4_list.jsp?pageNum=<%=endPage+1 %>'>[다음]</a>  
		 <%}%>
	</div>
</body>
</html>