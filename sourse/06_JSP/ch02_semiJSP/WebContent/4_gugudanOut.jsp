<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<caption>6단 구구단</caption>
	<%for(int i=1 ; i<10 ; i++){%>
		<tr>
			<td>6 * <%=i %> = <%=6*i %></td>
		</tr>	
	<%} %>
</body>
</html>