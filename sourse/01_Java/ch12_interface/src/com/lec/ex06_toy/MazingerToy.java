package com.lec.ex06_toy;

public class MazingerToy implements IMoveArmLeg, IMissile {
	public MazingerToy() {
		System.out.println("마징가입니다");
		canMoveArmLeg();
		canMissile();
	}
	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("미사일을 쏠 수 있습니다");
	}

	@Override
	public void canMoveArmLeg() {
		// TODO Auto-generated method stub
		System.out.println("팔다리를 움직일 수 있습니다");
	}
}
