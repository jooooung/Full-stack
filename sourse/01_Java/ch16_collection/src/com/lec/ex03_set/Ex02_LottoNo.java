package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

// hashSet을 이용한 로또 번호 추첨
public class Ex02_LottoNo {

	public static void main(String[] args) {
//		HashSet<Integer> lotto = new HashSet<>();
		
		TreeSet<Integer> lotto = new TreeSet<>();
		Random random = new Random();
		int i = 0;
		while (lotto.size() < 7) {
			lotto.add(random.nextInt(45)+1);
			i++;
		}
		// i번 뽑은 로또 번호
		System.out.println(lotto);

	}

}
