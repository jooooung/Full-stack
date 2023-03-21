package com.lec.exSec.dto;

import java.sql.Timestamp;

public class Bcomment {
	private int cnum;
	private int bnum;
	private String mid;
	private String ccontent;
	private Timestamp cdate;
	private String cip;
	public Bcomment() {
		super();
	}
	public Bcomment(int cnum, int bnum, String mid, String ccontent, Timestamp cdate, String cip) {
		super();
		this.cnum = cnum;
		this.bnum = bnum;
		this.mid = mid;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.cip = cip;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Timestamp getCdate() {
		return cdate;
	}
	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	@Override
	public String toString() {
		return "Bcomment [cnum=" + cnum + ", bnum=" + bnum + ", mid=" + mid + ", ccontent=" + ccontent + ", cdate="
				+ cdate + ", cip=" + cip + "]";
	}
}
