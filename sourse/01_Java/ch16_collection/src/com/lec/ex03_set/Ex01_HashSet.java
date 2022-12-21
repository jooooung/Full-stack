package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("str1");
		hashSet.add("str2");
		hashSet.add("str3");
		hashSet.add("str4");
		hashSet.add("str5");
		
		System.out.println(hashSet);
		System.out.println(hashSet.size()); // hashSet의 데이터 갯수 확인
		
		// 중복데이터 입력
		hashSet.add("str2"); // 오류가 나지는 않지만 추가되지 않음
		System.out.println(hashSet);
		System.out.println(hashSet.size()); // hashSet의 데이터 갯수 확인
	
		// 출력
		Iterator<String> iterator = hashSet.iterator(); // key가 없으니 hashSet을 Iterator
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
	}
	
}
