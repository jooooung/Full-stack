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
	<script>
		const search = function(){
			var name = frm.name.value;
			var tel = frm.tel.value;
			location.href='friendInputList2.jsp?name='+name+'&tel='+tel;
		};
	</script>
</head>
<body>
	<form action="friendInputListPro2.jsp" name="frm">
		<table>
			<tr>
				<th>친구이름 </th>
				<td><input type="text" name="name" required="required"
														value='<%String name = request.getParameter("name");
																			if (name!=null) out.print(name);
																		%>'>
				</td>
				<th>전화 </th>
				<td><input type="text" name="tel"
																value='<%String tel = request.getParameter("tel");
																			if (tel!=null) out.print(tel);
																		%>'>
				</td>
				<td><input type="button" value="검색" onclick="search()"></td>
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
				ArrayList<FriendDto> friends = dao.schFriends(name, tel); 
				for(int i=0 ; i<friends.size() ; i++){
					int no = friends.get(i).getNo();
					name = friends.get(i).getName();
					tel = friends.get(i).getTel();
					out.println("<tr><td>"+ no + "</td>");
					out.println("<td>"+ name + "</td>");
					out.println("<td>"+ (tel==null? "" : tel) + "</td></tr>");
					
				}
			%>
	</table>
</body>
</html>