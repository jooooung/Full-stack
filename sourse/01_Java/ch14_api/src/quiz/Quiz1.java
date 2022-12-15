package quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int u, com;
		final int SCISSOR = 0;
		final int ROCK = 1;
		final int PAPER = 2;
		final int NOTHING = 3;

		do {
			com = random.nextInt(3);
			System.out.println("가위, 바위, 보 중 하나를 입력하세요(사용자가 이기면 종료)");
			String uStr = sc.next().trim();
			if (uStr.equals("가위")) {
				u = SCISSOR;
			} else if (uStr.equals("바위")) {
				u = ROCK;
			} else if (uStr.equals("보")) {
				u = PAPER;
			} else {
				u = NOTHING;
				continue;
			}
			if ((u + 2) % 3 == com) {
				printResult(u, com);
				System.out.println("이겼습니다");
			} else if (u == com) {
				printResult(u, com);
				System.out.println("비겼습니다");
			} else {
				printResult(u, com);
				System.out.println("졌습니다");
			}

		} while (u==NOTHING || (u + 2) % 3 != com);
		System.out.println("끝");
		sc.close();
	}

	private static void printResult(int u, int com) {
		System.out.println("사용자 : " + ((u == 0) ? "가위" : (u == 1) ? "바위" : "보"));
		System.out.println("컴퓨터 : " + ((com == 0) ? "가위" : (com == 1) ? "바위" : "보"));
	}
}

//trim() space 없애는 메소드