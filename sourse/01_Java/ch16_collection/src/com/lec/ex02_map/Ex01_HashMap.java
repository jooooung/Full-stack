package com.lec.ex02_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("aaa"); // 중복된 데이터 add 가능
		System.out.println(list.get(0)); // index가 key

		HashMap<Integer, String> hashMap = new HashMap</* Integer, String */>();
		hashMap.put(10, "str10");
		hashMap.put(11, "str10"); // 중복된 데이터 가능, key는 유일해야 한다
		hashMap.put(12, "str12"); // 중복된 데이터 가능, key는 유일해야 한다
		hashMap.put(13, "str13"); // 중복된 데이터 가능, key는 유일해야 한다

		System.out.println(hashMap.get(10));
		System.out.println(hashMap); // 순서 X

		hashMap.remove(10); // remove는 key값으로만 이용
		System.out.println(hashMap); // remove 후 hashMap
		hashMap.clear(); // 모든 데이터 제거
		System.out.println(hashMap.isEmpty() ? "데이터 없음" : "데이터 있음");

		// 출력
		hashMap.put(0, "김길동");
		hashMap.put(10, "일길동");
		hashMap.put(20, "이길동");
		hashMap.put(30, "삼길동");
		hashMap.put(40, "사길동");

		Iterator<Integer> iterator = hashMap.keySet().iterator(); // 반복자
		while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			System.out.println(key + "의 데이터는 " + hashMap.get(key));

		}

	}

}
