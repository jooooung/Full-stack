// class 앞에 final을 썼기에 Rabbit 상속 금지
// speed, running(), stop(final)
package com.lec.ex10_final;

public final class Rabbit extends Animal {
	@Override
	public void running() {
	speed += 30;
	System.out.println("토끼가 마구 마구 뛰어요. 현재 속도 : " + speed);
	}
}