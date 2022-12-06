package com.lec.ex01_parentchild;

public class ParentClass {
	String pStr="부모클래스";
	public ParentClass() {
		System.out.println("부모클래스(=Parent클래스+Super클래스)");
	}
	public void getPapaName() {
		System.out.println("아빠이름 : 홍길동");
	}
	public void getMamiName() {
		System.out.println("엄마이름 : 김길순");
	}
}
