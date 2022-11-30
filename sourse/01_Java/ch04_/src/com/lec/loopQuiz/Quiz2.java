package com.lec.loopQuiz;
//1~10까지 숫자 중 짝수 또는 홀수의 합을 구해보자
public class Quiz2 {
	public static void main(String[] args) {
		int even = 0;
		int odd = 0;
		for(int i=1 ; i<=10 ; i++) {
			if(i%2==0) {
				even = even+i;
			}else {
				odd = odd+i;
			}
		}
		System.out.println("짝수의 합 = " + even);
		System.out.println("홀수의 합 = " + odd);
	}
}
