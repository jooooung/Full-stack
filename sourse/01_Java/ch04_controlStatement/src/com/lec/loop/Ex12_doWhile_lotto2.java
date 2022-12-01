package com.lec.loop;

import java.util.Scanner;

//컴퓨터가 발생하는 로또 난수 맞추기
public class Ex12_doWhile_lotto2 {   
	public static void main(String[] args) {
		int lotto, su;  //컴퓨터 로또 번호와 사용자로부터 입력받은 수
		int min=1, max=45;   //최솟값 최대값 
		Scanner sc = new Scanner(System.in);
		lotto = (int)(Math.random()*45+1);   //로또번호
		do {
			System.out.printf("로또 번호 한 개를 맞춰보세요(%d~%d) : ", min, max);
			su = sc.nextInt();       //로또 번호를 맞추는 입력칸
			if(su < min || su>max) {
				System.out.println("주어진 범위를 참조하세요");         //범위 밖의 수를 입력 시
			}else if(su>lotto) {           
				max = su-1;                //입력한 값의 1 작은 수의 범위 알려주기
				//System.out.println("입력한 수보다 작습니다");
			} else if(su<lotto) {
				min = su+1;      //입력한 값의 1 큰 수의 범위 알려주기
				System.out.println("입력한 수보다 큽니다");
			}
		}while(su != lotto);                //su 가 lotto 와 다르면 다시 하여라
		System.out.println("맞추혔습니다");
		sc.close();
	}
}

// || : 또는
