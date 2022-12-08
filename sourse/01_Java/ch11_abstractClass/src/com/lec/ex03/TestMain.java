/* SuperClasss(A) : method1(A), method2, method3
ChildAbstract(A) : method1(A), method2, method3, method4
GrandChild : method1, method2, method3, method4
*/
package com.lec.ex03;

import com.lec.ex02.SuperClass; //다른 패키지 임폴트

public class TestMain {
	public static void main(String[] args) {
		SuperClass s = new GrandChild();
		s.method1();
		s.method2();
		s.method3();

		System.out.println("==========================");
		GrandChild g = new GrandChild();
		g.method1();
		g.method2();
		g.method3();
		g.method4();
		ChildAbstract ca = new GrandChild();
		ca.method1();
		ca.method2();
		ca.method3();
		ca.method4();

	}
}
