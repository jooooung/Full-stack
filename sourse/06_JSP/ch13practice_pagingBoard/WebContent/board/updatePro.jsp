<%@page import="org.omg.PortableInterceptor.SUCCESSFUL"%>
<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
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
  <% request.setCharacterEncoding("utf-8"); %>
  <jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
  <jsp:setProperty property="*" name="dto"/>
  <%
	  String pageNum = request.getParameter("pageNum");
  	dto.setIp(request.getRemoteAddr());
  	BoardDao bDao = BoardDao.getInstance();
  	int result = bDao.updateBoard(dto);
  	if(result == BoardDao.SUCCESS){
  		%>
 		<script>
 			alert('글 수정 성공');
 			location.href= '<%=conPath%>/board/content.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>';
 		</script>
	<%}else{ %>	
 		<script>
 			alert('글 수정 실패');
 			history.go(-1);
 		</script>
	<%}%>
</body>
</html>