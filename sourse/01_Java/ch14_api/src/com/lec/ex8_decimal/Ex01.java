package com.lec.ex8_decimal;

//DecimalFormat패턴. 숫자 자리수 : #(있으면 출력 없으면 출력x), 0(반드시 출력)
import java.text.DecimalFormat;

public class Ex01 {
	public static void main(String[] args) {
		double number = 1234567.8787;
		DecimalFormat df = new DecimalFormat("########.####"); // 1234567.8787 있는 숫자만 출력
		System.out.println("########.####" + df.format(number));
		DecimalFormat df2 = new DecimalFormat("00000000.00000"); // 01234567.87870 없는 자리도 0으로 출력
		System.out.println("00000000.00000" + df2.format(number));
		DecimalFormat df3 = new DecimalFormat("0,000.00"); 
		System.out.println("0.000.00" + df3.format(number));
		DecimalFormat df4 = new DecimalFormat("##.##%");       //%자리에서 반올림
		System.out.println("##.##% : " + df4.format(0.78457));
		DecimalFormat df5 = new DecimalFormat("#.####E0");  //E뒤에는 0만 가능
		System.out.println("#.####E0 : " + df5.format(number));
	}
}
