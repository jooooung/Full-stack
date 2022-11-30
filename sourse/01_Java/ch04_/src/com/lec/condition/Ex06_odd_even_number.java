package com.lec.condition;

import java.util.Scanner;

//입력받은 수가 홀수인지 짝수인지 출력
public class Ex06_odd_even_number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요");
		int num = sc.nextInt();
		switch (num%2) {                //num 에 2를 나누어 case 0 (0이면 짝수) default (0이 아니라면 홀수)
		case 0:
			System.out.println("짝수입니다");
			break;
		default:
			System.out.println("홀수입니다");
			break;
		}
		sc.close();
	}
}
