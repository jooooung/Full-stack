package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// x 입력할때까지 재고 등록 : file 출력 -> x 입력시 등록된 모든 재고 출력
public class Ex03_Product {
	public static void main(String[] args) {
		// x 입력할때까지 재고 등록 : file 출력
		OutputStream fos = null;
		DataOutputStream dos = null;
		Scanner scanner = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);
			dos = new DataOutputStream(fos);
			while (true) {
				System.out.println("입고된 재고가 있나요?(y/x)");
				if (scanner.next().trim().equals("x"))
					break;
				System.out.print("입고된 상품명 : ");
				dos.writeUTF(scanner.next());
				System.out.print("가격(숫자만) : ");
				dos.writeInt(scanner.nextInt());
				System.out.print("재고 수량(숫자만) : ");
				dos.writeInt(scanner.nextInt());
			}
			System.out.println("재고 등록 완료");
			// x 입력시 등록된 모든 재고 출력
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("가격을 잘못 입력함" + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		ArrayList<Product> products = new ArrayList<>();
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec/ex2_datastream/product.dat");
			dis = new DataInputStream(fis);
			while (true) {
				String name = dis.readUTF();
				int price = dis.readInt();
				int stock = dis.readInt();
				products.add(new Product(name, price, stock));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		if (products.isEmpty()) {
			System.out.println("등록된 재고가 없습니다");
		} else {
			System.out.println("물품명\t가격\t재고수량");
			for (Product product : products) {
				System.out.println(product);
			}
			System.out.println("이상" + products.size() + "가지 재고 물품 입력됨");
		} // if-else
		scanner.close();
	}// main
}
