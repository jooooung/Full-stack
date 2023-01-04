package com.lec.ex1_selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	// thin:오라클 버전, 1521 : 오라클 포트, xe:오라클 버전
		String sql = "SELECT * FROM EMP";
		Connection conn = null;	// db 연결 객체
		Statement  stmt = null;	// sql 전송할 객체
		ResultSet  rs 	= null;	// select 전송 결과를 받을 객체
		try {
			Class.forName(driver);	//1
			conn = DriverManager.getConnection(url, "scott", "tiger");  //2
			stmt = conn.createStatement();	// 3
			rs	 = stmt.executeQuery(sql);	// 4, 5
			if(rs.next()) {	//select 결과가 1행 이상
				System.out.println("사번\t이름\t직책\t상사사번\t입사일\t급여\t상여\t부서번호");
				do {
					int empno = rs.getInt(1);
					String ename = rs.getString("ename");
					String job	 = rs.getString("job");
					String mgr	 = rs.getString("mgr");
					//String hiredate = rs.getString("hiredate");
					Date	 hiredate = rs.getDate("hiredate");	// Date : 시간 미포함
					Timestamp hiredate1 = rs.getTimestamp("hiredate");	//Timestamp : 시간 포함
					int 	  sal		= rs.getInt("sal");
					int		  comm		= rs.getInt("comm");
					int		  deptno	= rs.getInt("deptno");
					System.out.printf("%d\t %s\t %s\t %s\t %TF %d\t %d\t %d\n", empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} while(rs.next());
			} else {	// select 결과가 1행도 없음
				System.out.println("등록된 사원 정보가 없습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null)   rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
