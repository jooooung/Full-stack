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
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
	$(document).ready(function(){
  		/* $('tr').click(function(){
  			var bid = $(this).children().eq(2).text().trim();	// string tr의 첫번째의 text
  			if(! isNaN(bid)){	// title 클릭 시 무반응
  				location.href = '${conPath }/mvcBoard/contentView.do?bid='+bid+'&pageNum=${pageNum}';
  			}
  		}); */
  	});
	const trClicked = (bid) => {
		location.href = '${conPath}/mvcBoard/content.do?bid='+bid+'&pageNum=${pageNum}'
	};
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${writeResult eq SUCCESS }">
		<script>alert('글쓰기 성공')</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>alert('글쓰기 실패')</script>
	</c:if>
	<c:if test="${not empty deleteResult }">
		<script>alert('${deleteResult}');</script>
	</c:if>
	<c:if test="${replyResult eq SUCCESS }">
		<script>alert('${param.bid}번 글 답글쓰기 성공')</script>
	</c:if>
	<c:if test="${replyResult eq FAIL }">
		<script>alert('${param.bid}번 글 답글쓰기 실패')</script>
		history.back();
	</c:if>
  <table>
  	<caption>글목록</caption>
  	<tr>
  		<td><a href="${conPath }/mvcBoard/write.do">글쓰기</a></td>
  	</tr>
  </table>
  <table>
  	<tr>
  		<th>순번</th><th>역순</th><th>글번호</th>
  		<th>글쓴이</th><th>글제목</th><th>작성일</th><th>조회수</th>
  	</tr>
  	<c:if test="${toCnt.size() eq 0 }">
  		<tr><td colspan="7">해당 페이지에 글이 없습니다</td></tr>
  	</c:if>
  	<c:if test="${list.size() != 0 }">
  		<c:set var="oNum" value="${orderNum }"/>
  		<c:set var="iNum" value="${inverseNum }"/>
  		<c:forEach var="dto" items="${boardList }">
  			<tr onclick="trClicked(${dto.bid})">
  				<td>${oNum }</td>
  				<td>${iNum }</td>
  				<td>${dto.bid }</td>
  				<td>${dto.bname }</td>
  				<td class="left">
  					<!-- 들여쓰기 -->
  					<c:forEach var="i" begin="1" end="${dto.bindent }">
  						<c:if test="${i != dto.bindent }"> 
  							&nbsp; &nbsp; 
  						</c:if> 
  						<!-- 답글 표시 -->
  						<c:if test="${i eq dto.bindent }">	
  							└
  						</c:if> 
  					</c:forEach><!-- 답글들여쓰기 ,표시 처리 -->
  					<%-- <a href="${conPath }/contentView.do?bid=${dto.bid}&pageNum=${pageNum}"> --%>
  						${dto.btitle }
  					<!-- </a> -->
  					<!-- 조회수 높은 글 효과주기 -->
  					<c:if test="${dto.bhit > 10 }">
  						<b>*</b>
  					</c:if> 
  				</td>
  				<td>
  					<fmt:formatDate value="${dto.bdate }" pattern="yy/MM/dd(E) hh:mm(a)"/>
  				</td>
  				<td>${dto.bhit }</td>
  			</tr>
  			<c:set var="oNum" value="${oNum + 1 }"/>
  			<c:set var="iNum" value="${iNum - 1 }"/>
  		</c:forEach>
  	</c:if>
  </table>
  <div class="paging">
  	<c:if test="${startPage > BLOCKSIZE }">
  		[ <a href="${conPath }/mvcBoard/list.do?pageNum=${startPage-1}">이전</a>]
  	</c:if>
  	<c:forEach var="i" begin="${startPage}" end="${endPage }">
  		<c:if test="${i eq pageNum }">
  			[ <b>${i }</b> ]
  		</c:if>
  		<c:if test="${i != pageNum }">
  			[ <a href="${conPath }/mvcBoard/list.do?pageNum=${i}">${i }</a> ]
  		</c:if>
  	</c:forEach>
 		<c:if test="${endPage < pageCnt }">
 			[ <a href="${conPath }/mvcBoard/list.do?pageNum=${endPage+1}">다음</a> ]
 		</c:if>
  </div>
</body>
</html>