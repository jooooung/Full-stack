package com.lec.ex01_list;

import java.util.ArrayList;

public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";

		ArrayList<String> arrayList = new ArrayList<String>();
		System.out.println("현재 arrayList의 사이즈는: " + arrayList.size());

		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 1번 인덱스 -> 2번 인덱스
		arrayList.add("str2"); // 2번 인덱스

		arrayList.add(1, "1111"); // 1번 인덱스
		System.out.println("현재 arrayList의 사이즈는: " + arrayList.size());
		System.out.println(arrayList);
		arrayList.set(1, "-----"); // 1번 인덱스 값을 수정
		for (String temp : arrayList) {
			System.out.println(temp + "\t");
		}
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(i + "번째 인덱스 값 " + arrayList.get(i));
		}
		arrayList.remove(1); // 1번 인덱스를 제거 (2->1, 2->1, 1->0 인덱)
		arrayList.remove(arrayList.size() - 1); // 맨 마지막 인덱스를 제거
		System.out.println("첫번째 인덱스와 마지막 인덱스 제거 후 arrayList의 사이즈는: " + arrayList.size());
		arrayList.clear(); // arrayList의 모든 데이터 제거
		System.out.println(arrayList.isEmpty() ? "arrayList 사이즈가 0이다." : "arrayList 사이즈가 0이 아니다.");
	}

}