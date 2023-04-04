package com.lec.ch04.ex1;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class StudentInfo {
	@Autowired		// lombok을 안 쓸 시 setter 위에 위치
	private Student student;
}
