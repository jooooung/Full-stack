//입력한 값을 팩토리얼로 출력하기
// s! = s * (s-1) * (s-2) ... * 2 * 1 
// 1! = 1 (factorial 계산은 양수만 입력하는 것으로 한다)
package com.lec.ex;

import java.util.Scanner;

public class Ex05_factorial {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇!을 계산할까요? ");
		int num = scanner.nextInt();
		long result = factorial(num);				//결과값이 크기때문에 int가 아닌 long 사용
		System.out.println(num + "! =" + result);
	}
	private static long factorial(int s) {
		long result = 1; // 누적 곱이기 때문에 1
		for(int i=s ; i>=1 ; i--) {
			result *= i; 
		}
		return result;
	}
}

// 양수가 아닌 수를 입력하면 오류