package com.lec.ex03_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex01_list.Friend;

public class Ex03_InteratorEx {
	public static void main(String[] args) {
		int[] iArr = new int[5];
		// 1. list 계열
		ArrayList<String> list = new ArrayList<>();
		list.add("SAMPLE");
		list.add("SAMPLE");
		Iterator<String> iterator = list.iterator();

		// while문을 이용한 출력
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// for문을 이용한 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// for each를 이용한 출력
		for (String string : list) {
			System.out.println(string);
		}

		// 2. Map 계열
		HashMap<String, Friend> map = new HashMap<>();
		map.put("김길동", new Friend("김길동", "010-1111-1111"));
		map.put("이길동", new Friend("이길동", "010-2222-2222"));
		map.put("삼길동", new Friend("삼길동", "010-3333-3333"));
		map.put("사길동", new Friend("사길동", "010-4444-4444"));

		Iterator<String> iterator2 = map.keySet().iterator();
		while (iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(map.get(key));
		}

		// 3. Set 계열
		HashSet<Friend> set = new HashSet<>();
		set.add(new Friend("김길동", "010-1111-1111"));
		set.add(new Friend("이길동", "010-2222-2222"));
		set.add(new Friend("삼길동", "010-3333-3333"));
		set.add(new Friend("사길동", "010-4444-4444"));

		Iterator<Friend> iterator3 = set.iterator();
		while (iterator3.hasNext()) {
//			Friend friend = (Friend) iterator3.next();
			System.out.println(iterator3.next());
		}

	}

}
