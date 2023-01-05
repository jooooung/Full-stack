package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>();
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(jobs);
		do {
			System.out.print("1:입력 || 2:직업별조회 || 3:전체조회 || 그외:종료");
			fn = sc.next();
			switch(fn) {
			case "1" : // 이름, 직업명(jobs), 국,영, 수 받아 insert
				sql = "INSERT INTO PERSON " + 
						"    VALUES (PNO_SQN.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), " + 
						"            ?, ?, ?)";
				try {
					// 1단계 드라이버로드는 한번만 하면 됨(위에서 했음)
					// 2~6단계
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("이름 : ");
					String pname = sc.next();
					System.out.print("직업 : ");
					String jname = sc.next();
					System.out.print("국어 : ");
					int kor = sc.nextInt();
					System.out.print("영어 : ");
					int eng = sc.nextInt();
					System.out.print("수학 : ");
					int mat = sc.nextInt();
					pstmt.setString(1, "pname");
					pstmt.setString(2, "jname");
					pstmt.setString(3, "kor");
					pstmt.setString(4, "eng");
					pstmt.setString(5, "mat");
					rs = pstmt.executeQuery();
					rs.next();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// 7단계 close
					try {
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "2": // 직업명받아 직업 출력
				sql = "";
				try {
					// 2~6단계
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					// 7단계 close
				}
				break;
			case "3":
				sql = "";
				try {
					// 2~6단계
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					// 7단계 close
				}
				break;
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
