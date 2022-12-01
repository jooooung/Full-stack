package com.lec.Ex;
//πËø≠¿ª ¿ÃøÎ«œø© «–ª˝µÈ(øµ»Ò, √∂ºˆ, ±Êµø, øµºˆ, ∏ª¿⁄)¿« ≈∞∏¶ ¿‘∑¬πﬁ∞Ì, ∆Ú±’ƒ°∏¶ ±∏«ÿ∫∏¿⁄.
//∞°¿Â ≈´ ≈∞øÕ ∞°¿Â ¿€¿∫ ≈∞¿Œ ªÁ∂˜ ±∏«œ±‚
import java.util.Scanner;

public class Ex04_height {
	public static void main(String[] args) {
		String[] arrName = {"øµØM", "√∂ºˆ", "±Êµø", "øµºˆ", "∏ª¿⁄"};   //¿Ã∏ß ¿˙¿Â ∞¯∞£
		int[] arrHeight = new int[arrName.length];    //≈∞ ¿˙¿Â ∞¯∞£
		Scanner sc = new Scanner(System.in);
		int totHeight = 0;
		// ≈∞ ¿‘∑¬πﬁ±‚ -> totHeightø° ¥©¿˚
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"¿« ≈∞¥¬? : ");
			arrHeight[idx] = sc.nextInt();
			totHeight += arrHeight[idx];  //¥©¿˚
		}
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.printf("%dπ¯¬∞ %s¿« ≈∞¥¬ %d\n", idx,  arrName[idx], arrHeight[idx]);
		}
		System.out.println("∆Ú±’≈∞¥¬" + (double)totHeight/arrHeight.length);
		sc.close();
		int maxIdx=0, maxHeight=0;  //√÷¿ÂΩ≈¿ª ±∏«œ±‚ ¿ß«— ∫ØºˆµÈ(¿€¿∫ ∞™¿∏∑Œ √ ±‚»≠)
		int minIdx=0, minHeight=9999;   //√÷¥‹Ω≈¿ª ±∏«œ±‚ ¿ß«— ∫ØºˆµÈ(≈´∞™¿∏∑Œ √ ±‚»≠)
		for(int idx=0 ; idx<arrName.length ; idx++) {
			if(arrHeight[idx] > maxHeight) {       //√÷¿ÂΩ≈
				maxHeight = arrHeight[idx];
				maxIdx = idx;
			}//if
			if(arrHeight[idx] < minHeight) {		//√÷¥‹Ω≈
				minHeight = arrHeight[idx];
				minIdx = idx;
			}
		}//for
		System.out.printf("∞°¿Â ≈´ «–ª˝ %s¿« ≈∞¥¬ %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("∞°¿Â ¿€¿∫ «–ª˝ %s¿« ≈∞¥¬ %d\n", arrName[minIdx], minHeight);
	}//main
}//clase
