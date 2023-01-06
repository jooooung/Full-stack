package com.lec.ex2_person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	private static PersonDao INSTANCE;

	public static PersonDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}

	private PersonDao() {
		try {
			Class.forName(driver);// 1단계는 생성자에서 한번
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1번 기능 dto(이름, 직업명, 국영수)를 받아 DB에 insert하고 SUCCESS/FAIL을 return
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		// DB insert하고 결과를 result에 할당
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON " + 
				"    VALUES (pNO_SEQ.NEXTVAL, ?," + 
				"            (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "성공":"실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 2번 기능 직업명을 받아 DB에 select한 결과를 ArrayList<PersonDto> 로 return
	public ArrayList<PersonDto> selectJname(String Jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// DB 결과를 dtos에 add한다
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RN, A.* " + 
				"    FROM (SELECT pNAME||'('||pNO||'번)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM " + 
				"            FROM PERSON P, JOB J WHERE P.jNO=J.jNO AND jNAME=?" + 
				"             ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rn = rs.getInt("rn");
				String pname = rs.getString("pno");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rn, pname, Jname, kor, eng, mat, sum));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return dtos;
	}
	// 3번 기능 DB에 전체 select한 결과를 ArrayList<PersonDto> 로 return
	public ArrayList<PersonDto> selectAll(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		Statement stmt  = null;
		ResultSet 	 rs = null;
		String sql = "SELECT ROWNUM RN, A.* " + 
				"    FROM (SELECT pNAME||'('||pNO||'번)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM " + 
				"            FROM PERSON P, JOB J WHERE P.jNO=J.jNO " + 
				"            ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setRn(rs.getInt("rn"));
				dto.setPname(rs.getString("pno"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
				dtos.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return dtos;
	}
	// 4번 기능 jname들을 ArrayList<PersonDto> 로 return
	public ArrayList<String> jnamelist(){
		ArrayList<String> jnames = new ArrayList<String>();
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return jnames;
	}
}
