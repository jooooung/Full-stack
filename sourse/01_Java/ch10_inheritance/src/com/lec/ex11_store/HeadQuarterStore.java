// º»»ç : ±èÄ¡Âî°³-5,000¿ø     ºÎ´ëÂî°³ : 6,000¿ø    ºñºö¹ä : 6,000¿ø     ¼ø´ë±¹ : 5,000¿ø     °ø±â¹ä-1,000¿ø
// HeadQuarterStore head = new HeadQuarterStore("= = º»»ç = =")
package com.lec.ex11_store;

public class HeadQuarterStore {
	public String storeName;

	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : 5,000¿ø");
	}
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ : 6,000¿ø");
	}
	public void bibim() {
		System.out.println("ºñºö¹ä : 6,000¿ø");
	}
	public void sunde() {
		System.out.println("¼ø´ë±¹ : 5,000¿ø");
	}
	public void gonggibab() {
		System.out.println("°ø±â¹ä : 1,000¿ø");
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
