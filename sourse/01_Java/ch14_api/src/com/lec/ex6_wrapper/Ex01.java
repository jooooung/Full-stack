package com.lec.ex6_wrapper;
// Wrapper 클래스 : Integer Double Long.... 기초데이터를 객체데이터로 변환한 클래스
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		Integer iObj = new Integer(10);  //자동 객체 생성
		int sum =i + iObj;  // i + iObj 
		System.out.println("합은 " + sum);
		System.out.println(iObj.equals(10));
	}
}
