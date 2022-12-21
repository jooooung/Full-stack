package com.lec.quiz02;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "서울시 용산구", "010-9999-1234",
				new Date(new GregorianCalendar(1995, 04, 22).getTimeInMillis())));
		friends.add(new Friend("신길동", "서울시 마포구", "010-9999-9999",
				new Date(new GregorianCalendar(1995, 03, 05).getTimeInMillis())));
		Scanner scanner = new Scanner(System.in);

		while (true) {
			boolean searchOk = false;
			System.out.print("검색할 주소 앞 글자 2자리 (단, 종료를 원하시면 x를 입력하세오): ");
			String search = scanner.next();
			System.out.println();
			// 프로그램 종료
			if (search.equalsIgnoreCase("x")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			for (Friend friend : friends) {
				int i = friend.getAddress().indexOf(search);
				if (i > -1) {
					System.out.println(friend);
					searchOk = true;
				}
			}
				if (searchOk == false) {
					System.out.println("해당 지역의 친구는 없습니다.\n");
			}
		} // while
	} // main

} // class
