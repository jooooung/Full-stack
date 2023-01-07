package com.lec.ex2_person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDao2 {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private final static int SUCCESS = 1;
	private final static int FAIL = 0;
	private static PersonDao2 INSTANCE;

	public static PersonDao2 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonDao2();
		}
		return INSTANCE;
	}

	private PersonDao2() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public int insertPerson(PersonDto2 dto2) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON \r\n" + "    VALUES (pNO_SEQ.NEXTVAL, ?,\r\n"
				+ "            (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto2.getPname());
			pstmt.setString(2, dto2.getJname());
			pstmt.setInt(3, dto2.getKor());
			pstmt.setInt(4, dto2.getEng());
			pstmt.setInt(5, dto2.getMat());
			System.out.println(result == SUCCESS ? "입력성공" : "입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public ArrayList<PersonDto2> selectJname(String Jname) {
		ArrayList<PersonDto2> dtos = new ArrayList<PersonDto2>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RN, A.* \r\n" + 
				"    FROM (SELECT pNAME||'('||pNO||'번)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM \r\n" + 
				"            FROM PERSON P, JOB J WHERE P.jNO=J.jNO AND jNAME=?\r\n" + 
				"             ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Jname);
			while(rs.next()) {
				int rn = rs.getInt("rn");
				String pno = rs.getString("pno");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto2(rn, pno, Jname, kor, eng, mat, sum));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	public ArrayList<PersonDto2> selectAll(){
		ArrayList<PersonDto2> dtos = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println();
		System.out.println("등수\t이름\t\t직업\t국어\t영어\t수학\t총점");
		String sql = "SELECT ROWNUM RN, A.* \r\n" + 
				"    FROM (SELECT pNAME||'('||pNO||'번)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM \r\n" + 
				"            FROM PERSON P, JOB J WHERE P.jNO=J.jNO \r\n" + 
				"            ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PersonDto2 dto = new PersonDto2();
				dto.setRn(rs.getInt("rn"));
				dto.setPname(rs.getString("pno"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	return dtos;
	}
	public ArrayList<String> jnamelist(){
		ArrayList<String> jnames = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return jnames;
	}
}
