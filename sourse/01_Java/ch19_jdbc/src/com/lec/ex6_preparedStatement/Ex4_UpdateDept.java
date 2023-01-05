package com.lec.ex6_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//수정할 부서번호를 받아 존재하는 부서번호면 수정, 존재하지 않으면 수정하지 않는다
public class Ex4_UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String updateQuery = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectQuery);
			System.out.print("수정할 부서번호는 ? ");
			int deptno = scanner.nextInt();
			pstmt.setInt(1, deptno); // ? 채우기
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.print("수정할 부서명은 ? ");
				String dname = scanner.next();
				System.out.print("수정할 위치는 ? ");
				String loc = scanner.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(updateQuery);
				pstmt.setString(1, "dname");
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				if (result > 0) {
					System.out.println("수정성공");
				}
			} else {
				System.out.println("존재하지 않는 부서번호입니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
