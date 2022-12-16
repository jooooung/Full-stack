package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_linkedList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		LinkedList<String> link = new LinkedList<String>();
		link.add("str0");
		link.add("str1");
		link.add("str2");
		link.remove("str0");
		for (int i = 0; i < link.size(); i++) {
			System.out.println(i + " : " + link.get(i));
		}
		link.clear();
		if(link.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		} else {
			for (String temp : link) {
				System.out.println(temp);
			}//for
		}//else
	}//main
}
