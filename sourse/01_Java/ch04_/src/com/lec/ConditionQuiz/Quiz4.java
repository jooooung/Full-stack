package com.lec.ConditionQuiz;
//컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 
//단, 사용자는 가위를 내고자 할 때는 0을 입력하고 
//바위를 선택하고자 할 때는 1을 입력하고,보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int u = sc.nextInt();
		System.out.print("가위(0), 바위(1), 보(2) 중 하나를 내세요");
		switch(u*1){
		case 0:
			System.out.println("당신은 가위");break;
		case 1:
			System.out.println("당신은 바위");break;
		case 2:
			System.out.println("당신은 보");break;
		default:
			System.out.println("유효하지 않은 입력값입니다");
	}
	sc.close();
	}
}

