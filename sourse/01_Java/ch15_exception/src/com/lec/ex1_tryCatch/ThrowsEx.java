package com.lec.ex1_tryCatch;

public class ThrowsEx {
	public ThrowsEx() throws Exception{
		actionC();
	}

	private void actionC() throws IndexOutOfBoundsException{
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}

	private void actionB() throws IndexOutOfBoundsException{
		System.out.println("actionB 전반부");
		try {
			actionA();
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("actionB 후반부");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException{  //예외가 발생되면 중단
		System.out.println("actionA 전반부");
		int[] arr = { 0, 1, 2 };
			System.out.println(arr[3]);			//이 부분에서 예외가 발생하여
		System.out.println("actionA 후반부");    // 그 다음은 실행 x
	}
}
