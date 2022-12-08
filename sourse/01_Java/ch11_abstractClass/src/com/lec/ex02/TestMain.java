package com.lec.ex02;

public class TestMain {

	public static void main(String[] args) {
		SuperClass obj = new ChildClass(); // SuperClass는 타입으로만 가능, 객체생성은 불가능
		obj.method1();
		obj.method2();
		obj.method3();
		SuperClass sObj = new SuperClass() {

			@Override
			public void method1() {
				System.out.println("익명클래스의method1");
			}
		}; // 이름없는 클래스 생성(주로 안드로이드에서 사용)
		sObj.method1();
		sObj.method2();
		sObj.method3();
	}// main
}// class
