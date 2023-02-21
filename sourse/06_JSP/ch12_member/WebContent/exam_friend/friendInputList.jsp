<%@page import="com.lec.friend.FriendDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
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
	<form action="friendInputListPro.jsp">
		<table>
			<tr>
				<th>친구이름 </th><td><input type="text" name="name" required="required"></td>
				<th>전화 </th><td><input type="text" name="tel"></td>
				<td><input type="submit" value="추가"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th colspan="3">이곳에 DB에 입력된 친구들 리스트</th>
		</tr>
		<tr>
			<td>순번</td><td>이름</td><td>전화</td>
		</tr>
			<%
				FriendDao dao = FriendDao.getInstance();
				ArrayList<FriendDto> friends = dao.friends(); 
				for(int i=0 ; i<friends.size() ; i++){
					int no = friends.get(i).getNo();
					String name = friends.get(i).getName();
					String tel = friends.get(i).getTel();
					out.println("<tr><td>"+ no + "</td>");
					out.println("<td>"+ name + "</td>");
					out.println("<td>"+ (tel==null? "" : tel) + "</td></tr>");
				}
			%>
	</table>
</body>
</html>