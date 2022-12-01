package com.lec.loop;
//15 16 17 18 19
//20 21 22 23 24  ... 50까지 출력하기
public class Ex04_for {
	public static void main(String[] args) {
		for(int i=15 ; i<=50 ; i++) {
			System.out.print(i + "\t");
			if(i%5 == 4) {          //i를 5로 나눈 나머지가 4인 숫자마다 개행
				System.out.println();
			}
		}
	}
}
