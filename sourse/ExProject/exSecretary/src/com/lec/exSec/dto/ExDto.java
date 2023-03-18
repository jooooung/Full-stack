package com.lec.exSec.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ExDto {
	private int eday;
	private String mid;
	private int epno;
	private int eweight;
	private int eset;
	private int ecount;
	private Timestamp etime;
	private Date edate;
	public ExDto() {
		super();
	}
	public ExDto(int eday, String mid, int epno, int eweight, int eset, int ecount, Timestamp etime, Date edate) {
		super();
		this.eday = eday;
		this.mid = mid;
		this.epno = epno;
		this.eweight = eweight;
		this.eset = eset;
		this.ecount = ecount;
		this.etime = etime;
		this.edate = edate;
	}
	public int getEday() {
		return eday;
	}
	public void setEday(int eday) {
		this.eday = eday;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getEpno() {
		return epno;
	}
	public void setEpno(int epno) {
		this.epno = epno;
	}
	public int getEweight() {
		return eweight;
	}
	public void setEweight(int eweight) {
		this.eweight = eweight;
	}
	public int getEset() {
		return eset;
	}
	public void setEset(int eset) {
		this.eset = eset;
	}
	public int getEcount() {
		return ecount;
	}
	public void setEcount(int ecount) {
		this.ecount = ecount;
	}
	public Timestamp getEtime() {
		return etime;
	}
	public void setEtime(Timestamp etime) {
		this.etime = etime;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	@Override
	public String toString() {
		return "ExDto [eday=" + eday + ", mid=" + mid + ", epno=" + epno + ", eweight=" + eweight + ", eset=" + eset
				+ ", ecount=" + ecount + ", etime=" + etime + ", edate=" + edate + "]";
	}
}
