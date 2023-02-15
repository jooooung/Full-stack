<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%!
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	
		String uid		= "scott";
		String upw		= "tiger";
	%>
	<table>
	<%
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs		= null;
		String sql = "SELECT * FROM EMP";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");	// 2. db연결
			stmt = conn.createStatement();	// 3. SQL전송 객체
			rs	 = stmt.executeQuery(sql);	// 4. SQL전송 + 5. SQL결과 받기
			if(rs.next()){	// 데이터가 있는 경우
					out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>" + 
													"<th colspan='2'>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
					do{
						// 6. 결과받아 적당한 로직 수행
						int empno 			 = rs.getInt("empno");
						String ename 	 = rs.getString("ename");
						String job 		 = rs.getString("job");
						int mgr 	 = rs.getInt("mgr");
						Date hiredateD = rs.getDate("hiredate");
						Timestamp hiredateT = rs.getTimestamp("hiredate");
						int sal 			 = rs.getInt("sal");
						int comm		   = rs.getInt("comm");
						int deptno 			 = rs.getInt("deptno");
						out.println("<tr><th>"+empno+"</th><th>"+ename+"</th><th>"+job+"</th><th>"+mgr+"</th>" + 
										"<th>"+hiredateD+"</th><th>"+hiredateT+"</th><th>"+sal+"</th><th>"+comm+"</th><th>"+deptno+"</th></tr>");
					}while(rs.next());
			}else{	// 데이터가 없는 경우
				out.println("<tr><td>입력된 데이터가 없습니다</td></tr>");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(rs   != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
	%>
	</table>
</body>
</html>