<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String msg = "";
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		String cname = request.getParameter("cname");
		String method = request.getParameter("method");
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.loginCheck(cid, cpw);
		if(result == CustomerDao.SUCCESS){	// 로그인 성공
			CustomerDto customer = cDao.getCustomer(cid);
			session.setAttribute("customer", customer);
			if(method.equals("null")){		// 정보수정 로그인이 아니면 메인으로
				response.sendRedirect(conPath + "/main/main.jsp");
			}else{	// 정보수정, 책등록 로그인 시 정보수정, 책등록 페이지로 가기
				response.sendRedirect(conPath + "/" + method + ".jsp");;
			}
		}else if(result == CustomerDao.FAIL){	
			msg = URLEncoder.encode("아이디나 비밀번호를 확인하세요");   
			response.sendRedirect("loginForm.jsp?msg="+msg);
		}
	%>
</body>
</html>