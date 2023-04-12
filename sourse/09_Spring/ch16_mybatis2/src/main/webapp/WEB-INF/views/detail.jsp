<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/emp.css" rel=stylesheet>
	
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script>
		$(document).ready(function(){
			$('button.delete').click(function(){
				Swal.fire({
				  title: '정말 삭제하시겠습니까?',
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '삭제',
				  cancelButtonText: '취소'
				}).then((result) => {	
				  if (result.isConfirmed) {
				  	 location.href="${conPath}/delete.do?empno=${param.empno }&pageNum=${param.pageNum }";
				  }
				})
			});
		});
	</script>
</head>
<body>
	<c:set var="success" value="1"/>
	<c:if test="${modifyResult eq success}">
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<script>
			swal('수정 성공', '', 'success');
		</script>
	</c:if>
	<table>
		<caption>직원정보</caption>
		<tr>
			<th>사번</th>
			<td>${empDto.empno }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${empDto.ename}</td>
		</tr>
		<tr>
			<th>업무</th>
			<td>${empDto.job }</td>
		</tr>
		<tr>
			<th>급여</th>
			<td>${empDto.sal}</td>
		</tr>
		<tr>
			<th>입사일</th>
			<td>
				<fmt:formatDate value="${empDto.hiredate}" pattern="yy년MM월dd일(E)"/>
			</td>
		</tr>
		<tr>
			<th>보너스</th>
			<td>${empDto.comm }</td>
		</tr>
		<tr>
			<th>관리자사번</th>
			<td>${empDto.mgr == 0? '':empDto.mgr }</td>
		</tr>
		<tr>
			<th>부서코드</th>
			<td>${empDto.deptno }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${conPath}/empDeptList.do?pageNum=${param.pageNum }'">
					목록
				</button>
				<button onclick="location.href='${conPath}/updateView.do?empno=${param.empno }&pageNum=${param.pageNum }'">
					수정
				</button>
				<button class="delete" <%-- onclick="location.href='${conPath}/delete.do?empno=${param.empno }&pageNum=${param.pageNum }'" --%>>
					삭제
				</button>
			</td>
		</tr>
	</table>
</body>
</html>