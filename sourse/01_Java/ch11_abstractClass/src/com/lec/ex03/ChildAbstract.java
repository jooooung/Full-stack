//상속 받은 method1(추상), method2, method3 있음
//상속 받은 method1이 추상 메소드이므로 abstract 로 추상클래스를 만들어 줌
package com.lec.ex03;

import com.lec.ex02.SuperClass;

public abstract class ChildAbstract extends SuperClass {
	public void method4() {
		System.out.println("ChildAbstract의method4");
	}
}
