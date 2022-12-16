package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_arrayList { // arrayList 크기가 정해져있지 않다  add한 만큼 늘어남
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		for (String arr : array) {
			System.out.println(arr);
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + "번 인덱스 값" + array[i]);
		}
		System.out.println("---------ArrayList-----------");
		ArrayList<String> arrayList = new ArrayList<String>(); // String ArrayList
		System.out.println("현재 arrayList사이즈는" + arrayList.size());
		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 1번 인덱스
		arrayList.add("str2"); // 2번 인덱스
		arrayList.add(1, "11111");   //1번 인덱스에 11111을 넣어라   1번 -> 2번, 2번-> 3번으로 밀린다
		System.out.println("현재 arrayList사이즈는" + arrayList.size());
		System.out.println(arrayList);
		arrayList.set(1, "----");     //1번 인덱스 값 수정
		arrayList.add("str4");
		for(String temp : arrayList) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		for(int i=0 ; i<arrayList.size() ; i++) {
			System.out.println(i + "번째 인덱스 값 : " + arrayList.get(i));
		}
		arrayList.remove(1); //1번 인덱스 제거     뒷 인덱스가 앞당겨진다
		arrayList.remove(arrayList.size()-1); //맨 마지막 인덱스 값 제거
		System.out.println("remove후 " + arrayList);
		arrayList.clear();  // arrayList의 모든 데이터 제거
		System.out.println(arrayList.isEmpty() ? "arrayList 사이즈가 0" : "arrayList 사이즈가 0이 아니다");
		arrayList = null;      //arrayList 자체를 제거
		System.out.println(arrayList);
	}
}
