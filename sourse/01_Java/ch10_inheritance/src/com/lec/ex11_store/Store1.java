//1호점 : 부대찌개-5,000  순대국-안팔아
package com.lec.ex11_store;

public class Store1 extends HeadQuarterStore {

	public Store1(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 : 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 안 팔아");
	}
}
