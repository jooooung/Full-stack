package com.lec.exSec.dto;

import java.sql.Timestamp;

public class ExBoardDto {
	private int bnum;
	private String mid;
	private String btitle;
	private String bcontent;
	private String bphoto;
	private Timestamp bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	public ExBoardDto() {
		super();
	}
	public ExBoardDto(int bnum, String mid, String btitle, String bcontent, String bphoto, Timestamp bdate, int bhit,
			int bgroup, int bstep, int bindent, String bip) {
		super();
		this.bnum = bnum;
		this.mid = mid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bphoto = bphoto;
		this.bdate = bdate;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.bip = bip;
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
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBphoto() {
		return bphoto;
	}
	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}
	@Override
	public String toString() {
		return "ExBoardDto [bnum=" + bnum + ", mid=" + mid + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", bphoto=" + bphoto + ", bdate=" + bdate + ", bhit=" + bhit + ", bgroup=" + bgroup + ", bstep="
				+ bstep + ", bindent=" + bindent + ", bip=" + bip + "]";
	}
}
