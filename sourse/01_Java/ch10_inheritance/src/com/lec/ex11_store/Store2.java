//2È£Á¡ : ºÎ´ëÂî°³-5000  ºñºö¹ä-5000  °ø±â¹ä ¹«·á
package com.lec.ex11_store;

public class Store2 extends HeadQuarterStore {

	public Store2(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
System.out.println("ºÎ´ëÂî°³ : 5,000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä : 5,000¿ø");
	}
	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä : ¹«·á");
	}
}
