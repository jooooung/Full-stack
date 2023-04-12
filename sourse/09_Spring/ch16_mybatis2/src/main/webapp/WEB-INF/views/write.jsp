<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/emp.css" rel=stylesheet>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script>
		$(document).ready(function(){
			$('form').submit(function(){
				let confirmMsg = $('span').text().trim();
				if(!confirmMsg){
					swal('사번 중복확인 후 등록해주세요', '', 'info');
					return false;
				}else if(confirmMsg != '사용가능한 사번입니다'){
					swal('사용 불가한 사번입니다', '', 'error');
					frm.empno.focus();
					return false;
				}
			});
		});	// submit 제한 event
		
		function idConfirmChk(){	// 사번 중복확인 버튼 function
			var empno = frm.empno.value;
			if(!empno){
				swal('사번을 입력해주세요','','info');
				frm.empno.focus();
			}else{
				var ename = frm.ename.value;
				var job	  = frm.job.value;
				var mgr	  = frm.mgr.value;
				var hiredate = frm.hiredate.value;
				<%-- if(!hiredate){
					hiredate = '<%= new Date(System.currentTimeMillis())%>';
				} --%>
				var sal	  = frm.sal.value;
				var comm  = frm.comm.value;
				var deptno = frm.deptno.value;
				location.href='confirmNo.do?empno='+empno
											+'&ename='+ename
											+'&job='+job
											+'&mgr='+mgr
											+'&hiredate='+hiredate
											+'&sal='+sal
											+'&comm='+comm
											+'&deptno='+deptno;
											
			}
		}	// 사번 입력 후 중복확인 시 event
		
		function empnoLimit(empno, maxlength) {
			  if(empno.value.length > maxlength)  {
				  empno.value 
			      = empno.value.substr(0, maxlength);
			  }
			} // empno 입력 길이 제한
	</script>
</head>
<body>
	<c:if test="${not empty writeResult}">
		<script>
			swal('등록 실패', '${writeResult}', 'error');
		</script>
	</c:if>
	<form action="${conPath }/write.do" method="POST" name="frm">
		<table>
			<caption>직원등록</caption>
			<tr>
				<th>사번</th>
				<td>
					<input type="number" name="empno" required="required" min="0" value="${param.empno }" oninput="empnoLimit(this, 4)">
					<input type="button" value="중복확인" onclick="idConfirmChk()"><br>
					<span>${confirmMsg }</span>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="ename" value="${param.ename }"></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type="text" name="job" value="${param.job }"></td>
			</tr>
			<tr>
				<th>관리자사번</th>
				<td>
					<select name="mgr">
						<c:forEach var="mgrEmp" items="${managerList }">
							<option value="${mgrEmp.empno }"
								<c:if test="${mgrEmp.empno eq param.mgr }">
									selected = "selected
								</c:if>
							>
								${mgrEmp.empno}-${mgrEmp.ename }
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="date" name="hiredate" required="required" value="${param.hiredate }"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="number" name="sal" required="required"  min="0" value="${param.sal }"></td>
			</tr>
			<tr>
				<th>보너스</th>
				<td><input type="number" name="comm"  min="0" value="${param.comm }"></td>
			</tr>
			<tr>
				<th>부서코드</th>
				<td>
					<select name="deptno">
						<c:forEach var="dept" items="${deptList }">
							<option value="${dept.deptno}"
								<c:if test="${dept.deptno eq param.depteno }">
									selected = "selected"
								</c:if>
							>
								${dept.deptno}-${dept.dname }
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="button" value="목록" onclick="location.href='${conPath}/empDeptList.do'">
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>