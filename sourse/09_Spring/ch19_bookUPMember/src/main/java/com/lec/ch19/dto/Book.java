package com.lec.ch19.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Book {
	private int bnum;
	private String btitle;
	private String bwriter;
	private Date brdate;
	private String bimg1;
	private String bimg2;	
	
	private int startRow;
	private int endRow;
}
