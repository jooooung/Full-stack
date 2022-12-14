//데이터 : 사번, 이름,
//부서(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), 입사일.
package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class QuizSawon {
	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING"; 
	public static final String DESIGN = "DESIGN";
	public static final String ACCOUNTING = "ACCOUNTING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";
	private String sawonNo;
	private String name;
	private String depart;
	private Date hireday;

	public QuizSawon(String sawonNo, String name, String depart) {
		this.sawonNo = sawonNo;
		this.name = name;
		this.depart = depart;
		hireday = new Date();
	}
	public QuizSawon(String sawonNo, String name, String depart, int y, int M, int d) {
		this.sawonNo = sawonNo;
		this.name = name;
		this.depart = depart;
		hireday = new Date(new GregorianCalendar(y, M-1, d).getTimeInMillis());
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MM, dd");
		return "[사번]" + sawonNo + "\t[이름]" + name + "\t[부서]" + depart + "\t[입사일]" + sdf.format(hireday);
	}

	public String getSawonNo() {
		return sawonNo;
	}

	public String getName() {
		return name;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public Date gethireday() {
		return hireday;
	}
	public void sethireday(Date hireday) {
		this.hireday = hireday;
	}
	public void setSawonNo(String sawonNo) {
		this.sawonNo = sawonNo;
	}
	public void setName(String name) {
		this.name = name;
	}
}