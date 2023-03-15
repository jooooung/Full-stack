<%@page import="com.lec.ex.dto.MemberDto"%>
<%@page import="com.lec.ex.dao.MemberDao"%>
<%@page import="com.lec.ex.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
  	String mid=null, ftitle=null, fcontent=null, ffilename=null, fip=null;
  	FileboardDao fDao = new FileboardDao();
  	
  	for(int i=1 ; i<=100 ; i++){
  		ftitle = "제목" + i;
  		fcontent = "본문" + i;
  		ffilename = "NOIMG.png";
  		fip = "192.1.1." + i;
  		int result = fDao.write(mid, ftitle, fcontent, ffilename, fip);
  		System.out.println(result==1? i+"번째 성공":i+"번째 실패");
  	}
  	response.sendRedirect("../boardList.do");
  %>
</body>
</html>