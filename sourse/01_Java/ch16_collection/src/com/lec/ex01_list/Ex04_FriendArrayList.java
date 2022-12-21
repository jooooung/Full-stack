package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex04_FriendArrayList {

	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("김길동", "010-1111-1111"));
		friends.add(
				new Friend("이길동", "010-2222-2222", new Date(new GregorianCalendar(2002, 02, 02).getTimeInMillis())));
		friends.add(
				new Friend("삼길동", "010-3333-3333", new Date(new GregorianCalendar(2003, 03, 03).getTimeInMillis())));
		friends.add(new Friend("사길동", "010-4444-4444"));
		friends.add(new Friend("오길동", "010-5555-5555"));
		friends.add(new Friend("육길동", "010-6666-6666"));

		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}
//		* 전화번호만 출력
//		for (int i = 0; i < friends.size(); i++) {
//			System.out.println(friends.get(i).getTel());
//		}
		for (Friend friend : friends) {
			System.out.println(friend.getTel());
		}

	}

}
