package com.lec.ex01_store;

public class StoreMain {

	public static void main(String[] args) {
//		HeadQuarterStore head = new HeadQuarterStore("= = 본사 = =");
//		Store1 st1 = new Store1("= = 주택가 1호점 = =");
//		Store2 st2 = new Store2("= = 대학가 2호점 = =");
//		Store3 st3 = new Store3("= = 증권가 3호점 = =");
//		HeadQuarterStore[] stores = {head, st1, st2, st3};
		HeadQuarterStore[] stores = {
//				new HeadQuarterStore("=== 본사 ==="),
				new Store1("=== 1호점 ==="),
				new Store2("=== 2호점 ==="),
				new Store3("=== 3호점 ===") };
 		for(int idx=0 ; idx<stores.length ; idx++) {
			System.out.println(stores[idx].getStoreName());
			stores[idx].kimchi();
			stores[idx].bude();
			stores[idx].sunde();
			stores[idx].bibim();
			stores[idx].gonggibab();
		}//일반for
		for(HeadQuarterStore store : stores) {
			System.out.println(store.getStoreName());
			store.kimchi();
			store.bude();
			store.sunde();
			store.bibim();
			store.gonggibab();
		}//확장for문
	}//main
}//class
