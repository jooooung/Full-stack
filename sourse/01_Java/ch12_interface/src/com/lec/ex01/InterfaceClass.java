//implements interface파일명 - class 파일에 interface 파일 물려받기
//CONSTANT_NUM, CONSTANT_STRING, method1(). method2()
package com.lec.ex01;

public class InterfaceClass implements InterfaceEx1, InterfaceEx2{

	@Override
	public String method2() {
		System.out.println("실주 구현은 implements한 클래스에서 함 - method2");
		return null;
	}

	@Override
	public void method1() {
		System.out.println("실제 구현은 implements한 클래스에서 함 - method1");
	}
}	
