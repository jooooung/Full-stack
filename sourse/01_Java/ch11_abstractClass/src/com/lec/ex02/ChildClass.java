//method1(추상), method2(일반), method3(일반)
package com.lec.ex02;

public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의method1 - 추상메소드라서 오버라이드 함");
	}
	@Override
	public void method2() {
		System.out.println("ChildClass의method - 걍 오버라이드함");
	}
}
