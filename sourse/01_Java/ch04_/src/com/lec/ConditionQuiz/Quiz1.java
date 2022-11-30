package com.lec.ConditionQuiz;

import java.util.Scanner;

//수를 입력받아 절대값을 출력하는 프로그램
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요");
		int num = sc.nextInt();
		if(0>num) {
			System.out.println(-num);
		}
		sc.close();
	}
}
