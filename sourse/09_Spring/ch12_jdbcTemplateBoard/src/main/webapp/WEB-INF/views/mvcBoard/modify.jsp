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
  <!-- model의 board, param.bid, param.pageNum -->
  <form action="${conPath }/mvcBoard/modify.do" method="post">
  	<input type="hidden" name="pageNum" value="${param.pageNum }">  <!-- hidden 타입으로 pageNum 넘기기 -->
  	<input type="hidden" name="bid" value="${board.bid }">	<!-- hidden 타입으로 bid 넘기기 -->
  	<table>
  		<caption>${board.bid }번 글 수정</caption>
		 	<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="bname" value="${board.bname }" required="required">
				</td>  	
  		</tr>
  		<tr>
  			<th>제목</th>
  			<td>
  				<input type="text" name="btitle" value="${board.btitle }" required="required">
  			</td>
  		</tr>
  		<tr>
  			<th>본문</th>
  			<td>
  				<textarea rows="5" name="bcontent">${board.bcontent }</textarea>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2">
  				<input type="submit" value="수정" class="btn"> 
  				<input type="reset" value="취소" class="btn" onclick="history.back()"> 
  				<input type="button" value="목록" class="btn" onclick="location.href='${conPath }/mvcBoard/list.do?pageNum=${param.pageNum}'"> 
  			</td>
  		</tr>
  	</table>
  </form>
</body>
</html>