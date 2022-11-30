package com.lec.ConditionQuiz;
//컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 
//가위(0) 바위(1) 보(2)
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u, com;
		com = (int) (Math.random() * 3);
		System.out.print("가위(0), 바위(1), 보(2) 중 하나를 내세요");
		u = sc.nextInt();
		if (u == 0) {
			System.out.println("가위를 냈습니다");
		} else if (u == 1) {
			System.out.println("바위를 냈습니다");
		} else if (u == 2) {
			System.out.println("보를 냈습니다");
		} else {
			System.out.println("잘못 냈습니다");
			u = 3;
		}
		if (u != 3) {
			if (com == 0) {
				System.out.println("컴퓨터는 가위");
			}
		} else if (com == 1) {
			System.out.println("컴퓨터는 바위");
		} else if (com == 0) {
			System.out.println("컴퓨터는 보");
		}
		if(u == 0) {
			if(com == 0) {
				System.out.println("비겼습니다");
			}else if(com == 1) {
				System.out.println("컴퓨터가 이겼습니다");
			}else {
				System.out.println("이겼습니다");
			}
		}
		if(u == 1) {
			if(com == 0) {
				System.out.println("이겼습니다");
			}else if(com == 1) {
				System.out.println("비겼습니다");
			}else {
				System.out.println("컴퓨터가 이겼습니다");
			}
		}
		if(u == 2) {
			if(com == 0) {
				System.out.println("컴퓨터가 이겼습니다");
			}else if(com == 1) {
				System.out.println("이겼습니다");
			}else {
				System.out.println("비겼습니다");
			}
		}
		sc.close();
	}//main
}//clase
