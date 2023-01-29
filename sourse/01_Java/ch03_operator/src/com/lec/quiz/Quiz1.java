package com.lec.quiz;

import java.util.Scanner;

//3의 배수 숫자 판단하기 : 사용자로부터 숫자를 입력 받고, 입력 받은 숫자가 3의 배수인지 파악
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		String result = (num %3 ==0) ? "3의 배수이다":"3의 배수가 아니다";
		System.out.printf("입력하신 (%d)는 %s\n", num, result);
		sc.close();  
		
	}
}

