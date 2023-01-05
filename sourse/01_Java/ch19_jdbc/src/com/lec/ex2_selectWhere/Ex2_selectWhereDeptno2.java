package com.lec.ex2_selectWhere;
//사용자에게 원하는 부서번호를 받아 부서정보를 출력, 해당 정보의 사원정보도 출력

// 1. 해당부서번호가 없는 경우 : 존재하지 않는 부서입니다 
// 2. 해당부서번호가 있는 경우 : 부서 정보 출력
// 2-1. 해당부서 사원이 있는 경우 : 사원 정보 출력(사번, 이름, 급여, 상사이름)
// 2-2. 해당부서 사원이 없는 경우 : 해당 부서 사원이 없습니다

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("원하는 부서번호는 ? ");
		int deptno = scanner.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER\r\n" + "    FROM EMP W, EMP M \r\n"
				+ "    WHERE W.MGR=M.EMPNO AND W.DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println(deptno + "번 부서정보는 다음과 같습니다");

				System.out.println("부서명  : " + rs.getString("dname"));
				System.out.println("위치   : " + rs.getString("loc"));
				System.out.println();
				rs2 = stmt.executeQuery(sql2);
				if (rs2.next()) {
					do {
						String empno = rs2.getString("empno");
						String ename = rs2.getString("ename");
						int sal = rs2.getInt("sal");
						String manager = rs2.getString("manager");
						System.out.println("-" + ename);
						System.out.println("사번 : " + empno);
						System.out.println("이름 : " + ename);
						System.out.println("급여 : " + sal);
						System.out.println("상사이름 : " + manager);
						System.out.println();
					} while (rs2.next());
				} else {
					System.out.println("해당 부서는 사원이 0명");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs2 != null)
					rs2.close();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
