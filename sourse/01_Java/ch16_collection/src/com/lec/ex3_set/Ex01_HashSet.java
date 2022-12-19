package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2");
		System.out.println(hashset);
		System.out.println("hashset 데이터 개수 : " + hashset.size());
		hashset.add("str2");
		System.out.println("중복 데이터 입력 후 : " + hashset);
		System.out.println("중복 데이터 입력 후 hashset 데이터 개수 : " + hashset.size()); // 중복 데이터를 add 하면 넣지 않는다
		Iterator<String> iterator = hashset.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());      //개행하며 출력하기
		}
		
	}
}
