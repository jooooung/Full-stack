//<예제.주민번호를 입력받아 여자인지 남자인지 출력 예제> 주민번호는 “920225-2012121”형식으로 입력받는다.
package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_juminNoQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호(6자리-7자리) : ");
		String juminNo = scanner.next();
		int genderInt = Integer.parseInt(juminNo.substring(7,8));
		if (genderInt == 1 || genderInt == 3) {
			System.out.println("남성입니다");
		} else if (genderInt == 2 || genderInt == 4) {
			System.out.println("여성입니다");
		} else {
			System.out.println("유효하지 않은 주민번호입니다");
		}
	}
}
