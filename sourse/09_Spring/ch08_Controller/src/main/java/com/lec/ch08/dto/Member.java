package com.lec.ch08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String id;
	private String pw;
	@Override	// override 맞는지 확인하기 위해(생략가능)
	public String toString() {
		return "Member id : "+id+", pw : " + pw;
	}
}
