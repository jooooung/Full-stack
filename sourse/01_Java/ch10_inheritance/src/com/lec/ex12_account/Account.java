//데이터 : accountNo(String), ownerName(String), balance(long)
//기능(메소드) : deposit(예금), withdraw(인출), infoPrint(정보출력)
package com.lec.ex12_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName + "님 계좌 개설 감사합니다. 잔액 : "+ balance);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"님 계좌 개설 감사합니다. 잔액 : "+balance);
	}
	public void deposite(long money) {//예금하기
		balance += money;
		System.out.println(money+"원 예금하여 잔액 : "+balance);
	}
	public void withdraw(long money) {//잔액이 있을 경우에만 인출되게 하기
		if(balance>=money) {
			balance -= money;
			System.out.println(money+"원 인출하여 잔액 :" + balance);
		}else {
			System.out.println("잔액이 부족하여 인출 불가합니다");
		}
	}
	public void infoPrint() {
		// "110-333-5555" 홍길동님 잔액 : 10원 출력
//		System.out.println("\""+accountNo+"\" "+ ownerName +"님 잔액 :" + balance + "원" );
		System.out.printf("\" %s \"%s님 잔액 : %d원\n", accountNo, ownerName, balance);
	}
	//setter : name      계좌번호, 잔액은 변경할 수 없게  이름은 변경 가능하게
	//getter 
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String infoString() {
		//return "\""+accountNo+"\" "+ ownerName +"님 잔액 :" + balance + "원";
		return String.format("\" %s \"%s님 잔액 : %d원\n", accountNo, ownerName, balance);
	}
}
