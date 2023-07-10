<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board List</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
	$(function() {

	});
	</script>
</head>
<body>
	<table>
		<caption>List</caption>
		<tr>
			<td><a href="${conPath }/board/writeView.do">글쓰기</a></td>		
		</tr>
	</table>
	<table>
		<tr>
			<th>순번</th>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${list.size() eq 0 }">
			<tr><td colspan="7">해당 페이지의 글이 없음</td></tr>
		</c:if>
		<c:if test="${list.size() != 0 }">
			<c:set var="num" value="${paging.totCnt - paging.startRow + 1 }"/>
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${num }</td>
					<td>${dto.bid }</td>
					<td>${dto.bname }</td>
					<td class="left">
						<!-- 들여쓰기 -->
						<c:forEach var="i" begin="1" end="${dto.bindent}" >
							<c:if test="${i != dto.bindent }">
								&nbsp; &nbsp; 
							</c:if>
							<!-- 답글표시 -->
							<c:if test="${i eq dto.bindent }">
								ㄴ
							</c:if>
						</c:forEach>
						<a href="${conPath }/board/detail.do?bid=${dto.bid}&pageNum=${paging.currentPage}">
							${dto.btitle }
						</a>
						<c:if test="${dto.bhit > 10 }">
  							<b>*</b>
  						</c:if>
					</td>
					<td>
	  					<fmt:formatDate value="${dto.bdate }" pattern="yy/MM/dd(E) hh:mm(a)"/>
	  				</td>
	  				<td>${dto.bhit }</td>
				</tr>
				<c:set var="num" value="${num + 1 }"/>
			</c:forEach>
		</c:if>
	</table>
	 <div id="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			<a href="${conPath }/board/list.do?pageNum=${paging.startPage-1}">이전</a>
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }"> 
				<b>${i }</b>
			</c:if>
			<c:if test="${i != paging.currentPage }"> 
				<a href="${conPath }/board/list.do?pageNum=${i}">${i }</a>
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			<a href="${conPath }/board/list.do?pageNum=${paging.endPage+1}">다음</a>
		</c:if>
	</div>
</body>
</html>