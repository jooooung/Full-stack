package com.lec.quiz;

public class BookLib extends BookInfo implements ILendable {
	private String borrower; // 대출인
	private String checkOutDate; // 대출일
	private byte state; // 대충 상태 : 대출중(1), 대출가능(0)

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BOOROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(getBookTitle() + "은 대출중입니다");
			return; // void 이기에 return 뒤에 값 입력 불가
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BOOROWED; // 대출중 상태로 전환
		System.out.println(getBookTitle() + "도서가 대출 처리 되었습니다");
		System.out.println("대출인 : " + borrower + "\t대출일 : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "도서는 반납완료된 책입니다. 확인하세요");
			return;
		}
		// state가 대출중(1)이라 반납 처리
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "도서가 반납 완료되었습니다");

	}

	@Override
	public void printState() {
		String msg = getBookNo() + "\t" + getBookTitle() + "\t" + "(" + getWriter() + "著)-";
		msg += state == STATE_NORMAL ? "대출가능" : "대출 중";
		System.out.println(msg);
	}

	public byte getState() {
		return state;
	}
}
