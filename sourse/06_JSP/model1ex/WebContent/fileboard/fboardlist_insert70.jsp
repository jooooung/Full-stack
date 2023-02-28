<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
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
	FileboardDao fDao = FileboardDao.getInstance();
	FileboardDto dto = new FileboardDto();
	for(int i=0 ; i<=70 ; i++){
		// 글등록
		// cid session으로 받기
		if(i%3 == 0){
			dto.setCid("aaa");
		}else if(i%3 == 1){
			dto.setCid("bbb");
		}else if(i%3 == 2){
			dto.setCid("bbb");
		}
		dto.setFsubject("더미" + i);
		dto.setFcontent("더미" + i);
		if(i%5==0){
			dto.setFfilename("1.docx");
		}else{
			dto.setFfilename(null);
		}
		dto.setFpw("1");
		dto.setFip("111.0.0." + i);
		System.out.println(fDao.insertFileboard(dto)==1 ? i+"번째 성공" : i+"번째 실패");
	}
	response.sendRedirect("fboardList.jsp");
	%>
</body>
</html>