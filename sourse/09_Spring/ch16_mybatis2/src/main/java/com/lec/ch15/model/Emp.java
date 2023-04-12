package com.lec.ch15.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	private int    empno;
	private String ename;
	private String job;
	private String mgr;		// 수정이나 등록 시 빈스트링 입력 가능하도록 String으로 변경
	private Date   hiredate;
	private int    sal;
	private String comm;	// 수정이나 등록 시 빈스트링 입력 가능하도록 String으로 변경
	private int    deptno;	// emp
	private String dname;
	private String loc;		// dept
	private int    startRow;
	private int    endRow;	// paging
}
