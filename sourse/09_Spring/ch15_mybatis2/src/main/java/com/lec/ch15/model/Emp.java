package com.lec.ch15.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	private int    empno;
	private String ename;
	private String job;
	private int    mgr;
	private Date   hiredate;
	private int    sal;
	private int    comm;
	private int    deptno;	// emp
	private String dname;
	private String loc;		// dept
	private int    startRow;
	private int    endRow;	// paging
}
