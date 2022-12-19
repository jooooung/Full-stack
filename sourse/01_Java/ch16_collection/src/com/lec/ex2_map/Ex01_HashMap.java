package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();   //ArrayList
		list.add("aaa");
		System.out.println(list.get(0));   //인덱스가 key
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();  // key 값 = Integer
		hashMap.put(11, "str11");   //key(11)은 유일한 값
		hashMap.put(12, "str11");
		hashMap.put(20, "str20");
		hashMap.put(33, "str33");
		System.out.println(11+ "key값의 데이터는 " + hashMap.get(11));
		System.out.println(hashMap);
		hashMap.remove(12);   //remove 사용시에는 key 값으로만 이용
		System.out.println("remove 후 : " + hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "데이터 모두 제거" : "데이터 있음");
		// 출력
		hashMap.put(0, "hong gilldong");
		hashMap.put(10, "kim dongil");
		hashMap.put(22, "Lee sonnsin");
		hashMap.put(40, "yu ain");
		Iterator<Integer> iterater = hashMap.keySet().iterator();    //반복자
		while(iterater.hasNext()) {
			Integer key = iterater.next();
			System.out.println(key + "의 데이터는" + hashMap.get(key));
		}
	}
}