package com.lec.ex5_booklib;

public interface ILendable {
	public byte STATE_BOOROWED = 1; //대출중
	public byte STATE_NORMAL = 0;   //대출가능
	public void checkOut(String borrower); //대출 
	public void checkIn() throws Exception;		// 반납
	
}
