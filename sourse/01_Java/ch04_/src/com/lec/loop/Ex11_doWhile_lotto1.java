package com.lec.loop;

import java.util.Scanner;

//컴퓨터가 발생하는 로또 난수 맞추기
public class Ex11_doWhile_lotto1 {   
	public static void main(String[] args) {
		int lotto, su;  //컴퓨터 로또 번호와 사용자로부터 입력받은 수
		Scanner sc = new Scanner(System.in);
		//0 <= Math.random()*45 < 45    : 0~45의 실수 중 랜덤한 수를 출력
		//1 <= Math.random()*45+1 < 46       :실수
		//1 <=(int)(Math.random()*45+1) < 46    :정수
		//System.out.println((int)(Math.random()*45+1));
		lotto = (int)(Math.random()*45+1);   //로또번호
		do {
			System.out.print("로또 번호 한 개를 맞춰보세요(1~45) : ");
			su = sc.nextInt();       //로또 번호를 맞추는 입력칸
			if(su>lotto) {           
				System.out.println("입력한 수보다 작습니다");
			} else if(su<lotto) {
				System.out.println("입력한 수보다 큽니다");
			}
		}while(su != lotto);     //su 가 lotto 와 다르면 다시 하여라
		System.out.println("맞추혔습니다");
		sc.close();
	}
}
