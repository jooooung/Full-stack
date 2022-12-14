package com.lec.ex2_date;

public class QuizSawonMain {

	public static void main(String[] args) {
		QuizSawon[] sawons = { new QuizSawon("a01", "홍길동", QuizSawon.COMPUTER),
						   new QuizSawon("a02", "박길동", QuizSawon.DESIGN, 2022, 7, 12),
						   new QuizSawon("b01", "이길동", QuizSawon.PLANNING, 2022, 10, 15)};
		for(int i=0 ; i<sawons.length ; i++) {
			System.out.println(sawons[i]);
		}
		System.out.println();
		for(QuizSawon sa : sawons) {
			System.out.println(sa);
		}
	}
}
