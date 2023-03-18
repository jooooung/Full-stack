package com.lec.exSec.dto;

import java.sql.Date;

public class InbodyDto {
	private int inum;
	private String mid;
	private int iweight;
	private int ifat;
	private int imuscle;
	private Date idate;
	public InbodyDto() {
		super();
	}
	public InbodyDto(int inum, String mid, int iweight, int ifat, int imuscle, Date idate) {
		super();
		this.inum = inum;
		this.mid = mid;
		this.iweight = iweight;
		this.ifat = ifat;
		this.imuscle = imuscle;
		this.idate = idate;
	}
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getIweight() {
		return iweight;
	}
	public void setIweight(int iweight) {
		this.iweight = iweight;
	}
	public int getIfat() {
		return ifat;
	}
	public void setIfat(int ifat) {
		this.ifat = ifat;
	}
	public int getImuscle() {
		return imuscle;
	}
	public void setImuscle(int imuscle) {
		this.imuscle = imuscle;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	@Override
	public String toString() {
		return "InbodyDto [inum=" + inum + ", mid=" + mid + ", iweight=" + iweight + ", ifat=" + ifat + ", imuscle="
				+ imuscle + ", idate=" + idate + "]";
	}
}
