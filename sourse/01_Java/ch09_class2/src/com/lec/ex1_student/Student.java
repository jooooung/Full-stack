//데이터 : 이름 국어 영어 수학 총점 평균
//메소드 : infoString()
package com.lec.ex1_student;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	public Student() {}
	private double avg;
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = tot/3.0;
	}
	public String infoString() {
	return String.format("\t%s\t%d\t%d\t%d\t%d\t%.1f\n", name, kor, eng, mat, tot, avg);	
	}
	//s.infoPrint();
	public void infoPrint() {
		System.out.printf(String.format("\t%s\t%d\t%d\t%d\t%d\t%.1f\n", name, kor, eng, tot, avg));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
}
