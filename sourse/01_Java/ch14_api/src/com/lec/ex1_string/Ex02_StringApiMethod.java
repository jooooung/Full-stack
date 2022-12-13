/*  String concat(String str) : 저장된 문자열과 str문자열을 결합
	String substring(int begin) : 시작위치부터 마지막까지의 문자열을 반환
	int length() : 문자열 길이를 반환
	String toUpperCase() : 대문자로 반환
	String toLowerCase() : 소문자로 반환
	char charAt(int index) : index 위치의 문자를 반환
	int indexOf(char ch) : 첫번째 ch문자의 위치를 반환
	int lastIndexOf(char ch) : 마지막 ch문자의 위치를 반환
	boolean equals(String str) : 지정된문자열과 str문자열이 같은지 비교
	boolean equalslgnoreCase(String str) : 대소문자구분없이 지정된문자열과 str문자열이 같은지 비교
	String trim() : 문자열 앞뒤 공백제거
	String replace(char old, char new) : 문자열 내의 old문자를 new문자로 반환
	String  repalceAll(String old, String new) : 문자열 내의 old문자열을 new로 반환
*/
package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {     
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "  ja  va  ";
		System.out.println("1. " + str1.concat(str2));  //1. abcXabcabcXabc
		System.out.println("2. " + str1.substring(3));  //3번째 글씨부터 끝까지   2. Xabc
		System.out.println("3. " + str1.substring(3,5));//3번째 부터 5번째 앞까지  3. Xa
		System.out.println("4. " + str1.length()); //문자열 길이 4. 7
		System.out.println("5. " + str1.toUpperCase());  //대문자로  5. ABCXABC
		System.out.println("6. " + str1.toLowerCase());  //소문자로  6. abcxabc
		System.out.println("7. " + str1.charAt(3));  //3번째 문자  7. X
		System.out.println("8. " + str1.indexOf('b'));  //첫번째 b가 나오는 인덱스 8. 1
		System.out.println("9. " + str1.lastIndexOf('b'));  //마지막b가 나오는 인덱스 9. 5
		String str4 = "abcXabcXabcXabc";
		System.out.println("10. " + str4.indexOf('b', 3));  //3번째 인덱스부터 나오는 첫 b  10. 5
		System.out.println("11. " + str4.indexOf("cXa"));   // 처음 나오는 cXa의 인덱스       11. 2
		System.out.println("12. " + str4.indexOf("cXa", 9));   //9번째부터 나오는 cXa    12. 10
		System.out.println("13. " + str4.indexOf("z"));  //없으면 -1  13. -1
		System.out.println("14. " + str1.equals(str2));  //같은 스트링은 true 14. true
		System.out.println("15. " + str1.equalsIgnoreCase("abcxabc"));  //대소문자구분 없이 비교  15. true
		System.out.println("16. " + str3.trim());  //앞 뒤 스페이스 제거  16. Ja  va
		System.out.println("17. " + str4.replace("abc", "바꿔"));   //17. 바꿔X바꿔X바꿔X바꿔
		System.out.println("str1=" + str1);
		System.out.println("str3=" + str3);
		System.out.println("str4=" + str4);
	}
}
