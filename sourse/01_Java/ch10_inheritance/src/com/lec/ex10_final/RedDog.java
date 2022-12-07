// speed, running(Dog에서 override), stop(Animal의 final 메소드 stop)
package com.lec.ex10_final;

public class RedDog extends Dog {
	public void method() {
		System.out.println("그냥 추가해 봤어요. 속도는" + speed);
	}
}
