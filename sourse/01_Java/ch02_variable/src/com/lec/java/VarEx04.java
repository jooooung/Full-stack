package com.lec.java;

public class VarEx04 {
	public static void main(String[] args) {
		// 변수 선언은 위치 제약 x, 위에 선언할 것을 추천
		char c = '씨';  //2byte
		int i = 20;   //4byte
		long l = 2200000000L; //L로 큰 수 인식  //8byte
		System.out.println("l = "+l);
		
		boolean b = true;  //1byte    //파이썬에선 True, 자바에선 true(t의 대소문자 차이)
		System.out.println("b ="+b);
		
		float f = 3.14159265359F;  //소수점이지만 float이라 인식해주기  //4byte
		double d = 3.14159265359;  //8byte
		System.out.println("f="+f);
		System.out.println("d="+d);
		if(f == d) {
			System.out.println("f와 d값은 같다");
		}else {
			System.out.println("f와 d값은 다르다");
		}
		
		f = 10.1F;
		d = 10.1;
		System.out.println("f="+f);
		System.out.println("d="+d);
		if(f == d) {
			System.out.println("f와 d값은 같다");
		}else {
			System.out.println("f와 d값은 다르다");     
			//눈에 보이기에는 10.1로 같지만 실제로는 다름, 따라서 다르다라고 출력됨
		}
		// 정수(4byte)랑 실수(8byte)랑 연산한 결과 : i+d(8byte)
		System.out.println("i + d =" +(i+d) );
		// 정수(4byte)랑 정수(4byte)랑 연산한 결과 : 4byte
		System.out.println("i / 7 =" +(i/7) );      //자바에서는 나누기 시 몫만 출력
	}
}
