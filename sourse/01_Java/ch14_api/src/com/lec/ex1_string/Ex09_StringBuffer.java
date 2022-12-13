package com.lec.ex1_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strbuffer = new StringBuffer("abc");
		System.out.println("strBuffer의 해쉬코드 : " + strbuffer.hashCode());
		strbuffer.append("def");   //뒤에 def 추가
		System.out.println("append 후 : " + strbuffer);
		System.out.println("strBuffer의 해쉬코드 : " + strbuffer.hashCode());
		strbuffer.insert(3, "aaa");   //3번째에 aaa 추가
		System.out.println("insert 후 : " + strbuffer);
		System.out.println("strBuffer의 해쉬코드 : " + strbuffer.hashCode());
		strbuffer.delete(3, 6);
		System.out.println("delete 후 : " + strbuffer);
		System.out.println("strBuffer의 해쉬코드 : " + strbuffer.hashCode());
		int capacitySize = strbuffer.capacity();
		System.out.println("버퍼의 가용크기 :" + capacitySize);
		strbuffer.append("abcefjhksjdhfhfhfhffhfhfhhfh");
		System.out.println("append 후 : "+strbuffer);
		System.out.println("해쉬코드 : " + strbuffer.hashCode());
		System.out.println("많은 문자를 추가한 후 가용크기 : " + strbuffer.capacity());
	}
}

//append(String str) : 문자열 str 추가
//insert(int index, String str) : 특정 index에 문자열 str 추가
//delete(int start, int end) : index위치 start부터 end앞 까지 삭제
//deleteCharAt(int index) : index위치의 특정 문자 하나 삭제
//int capacity() : 문자열 크기 반환
//ensureCapacity(int size) : 버퍼의 크기를 size만큼 늘리는 메소드
//trimToSize() : 과도한 버퍼 크기를 적당하게 줄이는 메소드
