//new Card('♥', 6)   ♥  ♣   ♠   ◆
package com.lec.ex4_object;

public class Card {
	private char kind; // ♥ ♣ ♠ ◆
	private int num; // 1~13
	
	public Card() {}

	public Card(char kind, int num) {  
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "카드 : " + kind + " " + num;  //출력 ex) 카드 : ♠ 3 
	}
	@Override
	public boolean equals(Object obj) {
		//card.equals(comCard) => card 가 this.   comCard가 obj가 된다
		//obj가 null이 아니고 obj가 Card타입 객체인지 확인후 kind와num 비교 결과 return
		if(obj!=null && obj instanceof Card) {   //(getClass()==obj.getClass()
			Card other = (Card)obj;        // other라는 Card 
			boolean kindChk = kind == other.kind;  //boolean 이용 true/false 선언
			boolean numChk = num == other.num;
			return kindChk && numChk;
		}
		return super.equals(obj);
	}
}
