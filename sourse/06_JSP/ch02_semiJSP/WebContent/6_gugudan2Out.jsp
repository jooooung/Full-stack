<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		margin:0 auto;
		text-align: center;
	}

	table tr td{
		padding: 0 15px;
	}
</style>
</head>
<body>
	<% // http://localhost:8090/ch02_semiJSP/6_gugudan2Out.jsp
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<table>
		<h2><%=su1 %>단부터 <%=su2 %>단까지 구구단</h2>
		<tr>
			<%for(int i=su1 ; i<=su2 ; i++){ %>
			<td>
				<p><%=i %>단</p>
				<%for(int j=1 ; j<10 ; j++){ %>
					<p><%=i %> * <%=j %> = <%=i * j %> </p>
				<%} %>
			</td>
			<%} %>
		</tr>
	</table>
</body>
</html>