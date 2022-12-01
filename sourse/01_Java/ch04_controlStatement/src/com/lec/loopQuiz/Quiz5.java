package com.lec.loopQuiz;
//컴퓨터와 가위바위보 게임을 -1을 입력할때까지 무한반복하는 게임을 작성하시오.
//(단, 가위대신 0, 바위대신 1, 보대신 2, 종료를 원하면 -1을 입력합니다)
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u, com;
		while(true) {
			System.out.print("가위(0)바위(1)보(2)중 하나를 입력하세요(종료:-1) : ");
			u = sc.nextInt();
			if(u == -1)break;
			com = (int)(Math.random()*3);
			String comStr = (com==0) ? "가위" : (com==1)?"바위":"보자기"; 
			String uStr = (u==0) ? "가위" : (u==1)?"바위":"보자기"; 
			if(u<-1 || u>2) {
				System.out.println("잘못 입력했습니다");
			}else {
				if( (u+2)%3 == com ) {
					System.out.printf("당신은 %s, 컴퓨터는 %s. 당신이 이겼어요 ^.^\n", uStr, comStr);
				}else if((u+1)%3 == com){
					System.out.printf("당신은 %s, 컴퓨터는 %s. 컴퓨터가 이겼어요 ㅠ.ㅠ\n", uStr, comStr);
				}else {
					System.out.printf("당신은 %s, 컴퓨터는 %s. 비겼어요\n",  uStr, comStr);
				}	
			}
		}
		sc.close();
		System.out.println("end");
	}
}
