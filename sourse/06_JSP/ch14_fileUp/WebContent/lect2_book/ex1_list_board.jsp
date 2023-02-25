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
	<%
		BookDao dao = BookDao.getInstance();
		ArrayList<BookDto> books = dao.listBook();
	%>
	<table>
		<caption>책 목록</caption>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>표지</th>
			<th>가격</th>
			<th>할인율</th>
		</tr>
		<%
			if(books.size() == 0){
				out.println("<tr><td colspan='5'>등록된 책이 없습니다</td></tr>");
			}else{
				for(BookDto book : books){
					int price = book.getBprice();
					int discount = book.getBdiscount();
					int disPrice = price * (100-discount) / 100;
					out.println("<tr>");
					out.println("<td>" + book.getBid() + "</td>");
					out.println("<td>");
					out.println("<a href='detail.jsp?bid=" + book.getBid() + "'>" + book.getBtitle() + "</a>");
					out.println("</td>");
					out.println("<td>");
					out.println("		<a href='detail.jsp?bid=" + book.getBid() + "'><img src ='"
														+ conPath + "/bookFile/" + book.getBimage1() + "' width='30'></a>");
					out.println("</td>");
					out.println("<td><del>" + price + "</del><b>"+disPrice+"원</b></td>");
					out.println("<td>" + discount + "%</td>");
					out.println("</tr>");
				}
			}
		%>
	</table>
		<a href="ex1_list_board.jsp">책 리스트(게시판 스타일)</a><br>
		<a href="ex2_list.jsp">책 1page리스트(게시판 스타일)</a><br>
		<a href="ex3_list_product.jsp">책 전체리스트(product list 스타일)</a><br>
		<a href="ex4_list.jsp">책 1page리스트(product list 스타일)</a><br>
		<button onclick="location.href='<%=conPath%>/lect2_book/bookRegisterForm.html'">책 등록</button> 
</body>
</html>