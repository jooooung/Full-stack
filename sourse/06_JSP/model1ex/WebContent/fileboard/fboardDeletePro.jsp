<%@page import="com.lec.dao.FileboardDao"%>
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
	<%
		int fnum = Integer.parseInt(request.getParameter("fnum"));
	  String fpw = request.getParameter("fpw");
	  String pageNum = request.getParameter("pageNum");
	  FileboardDao fDao = FileboardDao.getInstance();
	  int result = fDao.deleteFileboard(fnum, fpw);
	  if(result == FileboardDao.SUCCESS){
	%>
		 	<script>
		 		alert('<%=fnum%>번 글 삭제 완료');
		 		location.href='fboardList.jsp?pageNum=<%=pageNum%>';
		 	</script>
	<%}else{ %>	
		 	<script>
		 		alert('비밀번호를 확인하세요');
	 			history.back();
		 	</script>
	<%}%>
</body>
</html>