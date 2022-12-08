package com.lec.ex13_quiz;

public class Gangsa extends Person {
	private String subject;
	public static int count=0;

	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setNo ("lec" + (++count));
	}
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "\t(°ú¸ñ)" + subject + "\n";
	}
}
