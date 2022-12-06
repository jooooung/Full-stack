package com.lec.ex3_accesstest;

public class AccessTest {
	private int privateMember; 	// 같은 클래스내에서만
	protected int protectedMember;	// 같은 패키지나 상속받은 클래스에서 사용
	int defaultMember; 	//디폴트접근제한 : 같은 패키지에서만
	public int publicMember;  //아무데서나 사용
	private void privateMethod() {
		System.out.println("private 메소드");
	}
	void protectedMethod() {
		System.out.println("protected 메소드");
	}
	void defaultMethod() {
		System.out.println("default 메소드");
	}
	public void publictMethod() {
		System.out.println("public 메소드");
	}
}
