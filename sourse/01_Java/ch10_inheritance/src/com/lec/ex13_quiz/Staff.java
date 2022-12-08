package com.lec.ex13_quiz;

public class Staff extends Person {
	private String department;
	public static int count=0;

	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		setNo ("staff" + (++count));
	}
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "\t(ºÎ¼­)" + department + "\n";
	}
}

