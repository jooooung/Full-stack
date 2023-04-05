package com.lec.ch06.ex2;

import lombok.Data;

@Data
public class Worker2 {
	private String name;
	private int age;
	private String job;
	
	// 호출될 핵심기능(joinPoint=비즈니스로직, 타겟메소드)
	public void getWorkerInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("직책 : " + job);
	}
}
