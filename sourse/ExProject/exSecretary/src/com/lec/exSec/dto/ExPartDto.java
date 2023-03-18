package com.lec.exSec.dto;

public class ExPartDto {
	private int epno;
	private String eppart;
	private String ename;
	public ExPartDto() {
		super();
	}
	public ExPartDto(int epno, String eppart, String ename) {
		super();
		this.epno = epno;
		this.eppart = eppart;
		this.ename = ename;
	}
	public int getEpno() {
		return epno;
	}
	public void setEpno(int epno) {
		this.epno = epno;
	}
	public String getEppart() {
		return eppart;
	}
	public void setEppart(String eppart) {
		this.eppart = eppart;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "ExPartDto [epno=" + epno + ", eppart=" + eppart + ", ename=" + ename + "]";
	}
}
