package com.lec.ex3_account;

public class AccountMain {
	public static void main(String[] args) {
		Account hong = new Account("110-1", "È«±æµ¿", 10000);
		hong.infoPrint();
//		System.out.println(hong.infoString());
		Account hong1 = new Account("110-2", "È«±æ¼ø");
		hong1.infoPrint();
		Account hong2 = new Account();
		System.out.println(hong2.infoString());
		hong.withdraw(5000);
		hong.deposite(500);
		hong1.deposite(2200000000L);
		hong1.withdraw(2200000000L);
 	}
}
