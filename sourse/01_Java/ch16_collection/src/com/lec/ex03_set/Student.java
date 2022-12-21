package com.lec.ex03_set;

public class Student {
	private int grade;
	private String name;

	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}

	@Override
	public String toString() {
		return grade + "학년 " + name;
	}
	
	@Override
	public int hashCode() {
		// 중복된 값이 들어가지 않도록 Override
		// 같은 grade, name일 경우 같은 hashCode
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// s1.equals(s2)
		// s1 = this, s2 = obj
		if (obj != null && getClass() == obj.getClass()) {
			Student other = (Student)obj;
			boolean gradeChk = grade == other.grade;
			boolean nameChk = name == other.name;
			return gradeChk && nameChk;
		} else {
			return false;
		}
		
	}
}