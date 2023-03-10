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
	<c:if test="${not empty loginErrorMsg }">	<!-- 로그인 실패 시 -->
		<script>
			alert('${loginErrorMsg}');
			history.back();
			//location.href = '${conPath }/loginView.do';
		</script>
	</c:if>
	<c:if test="${not empty modifyResult }"><!-- 정보수정성공 -->
		<script>
			alert('${modifyResult}')
		</script>
	</c:if>
	<c:if test="${not empty modifyErrorMsg }"><!-- 정보수정 실패 -->
		<script>
			alert('${modifyErrorMsg}')
		  history.back();
		</script>
	</c:if>
	<c:if test="${not empty withdrawalResult }"><!-- 회원탈퇴 결과 -->
		<script>
			alert('${withdrawalResult}')
		</script>
	</c:if>
	<c:if test="${not empty member }"><!-- 로그인한 main -->
		<table>
		  <tr>
		  	<td><h2>${member.mname }(${member.mid })님 어세오세요</h2></td>
		  </tr>
		  <tr>
		 		<td>
		 			<button onclick="location.href='${conPath}/logout.do'">로그아웃</button>
		 			<button onclick="location.href='${conPath}/modifyView.do'">정보수정</button>
	  			<button onclick="location.href='${conPath}/allView.do'">전체회원보기</button>
	  		</td>
		 	</tr>
	 	</table>
	</c:if>
	<c:if test="${empty member }"><!-- 비로그인 main -->
		<table>
		  <tr>
		  	<td>로그인 상태가 아닙니다</td>
		  </tr>
		  <tr>
		 		<td>
					<button onclick="location.href='${conPath}/loginView.do'" >로그인</button>
	  			<button onclick="location.href='${conPath}/joinView.do'">회원가입</button>
	  			<button onclick="location.href='${conPath}/allView.do'">전체회원보기</button>
				</td>
		 	</tr>
	 	</table>
	</c:if>
</body>
</html>
