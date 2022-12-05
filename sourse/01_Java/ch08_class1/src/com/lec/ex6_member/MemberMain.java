/*Member member = new Member(“aaa”, “xxx”, “홍길동”, “hong@company.com”,
                                        “서울 강남구”, “2000-01-01”, ‘M’);
                   System.out.println(member.infoString() );
*/
package com.lec.ex6_member;

public class MemberMain {
	public static void main(String[] args) {
		Member member = new Member("aaa", "***", "홍길동", "hong@company.com",
                "서울 강남구", "01-01", '남');
			System.out.println(member.infoString() );
	}
}
