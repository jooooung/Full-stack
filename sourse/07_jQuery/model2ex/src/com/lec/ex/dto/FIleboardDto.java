package com.lec.ex.dto;

import java.sql.Date;

public class FIleboardDto {
	private int fid;
	private String mid;
	private String mname;
	private String ftitle;
	private String fcontent;
	private String ffilename;
	private Date frdate;
	private int fhit;
	private int fgroup;
	private int fstep;
	private int findent;
	private String fip;
	public FIleboardDto() {
		super();
	}
	public FIleboardDto(int fid, String mid, String mname, String ftitle, String fcontent, String ffilename,
			Date frdate, int fhit, int fgroup, int fstep, int findent, String fip) {
		super();
		this.fid = fid;
		this.mid = mid;
		this.mname = mname;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.frdate = frdate;
		this.fhit = fhit;
		this.fgroup = fgroup;
		this.fstep = fstep;
		this.findent = findent;
		this.fip = fip;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFfilename() {
		return ffilename;
	}
	public void setFfilename(String ffilename) {
		this.ffilename = ffilename;
	}
	public Date getFrdate() {
		return frdate;
	}
	public void setFrdate(Date frdate) {
		this.frdate = frdate;
	}
	public int getFhit() {
		return fhit;
	}
	public void setFhit(int fhit) {
		this.fhit = fhit;
	}
	public int getFgroup() {
		return fgroup;
	}
	public void setFgroup(int fgroup) {
		this.fgroup = fgroup;
	}
	public int getFstep() {
		return fstep;
	}
	public void setFstep(int fstep) {
		this.fstep = fstep;
	}
	public int getFindent() {
		return findent;
	}
	public void setFindent(int findent) {
		this.findent = findent;
	}
	public String getFip() {
		return fip;
	}
	public void setFip(String fip) {
		this.fip = fip;
	}
	@Override
	public String toString() {
		return "FIleboardDto [fid=" + fid + ", mid=" + mid + ", mname=" + mname + ", ftitle=" + ftitle + ", fcontent="
				+ fcontent + ", ffilename=" + ffilename + ", frdate=" + frdate + ", fhit=" + fhit + ", fgroup=" + fgroup
				+ ", fstep=" + fstep + ", findent=" + findent + ", fip=" + fip + "]";
	}
}
