package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.dto.DeptDto;

public class DeptDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	
	private String uid		= "scott";
	private String upw		= "tiger";
	private static DeptDao INSTANCE;	// 기본값 : null
	public static DeptDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new DeptDao();
		}
		return INSTANCE;
	}
	private DeptDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<DeptDto> deptList(){
		ArrayList<DeptDto> dtos = new ArrayList<DeptDto>();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT * FROM DEPT";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getNString("dname");
				String loc = rs.getNString("loc");
				dtos.add(new DeptDto(deptno, dname, loc));
			}
//			while(rs.next()) {
//				DeptDto dto = new DeptDto();
//				dto.setDeptno(rs.getInt("deptno"));
//				dto.setDname(rs.getNString("dname"));
//				dto.setLoc(rs.getNString("loc"));
//				dtos.add(dto);
//			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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
}
