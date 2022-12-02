package com.lec.ex;
//1~10까지 정수의 합, 결과가 짝수인지 홀수인지 출력
public class Ex01 {
	public static void main(String[] args) {
		int total = 0;
		for(int i=0 ; i<=10 ; i++) {
			total += i;
		}
		System.out.println("1~10까지 정수의 합은" + total);
		System.out.println(total%2==0 ? "짝수입니다" : "홀수입니다");
		//-----------------------------------------------------
		total = 0;
		for(int i=10 ; i<=100 ; i++) {
			total += i;
		}
		System.out.println("10~100까지 정수의 합은" + total);
		System.out.println(total%2==0 ? "짝수입니다" : "홀수입니다");
	}
}
