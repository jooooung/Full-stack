package com.lec.quiz;

import java.util.Scanner;

//두수를 입력받아 
//두 수가 같은지 결과를 O나 X로 출력.
//첫번째 수가 더 큰지 결과를 O나 X로 출력한다.

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
		int num2 = sc.nextInt();
		System.out.println("두 수가 같은지 결과는 "+((num1==num2)?"O":"X"));
		System.out.println("첫번째 수가 더 큰지 결과는 "+((num1>=num2)?"O":"X"));
		sc.close();
	}
}
