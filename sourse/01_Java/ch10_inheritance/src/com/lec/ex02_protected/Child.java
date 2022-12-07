package com.lec.ex02_protected;
//private i, j //public setI(), getI(), setJ(), getJ()  상속받음
public class Child extends SuperIJ{
	private int total;
	public Child() {
		super();
		System.out.println("매개변수 없는 child 생성자 함수");
	}
	public Child(int i, int j) {  // 오후 수정 : super 이용
		super(i, j); //상위 클래스의 매개변수 있는 생성자 호출
		System.out.println("매개변수 있는 child 생성자 함수 - i, j 초기화");
//		setI(i); 
//		this.i = i; //프라이빗이면 사용 불가, 프로텍티드면 사용 가능
//		setJ(j); 
//		this.j = j; //프라이빗이면 사용 불가, 프로텍티드면 사용 가능
	}
	public void sum() {
//		total = getI() + getJ();
		total = i + j;
		System.out.println("i = "+ getI() + ", j= " + getJ() + ", total =" + total);
	}
}
