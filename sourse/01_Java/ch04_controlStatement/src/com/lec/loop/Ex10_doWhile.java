package com.lec.loop;

import java.util.Scanner;

// 짝수를 입력받아 출력
public class Ex10_doWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.print("짝수를 입력하세요 : ");
			num = sc.nextInt();
		}while(num%2 != 0);       //홀수를 입력 시 다시 반복하도록
		System.out.println("입력한 짝수는 " + num);
		sc.close();
	}
}
