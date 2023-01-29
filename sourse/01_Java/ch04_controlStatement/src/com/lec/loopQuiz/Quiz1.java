package com.lec.loopQuiz;
//① 1~10까지의 곱을 구해보자
public class Quiz1 {
	public static void main(String[] args) {
		int tot = 1;
		for(int i=1 ; i<=10 ; i++)
			tot *= i;
		System.out.println("=" + tot); 
	}
}
