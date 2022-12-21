package com.lec.ex6_atm;

public class Atm {
	private int balance;

	public Atm(int balance) {
		this.balance = balance;
	}
	
	public synchronized void deposit(int amount, String who) {
		System.out.println(who + "가 입급 시작");
		balance += amount;
		System.out.println(who + "가" + amount + "원 입금하여 잔액 : " + balance);
		System.out.println(who + "가 입금 끝");
	}
	
	public synchronized void withdraw(int amount, String who) {
		System.out.println(who + "가 출금 시작");
		balance -= amount;
		System.out.println(who + "가" + amount + "원 출금하여 잔액 : " + balance);
		System.out.println(who + "가 출금 끝");
	}
	
	public int getBalance() {
		return balance;
	}
}
