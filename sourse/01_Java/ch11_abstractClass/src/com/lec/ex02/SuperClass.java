//추상메소드가 하나라도 있으면 반드시 추상클래스여야 한다
//method1(추상), method2(일반), method3(일반)
package com.lec.ex02;

public abstract class SuperClass {
	public abstract void method1();
	
	public void method2() {
		System.out.println("SuperClass의 method2");
	}
	public void method3() {
		System.out.println("SuperClass의 method3");
	}
}
