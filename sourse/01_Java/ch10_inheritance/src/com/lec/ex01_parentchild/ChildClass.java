//extends ParentClass : ParentClass 를 상속 (부모클래스는 하나만 올 수 있다)
package com.lec.ex01_parentchild;

public class ChildClass extends ParentClass{
	String cStr = "자식클래스";
	public ChildClass() {
	System.out.println("자식 생성자");
	}
}
