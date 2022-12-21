package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

public class Ex04_FriendArraySerchTell {

	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("김길동", "010-1111-1111"));
		friends.add(new Friend("이길동", "010-2222-2222"));
		friends.add(new Friend("삼길동", "010-3333-3333"));
		friends.add(new Friend("사길동", "010-4444-4444"));
		friends.add(new Friend("오길동", "010-5555-5555"));
		friends.add(new Friend("육길동", "010-6666-6666"));

		Scanner sc = new Scanner(System.in);
		while (true) {
			boolean searchOk = false;
			System.out.print("검색할 전화번호 뒷자리를 입력하세요(종료: x) ");
			String searchTel = sc.next();
			if (searchTel.equals("x")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} // if
			
			for (Friend friend : friends) {
				String tel = friend.getTel();
				String postTel = tel.substring(tel.lastIndexOf("-") + 1);

				if (searchTel.equals(postTel)) {
					System.out.println(friend);
					searchOk = false;
				}
			} // for
			
			if (!searchOk) {
				System.out.println("검색하신 전화번호 뒷자리는 없습니다.");
			}
			
		} // while
	} // main

} // class
