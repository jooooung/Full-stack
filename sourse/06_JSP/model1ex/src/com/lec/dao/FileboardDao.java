package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.FileboardDto;

public class FileboardDao {
	public  static final int SUCCESS = 1;
	public static final int FAIL = 0;
	// 싱글톤
	private static FileboardDao instance;
	public static FileboardDao getInstance() {
		if(instance == null) {
			instance = new FileboardDao();
		}
		return instance;
	}
	private FileboardDao() {}
	// 커넥션 풀
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 1. 글목록
	public ArrayList<FileboardDto> fileboardList(int startRow, int endRow){
		ArrayList<FileboardDto> fileboards = new ArrayList<FileboardDto>();
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		String sql = "SELECT *" + 
				"    FROM(SELECT ROWNUM RN, A.*" + 
				"            FROM (SELECT F.*, CNAME, CEMAIL" + 
				"                    FROM CUSTOMER C, FILEBOARD F" + 
				"                    WHERE C.cID=F.cID" + 
				"                    ORDER BY fREF DESC, fRE_STEP)A )" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fnum = rs.getInt("fnum");
				String cid = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				String fpw = rs.getString("fpw");
				int fhit = rs.getInt("fhit");
				int fref = rs.getInt("fref");
				int fre_step = rs.getInt("fre_step");
				int fre_level = rs.getInt("fre_level");
				String fip = rs.getString("fip");
				Date frdate = rs.getDate("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				fileboards.add(new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, 
								fhit, fref, fre_step, fre_level, fip, frdate, cname, cemail));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs 	 != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return fileboards;
	}
	// 2. 글개수
	public int getFileboardCnt() {
		int totalCnt = 0;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs 	 != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	}
	// 3. 원글쓰기
	public int insertFileboard(FileboardDto dto) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)" + 
				"    VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFhit());
			pstmt.setString(7, dto.getFip());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 4. 답글 쓰기 전 step
	public void preReplyStep(int ref, int re_step) {
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 "
				+ 	 "WHERE fREF = ? AND fRE_STEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 5. 답변글 쓰기
	public int reply(FileboardDto dto) {
		preReplyStep(dto.getFref(), dto.getFre_step());
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)" + 
				"    VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFhit());
			pstmt.setInt(7, dto.getFref());
			pstmt.setInt(8, dto.getFre_step() + 1);
			pstmt.setInt(9, dto.getFre_level() + 1);
			pstmt.setString(10, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS? "답글쓰기성공" : "답글쓰기 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 6. hit 올리기
	public void hitUp(int fnum) {
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fHIT=fHIT+1 WHERE fNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 7. 글상세보기
	public FileboardDto getBoardOneLine(int fnum) {
		FileboardDto dto = null;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		String sql = "SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID AND fNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				fnum = rs.getInt("fnum");
				String cid = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				String fpw = rs.getString("fpw");
				int fhit = rs.getInt("fhit");
				int fref = rs.getInt("fref");
				int fre_step = rs.getInt("fre_step");
				int fre_level = rs.getInt("fre_level");
				String fip = rs.getString("fip");
				Date frdate = rs.getDate("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				dto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, 
								fhit, fref, fre_step, fre_level, fip, frdate, cname, cemail);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs 	 != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 8. 글수정
	public int updateFileboard(FileboardDto dto) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSUBJECT = ?, " + 
				"                    fCONTENT = ?, " + 
				"                    fFILENAME = ?, " + 
				"                    fPW = ?, " + 
				"                    fIP = ? " + 
				"                WHERE fNUM= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글수정 성공" : "해당 글번호가 없어서 글 수정 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 9. 글삭제
	public int deleteFileboard(int fnum, String fpw) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FNUM = ? AND fPW = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글삭제 성공" : "글삭제 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
