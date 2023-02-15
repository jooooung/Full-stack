package com.lec.ex;

public class Student {
	private String ID;
	private String name;
	private int grade;
	private char cls;
	private int score;
	public Student() {	}
	public Student(String iD, String name, int grade, char cls, int score) {
		ID = iD;
		this.name = name;
		this.grade = grade;
		this.cls = cls;
		this.score = score;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getCls() {
		return cls;
	}
	public void setCls(char cls) {
		this.cls = cls;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
