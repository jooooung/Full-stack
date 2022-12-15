package com.lec.ex4_object;

import java.util.Random;

public class Ex03_CardMain { // ♥ ♣ ♠ ◆
	public static void main(String[] args) {
		Card[] cards = { new Card('♥', 1), new Card('♠', 2), new Card('♥', 3),  //배열에 카드 생성
						 new Card('♥', 4), new Card('♣', 5), new Card('♥', 6), 
						 new Card('◆', 7), new Card('♥', 8), new Card('♠', 9), 
						 new Card('♠', 10), new Card('♥', 11), new Card('♥', 12), };
		for(Card card : cards) {
			System.out.println(card);	//확장 for문 이용하여 카드 출력
		} //for
		//임의로 뽑힌 카드와 배열안의 카드 비교
		Random random = new Random();
		char[] kinds = {'♥', '♣', '♠', '◆'};   // 랜덤한 kind를 출력하기 위해 만든 배열
		Card randomCard = new Card(kinds[random.nextInt(4)], random.nextInt(13)+1);  //카드 그림과 숫자 랜덤값
		System.out.println("임의로 뽑힌 카드 : " + randomCard);
		int i;
		for(i=0 ; i<cards.length ; i++) {   //같은 카드 찾는 for문
			if(cards[i].equals(randomCard)) {
				System.out.println(i + "번째 카드와 일치");
				break;
			} 
		} //for
		if(i == cards.length) {
			System.out.println("일치하는 카드가 없습니다");
		}
	} //main
}


/*
 * kinds[random.nextInt(4)] : kinds배열의 4번째 앞부터 랜덤하게 출력 
 * random.nextInt(13)+1 : random배열의 13번째부터 출력
 * 배열에 중복된 카드가 없을 시  for문의 i변수를 for문 밖에서 선언
 * i==cards.length : 일치하는 카드가 없는 것
 * i!=cards.length : 일치하는 카드가 있는 것
 */