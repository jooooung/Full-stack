//i1, i2, i3, m1(), m2(), m3()       오버라이트 했기에 추상이 아닌 일반 메소드
package com.lec.ex05_testInterface;

public class TestClass implements I3 {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("상수 i1 = " + i1);
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("상수 i2 = " + i2);
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("상수 i3 = " + i3);
	}
}
