package com.lec.ConditionQuiz;
//가위바위보 중 하나를 내고 낸 것을 출력하세요(가위대신 0, 바위대신 1, 보대신 2를 입력)
import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2)중 하나를 선택하세요");
		int you = sc.nextInt(); 
		if(you == 0) {
			System.out.println("당신은 가위");
		}else if(you == 1) {
			System.out.println("당신은 바위");
		}else if(you == 2) {
			System.out.println("당신은 보");
		}else {
			System.out.println("유호하지 않은 값입니다");
		}
		sc.close();
	}
}
