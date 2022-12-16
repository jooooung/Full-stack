// Book book = new Book("890-01-11", "java", "홍길동");
package com.lec.ex5_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book implements ILendable {
	private String bookNo; // 책번호
	private String bookTitle; // 책이름
	private String writer; // 저자
	private String borrower; // 대출인
	private Date checkOutDate;  
	private byte state; // 대충 상태 : 대출중(1), 대출가능(0)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) HH시 mm분");
		if (state == STATE_BOOROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(bookTitle + "은 대출중입니다");
			return; // void 이기에 return 뒤에 값 입력 불가
		}
		// state가 0(STATE_NORMAL)이라서 대출 진행
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BOOROWED; // 대출중 상태로 전환
		System.out.println(bookTitle + "도서가 대출 처리 되었습니다");
		System.out.println("대출인 : " + borrower + "\t대출일 : " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception("반납 완료된 책입니다");
		}
		Date now = new Date();
		// checkOutDate와 현재시점간의 날짜 계산
		long chk = now.getTime() - checkOutDate.getTime();
		long day = chk/(1000*60*60*24); // 빌린날
		// 연체료 부과 -> 연체료 받았는지 여부에 따라 반납 처리 진행
		if (day > 14) {
			long i = (day) * 100; //연체료 
			System.out.printf("%d일 연체되어 연체금은 %d원입니다. 연체료를 받으셨습니까(Y/N)? ", day, i);
			Scanner scanner = new Scanner(System.in);
			if(!scanner.next().trim().toUpperCase().equalsIgnoreCase("Y")) {
				System.out.println(bookTitle + "연체료를 내야 반납 처리가 됩니다");
				return;
			}
		}
		// state가 대출중(1)이라 반납 처리
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납 완료되었습니다");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) HH시 mm분");
		String msg = bookNo + "\t" + bookTitle + "\t" + "(" + writer + "著)-";
		msg += state == STATE_NORMAL ? "대출가능 " : "대출 중 "+ sdf.format(checkOutDate);
		return msg;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}
