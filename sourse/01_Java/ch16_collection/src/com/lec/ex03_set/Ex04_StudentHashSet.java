
package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex04_StudentHashSet {
	public static void main(String[] args) {
		Student s1 = new Student(1, "김길동");
		Student s2 = new Student(1, "김길동");

		System.out.println(s1.hashCode() + ":" + s2.hashCode());

		HashSet<Student> students = new HashSet<>();
		students.add(new Student(1, "김길동"));
		students.add(new Student(1, "김길동"));
		students.add(new Student(3, "삼길동"));
		students.add(new Student(4, "사길동"));
		students.add(new Student(5, "오길동"));
		students.add(new Student(6, "육길동"));
		System.out.println(students);

		students.remove(new Student(1, "김길동"));
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}
