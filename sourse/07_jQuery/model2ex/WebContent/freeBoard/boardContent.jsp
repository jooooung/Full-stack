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
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(function(){
		
		});
	</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<table>
			<tr>
				<th>작성자</th>
				<td>
					${board.mname }(${board.mid })님
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					${board.ftitle}
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td>
					${board.fcontent}
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:if test="${not empty board.ffilename }">
						<img alt="${board.mname }님 첨부파일" src="${conPath }/fileBoardUp/${board.ffilename }"> 
					</c:if>
					<c:if test="${empty board.ffilename }">
						첨부파일 없음 
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<c:if test="${not empty member }">
					<button onclick="location.href='${conPath }/boardReplyView.do?fid=${board.fid}&pageNum=${param.pageNum }'">답변</button>
				</c:if>
					<button onclick="location.href='${conPath }/boardList.do?pageNum=${param.pageNum }'">목록</button>
				<c:if test="${member.mid eq board.mid }">
					<button onclick="location.href='${conPath }/boardDelete.do?fid=${board.fid}&pageNum=${param.pageNum }'">삭제</button>
					<button onclick="location.href='${conPath }/boardModifyView.do?fid=${board.fid}&pageNum=${param.pageNum }'">수정</button>	
				</c:if>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>