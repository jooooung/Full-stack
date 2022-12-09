package com.lec.ex04_actor;

public class ActorMain {
	public static void main(String[] args) {
		Actor gong = new Actor("°øÀ¯");
		gong.makePizza(); 	gong.makeSpaghetti();
		gong.outFire();		gong.saveMan();
		gong.canCatchCriminal();	gong.canSearch();
		
		Chef chefGong = gong;
		gong.makePizza(); 	gong.makeSpaghetti();
		gong.outFire();		gong.saveMan();
		gong.canCatchCriminal();	gong.canSearch();
		
		FireFighter FireGong = gong;
//		FireGong.makePizza(); 	FireGong.makeSpaghetti();
		FireGong.outFire();		FireGong.saveMan();
//		FireGong.canCatchCriminal();	FireGong.canSearch();
		
		PoliceMan policeGong = gong;
//		policeGong.makePizza(); 	policeGong.makeSpaghetti();
//		policeGong.outFire();		policeGong.saveMan();
		policeGong.canCatchCriminal();	policeGong.canSearch();
		
	}
}
