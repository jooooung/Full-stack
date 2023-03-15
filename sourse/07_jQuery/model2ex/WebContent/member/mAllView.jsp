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
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty adminLoginResult }">
		<script>
			alert('${adminLoginResult}');
		</script>
	</c:if>
	<c:if test="${not empty adminLoginErrorMsg }">
		<script>
			alert('${adminLoginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table>
  		<caption>전체회원보기</caption>
			<tr>
	  		<c:forEach var="dto" items="${members }" >
		  		<td>
		  			<img alt="${dto.mname } 사진" src="${conPath }/mPhotoUp/${dto.mphoto}"
		  					 width="120">
		  			<p>
		  				${dto.mname }<br>
		  				(${dto.mid })
		  			</p>
		  		</td>
	  		</c:forEach>
	  	</tr>
  </table>
  <p class="paging">
  	<a href="${conPath }/allView.do">	<!-- 맨 앞으로( << ) -->
  		&lt;&lt;
  	</a>
  	&nbsp; &nbsp; 
  	<c:if test="${BLOCKSIZE < startPage }">	<!-- 이전 페이지 있을 경우 ( < ) -->
  		<a href="${conPath }/allView.do?pageNum=${startPage-1}">&lt;</a>
  	</c:if>
  	<c:if test="${BLOCKSIZE >= startPage }">	<!-- 이전 페이지 없을 겨우( < ) -->
  		&lt;
  	</c:if>
  	&nbsp; &nbsp; 
  	<c:forEach var="i" begin="${startPage }" end="${endPage }"><!-- 페이지 숫자 -->
  		<c:if test="${i eq pageNum }"><!-- 현재 페이지 -->
  			<b>[${i }]</b>
  		</c:if>
  		<c:if test="${i != pageNum }"><!-- 다른 페이지 -->
  			<a href="${conPath }/allView.do?pageNum=${i}">[${i }]</a>
  		</c:if>
  	</c:forEach>
  	&nbsp; &nbsp; 
  	<c:if test="${endPage < pageCnt }"><!-- 다음페이지( > ) -->
	  	<a href="${conPath }/allView.do?pageNum=${endPage+1}">&gt;</a>
  	</c:if>
  	<c:if test="${endPage eq pageCnt }">
	  	&gt;
  	</c:if>
  	&nbsp; &nbsp; 
  	<a href="${conPath }/allView.do?pageNum=${pageCnt}">&gt;&gt;</a>
  </p>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>