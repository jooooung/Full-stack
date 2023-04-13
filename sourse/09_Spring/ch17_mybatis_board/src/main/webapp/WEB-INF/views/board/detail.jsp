<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${modifyResult eq SUCCESS}">
		<script>alert('${param.bid}번 글 수정 성공')</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL}">
		<script>alert('${param.bid}번 글 수정 실패')</script>
		history.back();
	</c:if>
	<div id="detail">
	<table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>${boardDto.bid }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardDto.btitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardDto.bname }</td>
		</tr>
		<tr>
			<th>본문</th>
			<td><pre>${boardDto.bcontent }</pre></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${boardDto.bdate }" pattern="yy/MM/dd(E) HH:mm"/>	
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardDto.bhit }</td>
		</tr>
		<tr>
			<th>IP</th>
			<td>${boardDto.bip }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${conPath}/board/modifyView.do?bid=${param.bid }&pageNum=${param.pageNum }'">
					수정
				</button>
				<button onclick="location.href='${conPath}/board/delete.do?bid=${param.bid }&pageNum=${param.pageNum }'">
					삭제
				</button>
				<button onclick="location.href='${conPath}/board/replyView.do?bid=${param.bid }&pageNum=${param.pageNum }'">
					답변
				</button>
				<button onclick="location.href='${conPath}/board/list.do?pageNum=${param.pageNum }'">
					목록
				</button>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>