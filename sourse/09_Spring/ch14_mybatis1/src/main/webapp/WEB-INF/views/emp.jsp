<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/emp.css" rel=stylesheet>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script>
		$(document).ready(function(){
			$('input[type="text"]').keyup(function(){
				$('form').submit();
			}); /* input 입력 시  submit event */
			$('select').change(function(){
				$('form').submit();
			}); /* select 선택 시  submit event */
		});
	</script>
</head>
<body>
	<div id="wrap">
		<form> <!-- action 생략 시 요청경로는 현재 페이지 -->
			사원명 
			<input type="text" name="ename" value="${schEmp.ename }" size="5">  
			직책
			<input type="text" name="job" value="${schEmp.job }" size="5">
			<!-- value 지정은 검색값 유지를 위해 지정-->
			<!-- value는  컨트롤러에서  매개변수를 @ModelAttribute로 정한 이름-->
			부서
			<select name="deptno">
				<!-- value가 0이면 부서검색 미실행 - emp.xml에서 처리하였다 -->
				<option value="0" >모든부서</option>
				<c:forEach var="dept" items="${deptList }">	<!-- items는 컨트롤러에서 @ModelAttribute한 이름 -->
					<option value="${dept.deptno }"
						<c:if test="${schEmp.deptno eq  dept.deptno}">
							selected="selected"	
						</c:if>
					><!-- 선택한 옵션을 유지시키기 -->
						${dept.deptno }-${dept.dname }
					</option>
				</c:forEach>
			</select>
		</form>
		<table>
			<tr>	
				<th>사원번호</th>
				<th>이름</th>
				<th>직책</th>
				<th>관리자</th>
				<th>입사일</th>
				<th>급여</th>
				<th>상여</th>
				<th>부서번호</th>
			</tr>
			<c:if test="${epmList.size() eq 0 }">
				<tr><th colspan="8">일치하는 사원이 없습니다</th></tr>
			</c:if>
			<c:forEach var="emp" items="${empList }">
				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td><fmt:formatDate value="${emp.hiredate }" pattern="yy년MM월dd일"/></td>
					<td><fmt:formatNumber value="${emp.sal }" pattern="#,###.#"/></td>
					<td>${emp.comm }</td>
					<td>${emp.deptno }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>