package com.lec.ex1_string;

public class Ex03_regex {
	public static void main(String[] args) {
		/* 정규표현식(regex)
		  1. 참조(https://goo.gl/Hlntbd 위키백과)
		  2. 간략문법
		  	\d : (숫자와 매치, [0-9]와 동일)
		  	\D : (숫자가 아닌 것)
		  	\w : (영문자나 숫자 , [A-Za-z][0-9]와 동일
		  	\W : (영문자나 숫자가 아닌 문자)
		  	.  : (문자)
		  	\. : .
		  {2,} : (2번 이상 반복)
		 {2,4} : (2~4회 반복)
		  	 + : (1번 이상 반복)
		  	 * : (0번 이상 반복)
		  	 ? : (0번이나 1번 반복)
		  3. 정규표현식 연습장(https://www.regexpal.com/)
		  	 ex1. ip주소 : 198.163.2.444
						([0-9]{1,3}\.){3}[0-9]{1,3} 
		  	 ex2. 전화번호 : 02 777 7777 / 010 3333 3333 / 010-7777-7777 / 010.5555.5555 / 02)131.5444 
		  	 			  \d{2,3}.?\d{3,4}.?\d{4}
		  	 ex3. 주민등록번호 : 981118-2033333 / 9812121044444
		  	 				\d{2}[0-1]\d[0-3]\d-?[1-4]\d{6}
		  	 ex4. 이메일 : abc@naver.com / wj@co.kr
		  	 			\w+@+\w+(\.\w+){1,2}
		  4. 소스구현
		 */
		String juminNo = "981118-2033333";
		// 특정 정규표현식의 문자열 변경
		System.out.println("주민번호 : " +juminNo.replaceAll("-[1-4][0-9]{6}", "-*******"));
		String str = "010-9999-9999 dhds@naver.com 반갑습니다. 981118-2033333 ㅋㅋ ㅎㅎ";
		System.out.println("이메일 지운 str : " + str.replaceAll("\\w+@+\\w+(\\.\\w+){1,2}", ""));
		System.out.println("전화번호 지운 str : " + str.replaceAll("\\d{2,3}.?\\d{3,4}.?\\d{4}", ""));
		System.out.println("자음 제거된 str : " + str.replaceAll("[ㄱ-ㅎ]", ""));
	}
}
