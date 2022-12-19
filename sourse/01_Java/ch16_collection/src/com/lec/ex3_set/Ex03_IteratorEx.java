package com.lec.ex3_set;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex03_IteratorEx {
	public static void main(String[] args) {
		// 1. list 계열
		ArrayList<String> list = new ArrayList<>();
		list.add("SAMPLE1");
		list.add("SAMPLE2");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "\t");
		}
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();
		for (String temp : list) {
			System.out.print(temp + "\t");
		}
		System.out.println("\n = = = 2. Map 계열 = = =");
		HashMap<String, Friend> map = new HashMap<>();
		map.put("홍길동", new Friend("홍길동", "010-9999-9999"));
		map.put("김길동", new Friend("김길동", "010-4444-5555", new Date(new GregorianCalendar(95, 0, 1).getTimeInMillis())));
		map.put("이길동", new Friend("이길동", "010-7777-6666"));
		Iterator<String> iterator2 = map.keySet().iterator();    //map은 key값을 통해서 get
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("\n = = = 3. Set 계열 = = =");
		HashSet<Friend> set = new HashSet<>();
		set.add(new Friend("홍길동", "010-9999-9999"));
		set.add(new Friend("김길동", "010-4444-5555"));
		set.add(new Friend("이길동", "010-7777-6666"));
		Iterator<Friend> iterator3 = set.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());   // set은 add한 순서대로 출력 x  똑같은 데이터를 넣어도 add 가능 
		}
	}
}
