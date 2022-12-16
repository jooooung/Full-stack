package com.lec.ex4_newException;

public class AccountMain {
	public static void main(String[] args) {
		Account acc = new Account("111-111", "ȫ�浿");
		acc.deposite(10000);
		try {
			acc.withdraw(19000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
