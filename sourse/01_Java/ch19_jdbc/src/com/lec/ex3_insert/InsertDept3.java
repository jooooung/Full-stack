package com.lec.ex3_insert;
//입력받은 부서번호가 중복된 부서번호면 계속 입력받기

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			while (true) {
				System.out.println("입력할 부서번호는 ? ");
				int deptno = scanner.nextInt();
				// 중복체크
				String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectQuery);
				rs.next();
				int cnt = rs.getInt("cnt"); // cnt는 검색한 deptno를 세는 값
				if (cnt != 0) { // 따라서 cnt가 0이 아니면 deptno가 존재
					System.out.println("중복된 부서번호입니다");
				} else {
					System.out.println("입력할 부서명은 ? ");
					String dname = scanner.next();
					System.out.println("입력할 부서 위치는 ? ");
					String loc = scanner.next();
					String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
					int result = stmt.executeUpdate(sql); // insert update delete
					System.out.println(result > 0 ? "입력성공" : "입력실패");
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
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
