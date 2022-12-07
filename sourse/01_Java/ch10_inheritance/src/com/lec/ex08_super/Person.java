//super.~ : 부모 클래스의 ~
//super() : 부모 클래스의 생성자 함수
package com.lec.ex08_super;

public class Person {
	private String name;
	private String character;
	public Person() {
		System.out.println("매개변수 없는 Person 생성자");
	}
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("매개변수 2개짜리 Person 생성자");
	}
	public void intro() {   //return 없는 method 생성
		System.out.println("★" + name + "은" + character );
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}
