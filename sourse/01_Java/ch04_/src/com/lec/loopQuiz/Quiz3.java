package com.lec.loopQuiz;
//사용자로부터 원하는 구구단수를 입력받아 해당 구구단을 출력해 보자 (수업 시간에는 5단으로)
import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 구구단수를 입력해 주세요 : ");
		int su = sc.nextInt(); 
		for(int i=1 ; i<=9 ; i++) {
			System.out.println(su+"*"+i+"="+(su*i));
		}
		sc.close();
	}
}
