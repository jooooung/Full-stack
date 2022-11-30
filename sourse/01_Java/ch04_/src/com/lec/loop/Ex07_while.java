package com.lec.loop;

public class Ex07_while {
	public static void main(String[] args) {
		int i=10;
		while(i>0) {    //i가 0보다 클 때
			System.out.println(i+".");    //i + . 을 출력하라
			i--;      //무한 루프 방지
		}
		
//		for(int i=10; i>0 ; i--) {
//			System.out.println(i+".");
//		}
	}
}
