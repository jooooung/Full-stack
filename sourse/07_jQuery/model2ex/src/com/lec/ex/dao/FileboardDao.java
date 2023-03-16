package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.FIleboardDto;

public class FileboardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	// 싱글톤
	private static FileboardDao instance = new FileboardDao();
	public static FileboardDao getinstance() {
		if(instance == null) {
			instance = new FileboardDao();
		}
		return instance;
	}
	public FileboardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1. 글목록(startRow, endRow)
	public ArrayList<FIleboardDto> fileboardList(int startRow, int endRow){
		ArrayList<FIleboardDto> dtos = new ArrayList<FIleboardDto>();
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * \r\n" + 
				"    FROM (SELECT ROWNUM RN, A.* " + 
				"        FROM (SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M" + 
				"                WHERE F.MID = M.MID" + 
				"                ORDER BY FGROUP DESC, FSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("fid");
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");;
				String fcontent = rs.getString("fcontent");;
				String ffilename = rs.getString("ffilename");;
				Date frdate = rs.getDate("frdate");;
				int fhit = rs.getInt("fhit");;
				int fgroup = rs.getInt("fgroup");;
				int fstep = rs.getInt("fstep");;
				int findent = rs.getInt("findent");;
				String fip = rs.getString("fip");;
				dtos.add(new FIleboardDto(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 2. 글개수
	public int filebaordCnt() {
		int cnt = 0;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return cnt;
	}
	// 3. 글쓰기 (원글)
	public int write(FIleboardDto dto) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP) VALUES" + 
				"    (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFip());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("글쓰기 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "글쓰기 실패");
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
	// 4. 조회수 올리기
	public void hitUp(int fid) {
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "조회수 올리기 실패");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 5. fid로 상세보기
	public FIleboardDto getFileboardOne(int fid) {
		FIleboardDto dto = null;
		hitUp(fid);
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M  " + 
				"    WHERE F.MID = M.MID AND FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");;
				String fcontent = rs.getString("fcontent");;
				String ffilename = rs.getString("ffilename");;
				Date frdate = rs.getDate("frdate");;
				int fhit = rs.getInt("fhit");;
				int fgroup = rs.getInt("fgroup");;
				int fstep = rs.getInt("fstep");;
				int findent = rs.getInt("findent");;
				String fip = rs.getString("fip");;
				dto = new FIleboardDto(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 5-2. 글수정 답글, 상세보기
	public FIleboardDto modyfyView_replyView(int fid) {
		FIleboardDto dto = null;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M  " + 
				"    WHERE F.MID = M.MID AND FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");;
				String fcontent = rs.getString("fcontent");;
				String ffilename = rs.getString("ffilename");;
				Date frdate = rs.getDate("frdate");;
				int fhit = rs.getInt("fhit");;
				int fgroup = rs.getInt("fgroup");;
				int fstep = rs.getInt("fstep");;
				int findent = rs.getInt("findent");;
				String fip = rs.getString("fip");;
				dto = new FIleboardDto(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 6. 글수정(fid, ftitle, fcontent, ffilename, frdate(SYSDATA), fip)
	public int modify(int fid, String ftitle, String fcontent, String ffilename, String fip) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD " + 
				"    SET FTITLE = ?," + 
				"        FCONTENT = ?," + 
				"        FFILENAME = ?," + 
				"        FIP = ?" + 
				"    WHERE FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ftitle);
			pstmt.setString(2, fcontent);
			pstmt.setString(3, ffilename);
			pstmt.setString(4, fip);
			pstmt.setInt(5, fid);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("글수정 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "글수정 실패");
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
	// 7. 글삭제
	public int delete(int fid){
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("글삭제 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "글삭제 실패");
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
	// 8. 답변글 쓰기 전 단계(원글의 FGROUP과 같고 FSTEP보다 크면 FSTEP을 하나 증가)
	private void preReplyStep(int fgroup, int fstep) {
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP + 1" + 
				"    WHERE FGROUP = ? AND FSTEP > ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
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
	// 9. 답변글 쓰기
	public int reply(String mid, String ftitle, String fcontent, String ffilename, int fgroup, int fstep, int findent, String fip) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP) VALUES" + 
				"    (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, ftitle);
			pstmt.setString(3, fcontent);
			pstmt.setString(4, ffilename);
			pstmt.setInt(5, fgroup);
			pstmt.setInt(6, fstep + 1);
			pstmt.setInt(7, findent + 1);
			pstmt.setString(8, fip);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("답변글쓰기 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "답변글쓰기 실패");
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
	// 10. 회원탈퇴시 탈퇴회원(mID) 글 삭제 
	public int WithdrawalDelete(String mid) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("탈퇴회원 글삭제 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "탈퇴회원 글삭제 실패");
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
