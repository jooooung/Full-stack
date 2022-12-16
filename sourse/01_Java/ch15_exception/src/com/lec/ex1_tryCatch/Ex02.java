package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1; // 사용자에게 입력받을 수를 저장할 변수
		System.out.print("첫번째 정수는? ");
		do {
			try {
				i = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("문자를 입력했습니다. 숫자를 입력해주세요");
				scanner.nextLine(); // 버퍼 지우는 용도
			}
		} while (true); // 문자를 입력하면 발생하는 예외 처리, 숫자를 입력할 때 까지 입력 받기
		System.out.print("두번째 정수는? ");
		try {
			j = scanner.nextInt();
			System.out.println("i / j = " + (i / j));
		} catch (InputMismatchException e) {
			System.out.println("두번째 정수를 잘못 입력하셔서 1로 처리합니다");
		} catch (Exception e) { // catch 가 여러개라면 Exception은 마지막에 사용(상위 클래스가 밑에)
			System.out.println(e.getMessage()); // 대부분 겟메세지 많이 사용
//			e.printStackTrace(); // 몇번째 줄에서 어떤 예외가 나타나는지 알려줌
		}
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i * j));
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}
