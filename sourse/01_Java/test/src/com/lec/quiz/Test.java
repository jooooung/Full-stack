package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Friend> friends = new ArrayList<>();
		friends.add(new Friend("홍길동", "010-9999-1234", "서울시 용산구",
					new Date(new GregorianCalendar(0, 04, 22).getTimeInMillis())));
		friends.add(new Friend("신길동", "010-9999-9999", "서울시 마포구",
					new Date(new GregorianCalendar(0, 03, 05).getTimeInMillis())));

		while (true) {
			boolean searchOk = false;
			System.out.print("검색할 주소 앞 글자 2자리(단, 종료를 원하시면 x를 입력하시오) : ");
			String searchAdd = scanner.next();
			if (searchAdd.equalsIgnoreCase("x"))
				break;
			for (Friend friend : friends) {
				String address = friend.getAddress();
				String frontAddress = address.substring(0, 2);
				if (searchAdd.equals(frontAddress)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if (!searchOk) {
				System.out.println("해당 지역의 친구는 없습니다\n");
			}
		}
	}
}