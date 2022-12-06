// 객체 생성 : new Student("정우성", 90, 80, 100)
// 메소드 
package com.lec.quiz;

public class Student {
	private int No;
	public static int count=0;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int avg=tot/3;
	public Student(String name, int kor, int eng, int mat) {
		No = ++ count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = (int)(tot/3.0+0.5); //반올림
	}
	public void infoPrint() {
		System.out.printf(String.format("\t%d\t%s\t%d\t%d\t%d\t%d\t%d\n", No, name, kor, eng, mat, tot, avg));
	}
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Student.count = count;
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
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}	
}
	
