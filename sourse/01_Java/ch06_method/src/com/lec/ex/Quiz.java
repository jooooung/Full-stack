//사용자로부터 원하는 단수(2~9) 구구단을 출력하는 프로그램을 구현하시오.
//(단, 단수를 매개변수로 받아 해당 단수의 구구단을 출력하는 부분을 method로 처리한다. 
//사용자가 2~9 사이의 수가 아닌 수를 입력할 시 2~9사이의 수를 입력할 때까지 계속 입력 받는다.)
package com.lec.ex;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.print("원하는 단 수를 입력하세요 : ");
			num = sc.nextInt();
		} while (num < 2 || num > 9);
		num2(num);
	}
	private static void num2(int a) {
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", a, i, a * i);
		}
	}
}
