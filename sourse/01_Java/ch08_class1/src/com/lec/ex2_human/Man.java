package com.lec.ex2_human;
//Man kim = new Man();		매개변수 없음
//Man kim = new Man("홍길동");		이름만 있는 매개변수
//Man kim = new Man("홍길동", 22, 170, 65);		이름, 나이, 키, 몸무게 다있는 매개변수
public class Man {
	private String name;
	private int age;
	private int height;
	private double weight;
	// 개발자가 생성자 함수를 만들면 컴파일러는 디폴트 생성자 함수를 만들지 않는다
	// 따라서 생성자 함수를 만들고 디폴트 생성자 함수가 필요하면 만들어야 한다
	public Man() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Man(String name, int age, int height, double weight) {
		this.setName(name);
		this.setAge(age);
		this.height = height;
		this.weight = weight;
		System.out.println("데이터 4개 초기화하는 생성자 함수");
	}
	public Man(String name) {
		System.out.println("이름 초기화하는 생성자 함수");
	}
	public Man(int height) {
		this.height = height;
	}
	public Man(double weight) {
		this.weight = weight;
	}
	public double calculateBMI() {//객체안에 height와 weight로 BMI 지수 return
		double result = weight / ( (height*0.01) * (weight*0.01) );
		return result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
