package com.lec.ex3_supermarket;

public class CustomerDto {
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private int levelup;
	private int levelno;
	
	public CustomerDto() {}
	// 입력용
	public CustomerDto(String ctel, String cname) {
		this.ctel = ctel;
		this.cname = cname;
	}
	// 출력용
	public CustomerDto(int cid, String ctel, String cname, int cpoint, int camount, int levelup, int levelno) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelup = levelup;
		this.levelno = levelno;
	}
	
	@Override
	public String toString() {
		return cid + ctel + cname + cpoint + camount + levelup + levelno;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}

	public int getCamount() {
		return camount;
	}

	public void setCamount(int camount) {
		this.camount = camount;
	}

	public int getLevelup() {
		return levelup;
	}

	public void setLevelup(int levelup) {
		this.levelup = levelup;
	}

	public int getLevelno() {
		return levelno;
	}

	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}
}
