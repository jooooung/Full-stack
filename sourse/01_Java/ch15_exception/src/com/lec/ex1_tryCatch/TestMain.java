package com.lec.ex1_tryCatch;

public class TestMain {
	public static void main(String[] args) {
		try {
			new ThrowsEx();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
