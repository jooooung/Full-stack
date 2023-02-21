<%@page import="com.lec.friend.FriendDao"%>
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
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		FriendDao dao = FriendDao.getInstance();
		int result = dao.addFriend(dto);
		if(result == FriendDao.SUCCESS){
	%>	
		<script>	
			alert("친구추가 성공");
			location.href='friendInputList2.jsp';
		</script>	
	<%} else{%>
		<script>	
			alert("친구추가 실패");
			location.href='friendInputList2.jsp';
		</script>
	<%} %>
</body>
</html>