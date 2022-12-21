package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


// add, get, size, isEmpty , remove
public class Ex02_linkedList {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("srt0");
		linkedList.add("srt1"); // -> 1 index
		linkedList.add("srt2"); // -> 2 index
		linkedList.add("srt3"); // -> 3 index
		linkedList.remove("str0");

		for (int i = 0; i < linkedList.size(); i++) {
			System.out.println(i + ": " + linkedList.get(i));
		}
		linkedList.clear();
		if (linkedList.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		} else {
			for (String temp : linkedList) {
				System.out.println(temp);
			}
		}
	}

}
