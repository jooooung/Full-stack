package com.lec.ex2_date;

public class QuizSawon2Main {

	public static void main(String[] args) {
		QuizSawon2[] sawons = { new QuizSawon2("a01", "홍길동", Dept.COMPUTER),
						   new QuizSawon2("a02", "박길동", Dept.DESIGN, 2022, 7, 12),
						   new QuizSawon2("b01", "이길동", Dept.PLANNING, 2022, 10, 15)};
		for(int i=0 ; i<sawons.length ; i++) {
			System.out.println(sawons[i]);
		}
		System.out.println();
		for(QuizSawon2 sa : sawons) {
			System.out.println(sa);
		}
	}
}
