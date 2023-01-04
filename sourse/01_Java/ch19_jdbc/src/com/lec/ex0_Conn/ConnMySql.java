package com.lec.ex0_Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		// JDBC프로그래밍 단계와 사용 클래스

		try {
			Class.forName(driver); // 1. 드라이버 로드
			System.out.println("드라이버 연결 성공");
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2. DB연결객체
			System.out.println("MYSQL 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
