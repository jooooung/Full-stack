//this.~ : 내 객체의 ~
//this() : 현 클래스의 생성자 함수
package com.lec.ex07_this;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("매개변수 없는 생성자");
	}
	public Friend(String name) {
		this(); // == Friend()
		this.name = name;
		System.out.println("매개변수 1개인 생성자");
	}
	public Friend(String name, String tel) {
		this(name); // = Friend(name)
		this.tel = tel;
		System.out.println("매개변수 2개인 생성자");
	}
	public String infoString() {
		return name + " : " + tel;
	}
}
