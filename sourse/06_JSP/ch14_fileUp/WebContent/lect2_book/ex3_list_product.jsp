<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.*"%>
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
			  BookDao bDao = BookDao.getInstance();
				ArrayList<BookDto> books = bDao.listBook();
				for(int i=0 ; i<books.size() ; i++){
					int bprice = books.get(i).getBprice();
					int bdiscount = books.get(i).getBdiscount();
					int discountPrice = bprice * (100 - bdiscount) / 100;
					if(i != 0 && i % 3 == 0) out.println("</tr><tr>");
			%>
				<td>
					<a href="detail.jsp?bid=<%=books.get(i).getBid()%>">
						<img alt="표지" src="<%=conPath%>/bookFile/<%=books.get(i).getBimage1()%>"><br>
						<%=books.get(i).getBid() %>. <%=books.get(i).getBtitle() %><br>
					</a>	
					<del><%=bprice %></del>
					<b><%=discountPrice %>원</b>(<%=bdiscount %>%할인)
				</td>
			<%}%>
		</tr>	
	</table>	
		<a href="ex1_list_board.jsp">책 리스트(게시판 스타일)</a><br>
		<a href="ex2_list.jsp">책 1page리스트(게시판 스타일)</a><br>
		<a href="ex3_list_product.jsp">책 전체리스트(product list 스타일)</a><br>
		<a href="ex4_list.jsp">책 1page리스트(product list 스타일)</a><br>
		<button onclick="location.href='<%=conPath%>/lect2_book/bookRegisterForm.html'">책 등록</button> 
</body>
</html>