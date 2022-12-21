package com.lec.ex6_atm;

public class AtmMain {
	public static void main(String[] args) {
		Atm atm = new Atm(1000);
		Runnable card = new AtmTarget(atm);
		Thread t1 = new Thread(card, "MOM");
		Thread t2 = new Thread(card, "DAD");
		t1.start();
		t2.start();
		
	}
}
