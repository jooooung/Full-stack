package com.lec.ex1_tryCatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j; // 사용자에게 입력받을 수를 저장할 변수
		System.out.print("첫번째 정수는? ");
		i = scanner.nextInt();
		System.out.print("두번째 정수는? ");
		j = scanner.nextInt();
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i * j));
		try {
			System.out.println("i / j = " + (i / j)); // 예외가 발생할 수도 있는 부분
		} catch (ArithmeticException e) { // 예외 발생 시 수행 부분, () 안에 예외 객체 변수 넣기 
			                              //(Exception으로 입력 가능(모든 예외는 Exception안에 있기 때문에))
			System.out.println(e.getMessage());      // 예외메세지 출력 (에러난 이유 뿌리기)
		}
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}
// 예외 처리  정수가 아닌 0으로 나누기를하면 예외객체 발생
//try catch를 이용하여 예외 처리하기
