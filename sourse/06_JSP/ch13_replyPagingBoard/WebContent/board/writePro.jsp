<%@page import="com.lec.dao.BoardDao"%>
<%@page import="java.sql.Timestamp"%>
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
		// num, ref, ref_step, ref_indent (0이면 원글, 아니면 답글쓰기)
		// writer subject content email pw(원글 or 답변글)
		request.setCharacterEncoding("UTF-8"); 
		String pageNum = request.getParameter("pageNum");
	%>	
	<!-- bean 객체 사용시에는 dto에매개변수 없는 생성자가 있어야한다 -->
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto" scope="page"/>  
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr());	// 클라이언트가 요청한 컴퓨터 ip
		// dto.setRdate(new Timestamp(System.currentTimeMillis()));	  
		// 테이블에서 default sysdate가 지정 안되있다면 현재 시간 가져오기	
		BoardDao bDao = BoardDao.getInstance();	
		int result;
		int num = dto.getNum();
		if(num == 0){	// 원글 쓰기
			result = bDao.insertBoard(dto);	// 저장
		}else{	// 답글 쓰기
			result = bDao.reply(dto);			
		}
		if(result == BoardDao.SUCCESS){	// 글쓰기 성공 시 리스트 페이지로 이동
	%>
			<script>
				alert('<%=num==0? "글쓰기 완료" : "답글 쓰기 완료"%>');
				location.href='<%=conPath%>/board/list.jsp?pageNum=<%=num==0? 1 : pageNum%>';
			</script>
	<%}else{%>
			<script>
				alert('<%=num==0? "글쓰기 실패" : "답글 쓰기 실패"%>');
				history.go(-1);
			</script>
	<%}%>
</body>
</html>