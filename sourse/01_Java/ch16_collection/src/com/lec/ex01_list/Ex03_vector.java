package com.lec.ex01_list;

import java.util.Vector;

public class Ex03_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(new A()); // 0th index
		vec.add(new B()); // 1th index
		vec.add("Hello, collection");
		vec.add(10);
		
		System.out.println(vec);
	}
}
