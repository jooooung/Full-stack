//신용카드
package com.lec.ex12_account;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) { // 올바른 카드 번호 입력
			if(creditLine >= amount) { // 잔액 o 지불가능
//				balance = balance - amount; balance가 private 이기에 setter getter 이용
				creditLine -= amount; // 잔액을 amount 만큼 차감
				System.out.printf("%s님 %d원 지불하여 한도 %d원\n", getOwnerName(), amount, creditLine);
			}else { // 잔액 부족  지불불가
				System.out.printf("%s님 한도 부족, 지불 불가합니다\n", getOwnerName()	);
				
			}
		}else { // 틀린 카드 번호 입력
			System.out.println("유효한 카드 번호가 아닙니다");
		}
	}	
}
