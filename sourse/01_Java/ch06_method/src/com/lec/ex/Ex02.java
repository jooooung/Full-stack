package com.lec.ex;
//1~10까지 정수의 합, 결과가 짝수인지 홀수인지 출력
public class Ex02 {
	private static int sum(int from, int to) {
		int sum = 0; //누적할 변수
		for(int i=from ; i<=to ; i++) {
			sum+=i;
		}
		return sum;
	}
	private static String evenOdd(int total) {
		String result = total%2==0 ? "짝수입니다" : "홀수입니다";
		return result;
	}
	public static void main(String[] args) {
		int total = sum(1, 10);
		System.out.println("1~10까지 정수의 합은" + total);
		System.out.println(evenOdd(total));
		//-----------------------------------------------------
		total = sum(10, 100);
		System.out.println("10~100까지 정수의 합은" + total);
		System.out.println(evenOdd(total));
	}
}

/*
4-private static int sum(int from, int to) : private(내 파일 내에서만 쓸 수 있는) 
 											 sum을 만듬 (from, to 매개변수 생성)

9-return sum;  :  sum 을 호출한 곳으로 가라는 뜻  

11-private static String evenOdd(int total) : evenOdd 만든후 String으로 출력

*/