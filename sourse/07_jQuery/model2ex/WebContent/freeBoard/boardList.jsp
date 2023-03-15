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
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
	
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(function(){
			$('tr').click(function(){
				var bid = $(this).children().eq(0).text().trim();	// 글번호 가져오기
				if(! isNaN(bid)){
					location.href = '${conPath }/contentView.do?bid='+bid+'&pageNum=${pageNum}';
				}
			});
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table>
			<c:if test="${empty member}">	
				<table>
					<tr>
						<td>
							<a href="${conPath }/loginView.do">
								글쓰기는 사용자 로그인 이후에만 가능합니다
							</a>
					</tr>
				</table>
				<table>
					<tr>
  					<th>글번호</th><th>작성자</th><th>글제목</th><th>조회수</th><th>날짜</th><th>IP</th>
  				</tr>
  				<c:if test="${fileboardList.size() eq 0 }">
  					<tr><td colspan="6">해당 페이지에 글이 없습니다</td></tr>
  				</c:if>
  				<c:if test="${fileboardList.size() != 0 }">
  						<c:forEach var="dto" items="${fileboardList }">
  			<tr>
  				<td>${dto.fid }</td>
  				<td>${dto.mid }</td>
  				<td class="left">
  					<c:forEach var="i" begin="1" end="${dto.findent }"><!-- 들여쓰기 -->
  						<c:if test="${i != dto.findent }"> 
  							&nbsp; &nbsp; 
  						</c:if> 
  						<c:if test="${i eq dto.findent }"><!-- 답글 표시 -->	
  							└
  						</c:if> 
  					</c:forEach><!-- 답글들여쓰기 ,표시 처리 -->
  						${dto.ftitle }
  					<c:if test="${dto.fhit > 10 }">
  						<b>*</b>
  					</c:if><!-- 조회수 높은 글 효과주기 --> 
  				</td>
  				<td>${dto.fip }</td>
  				<td>
  					${dto.frdate }
  				</td>
  				<td>${dto.fhit }</td>
  			</tr>
  		</c:forEach>
  				</c:if>
				</table>
			</c:if><!-- 로그인 전 글쓰기는 로그인 후 -->
			<c:if test="${not empty member}">	
				<table>
					<tr><td><a href="${conPath }/boardWriteView.do">글쓰기</a>
				</table>
				<table>
					<tr>
  					<th>글번호</th><th>작성자</th><th>글제목</th><th>조회수</th><th>날짜</th><th>IP</th>
  				</tr>
  				<c:if test="${fileboardList.size() eq 0 }">
  					<tr><td colspan="6">해당 페이지에 글이 없습니다</td></tr>
  				</c:if>
  				<c:if test="${fileboardList.size() != 0 }">
  						<c:forEach var="dto" items="${fileboardList }">
  			<tr>
  				<td>${dto.fid }</td>
  				<td>${dto.mid }</td>
  				<td class="left">
  					<c:forEach var="i" begin="1" end="${dto.findent }"><!-- 들여쓰기 -->
  						<c:if test="${i != dto.findent }"> 
  							&nbsp; &nbsp; 
  						</c:if> 
  						<c:if test="${i eq dto.findent }"><!-- 답글 표시 -->	
  							└
  						</c:if> 
  					</c:forEach><!-- 답글들여쓰기 ,표시 처리 -->
  						${dto.ftitle }
  					<c:if test="${dto.fhit > 10 }">
  						<b>*</b>
  					</c:if><!-- 조회수 높은 글 효과주기 --> 
  				</td>
  				<td>${dto.fip }</td>
  				<td>
  					${dto.frdate }
  				</td>
  				<td>${dto.fhit }</td>
  			</tr>
  		</c:forEach>
  				</c:if>
				</table>
			</c:if><!-- 로그인 후 글쓰기-->
		</table>
		<div class="paging">
	  	<c:if test="${startPage > BLOCKSIZE }">
	  		[ <a href="${conPath }/boardList.do?pageNum=${startPage-1}">이전</a>]
	  	</c:if>
	  	<c:forEach var="i" begin="${startPage}" end="${endPage }">
	  		<c:if test="${i eq pageNum }">
	  			[ <b>${i }</b> ]
	  		</c:if>
	  		<c:if test="${i != pageNum }">
	  			[ <a href="${conPath }/boardList.do?pageNum=${i}">${i }</a> ]
	  		</c:if>
	  	</c:forEach>
	 		<c:if test="${endPage < pageCnt }">
	 			[ <a href="${conPath }/boardList.do?pageNum=${endPage+1}">다음</a> ]
	 		</c:if>
 	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>