package com.lec.ex06_toy;

public class PoohToy implements IMoveArmLeg {
	public PoohToy() {
		System.out.println("곰돌이 푸입니다");
		canMoveArmLeg();
		System.out.println("========================");
	}
	@Override
	public void canMoveArmLeg() {
		// TODO Auto-generated method stub
		System.out.println("팔 다리를 움직일 수 있습니다");
	}
}
