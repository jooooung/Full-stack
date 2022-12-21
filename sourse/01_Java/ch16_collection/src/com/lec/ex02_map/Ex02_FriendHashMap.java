package com.lec.ex02_map;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.lec.ex01_list.Friend;

public class Ex02_FriendHashMap {

	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<>();
		
		friends.put("010-1111-1111", new Friend("김길동", "010-1111-1111"));
		friends.put("010-2222-2222", new Friend("김길동", "010-2222-2222"));
		friends.put("010-3333-3333", new Friend("김길동", "010-3333-3333"));
		friends.put("010-4444-4444", new Friend("김길동", "010-4444-4444"));
		friends.put("010-5555-5555", new Friend("김길동", "010-5555-5555"));
		
		Iterator<String> iterator = friends.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println(key + ": " + friends.get(key));
		}
		
//		friends.add(new Friend("김길동", "010-1111-1111"));
//		friends.add(
//				new Friend("이길동", "010-2222-2222", new Date(new GregorianCalendar(2002, 02, 02).getTimeInMillis())));
//		friends.add(
//				new Friend("삼길동", "010-3333-3333", new Date(new GregorianCalendar(2003, 03, 03).getTimeInMillis())));
//		friends.add(new Friend("사길동", "010-4444-4444"));
//		friends.add(new Friend("오길동", "010-5555-5555"));
//		friends.add(new Friend("육길동", "010-6666-6666"));
//
//		for (int i = 0; i < friends.size(); i++) {
//			System.out.println(friends.get(i));
//		}
//		for (Friend friend : friends) {
//			System.out.println(friend.getTel());
//		}

	}

}
