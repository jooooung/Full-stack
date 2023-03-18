package com.lec.exSec.dto;

import java.sql.Date;

public class MemberDto {
	private String mid;
	private String mpw;
	private String mname;
	private String mphoto;
	private String mtel;
	private String memail;
	private String mgender;
	private Date mbirth;
	private String mwithd;
	public MemberDto() {
		super();
	}
	public MemberDto(String mid, String mpw, String mname, String mphoto, String mtel, String memail, String mgender,
			Date mbirth, String mwithd) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphoto = mphoto;
		this.mtel = mtel;
		this.memail = memail;
		this.mgender = mgender;
		this.mbirth = mbirth;
		this.mwithd = mwithd;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMphoto() {
		return mphoto;
	}
	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public Date getMbirth() {
		return mbirth;
	}
	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}
	public String getMwithd() {
		return mwithd;
	}
	public void setMwithd(String mwithd) {
		this.mwithd = mwithd;
	}
	@Override
	public String toString() {
		return "MemberDto [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphoto=" + mphoto + ", mtel=" + mtel
				+ ", memail=" + memail + ", mgender=" + mgender + ", mbirth=" + mbirth + ", mwithd=" + mwithd + "]";
	}
}
