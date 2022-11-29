package com.lec.ex;
//산술연산자  + - * / %(나머지연산자)
public class Ex01 {
	public static void main(String[] args) {
		int n1=99, n2=10;
		int result; double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n'", n1, '+', n2, result);
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n'", n1, '/', n2, result);  //몫 구하기
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n'", n1, '%', n2, result);  //나머지 구하기
		//나머지 연산자의 용도 : 짝호수 판별, 배수 판별...
		if (n1%2 == 0) {
			System.out.println("n1은 짝수");
		}else {
			System.out.println("n1은 홀수");           //n1%2 == 0  n1%숫자   숫자에 3이 들어가면 3의배수
		}
	}
}
