package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S();	//생성자함수1개 실행
		S aObj = new A(); //= (A aObj = new A();)  생성자함수2개 실행
		S bObj = new B(); //= (B bObj = new B();)  생성자함수2개 실행
		S cObj = new C(); //= (C cObj = new C();)  생성자함수2개 실행
		System.out.println("aOby와bOby가 같냐" + aObj.equals(bObj));
		S[] arr = {sObj, aObj, bObj, cObj};
//		S[] arr = {new S(), new A(), new B(), new C()};
		for(S a :arr ) {    
			System.out.println("s = " + a.s);
		}
	}
}