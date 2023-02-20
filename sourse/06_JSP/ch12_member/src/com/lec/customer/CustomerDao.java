package com.lec.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomerDao {
	public static final int SUCCESS = 1; // 회원가입, 정보수정시 성공 리턴값
	public static final int FAIL = 0; // 회원가입, 정보수정시 실패 리턴값
	public static final int CUSTOMER_NONEXISTENT = 1;	// 사용가능한 ID일 때 리턴값
	public static final int CUSTOMER_EXISTENT = 0;	// 중복된 ID일 때 리턴값
	public static final int LOGIN_SUCCESS = 1;	// 로그인 성공 리턴값
	public static final int LOGIN_FAIL = 0;	// 로그인 실패  리턴값
	// 싱글톤
	private static CustomerDao instance = new CustomerDao();
	public static CustomerDao getInstance() {
		return instance;
	}
	private CustomerDao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();	// DataSource안의 conn 가져오기
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}	
		return conn;
	}
	// 1. 회원가입시 id 중복체크 : 
	public int confirmID(String cid) {
		int result = CUSTOMER_EXISTENT;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs    = null;
		String sql = "SELECT COUNT(*) FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			if(cnt == 0) {
				result = CUSTOMER_NONEXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2. 회원가입 : 
	public int joinCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)" + 
				"    		VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCgender());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공" : "회원가입실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 3. 로그인 : 
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=? AND CPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = LOGIN_SUCCESS;
			}else {
				result = LOGIN_FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null) 	rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) 	conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return result;
	}
	// 4. cid로 DTO 가져오기 : 
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cPW = rs.getString("cPW");
				String cNAME = rs.getString("cNAME");
				String cTEL = rs.getString("cTEL");
				String cEMAIL= rs.getString("cEMAIL");
				String cADDRESS = rs.getString("cADDRESS");
				Date cBIRTH = rs.getDate("cBIRTH");
				String cGENDER = rs.getString("cGENDER");
				Timestamp cRDATE = rs.getTimestamp("cRDATE");
				dto = new CustomerDto(cid, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cBIRTH, cGENDER, cRDATE);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null) 	rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) 	conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return dto;
	}
	// 5. 정보수정 : 
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET cPW=?," + 
				"                  cNAME=?," + 
				"                  cTEL=?," +
				"                  cEMAIL=?," + 
				"                  cADDRESS=?, " + 
				"                  cBIRTH=?," + 
				"                  cGENDER=?" + 
				"            WHERE cID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setDate(6, dto.getCbirth());
			pstmt.setString(7, dto.getCgender());
			pstmt.setString(8, dto.getCid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원수정성공" : "회원수정실패(cid : "+dto.getCid()+" 없음)");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원수정 실패 : " + dto);
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} 
		return result;
	}
}
