package com.lec.ch06.ex1;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	
	// 호출될 핵심기능(joinPoint=비즈니스로직, 타겟메소드)
	public void getStudentInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("학년 : " + gradeNum);
		System.out.println("반 : " + classNum);
	}
}
