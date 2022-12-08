package com.lec.ex13_quiz;

public class Student extends Person {
	private String ban;
	public static int count=0;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setNo ("student" + (++count));
	}
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "\t(¹Ý)" + ban + "\n";
	}
}