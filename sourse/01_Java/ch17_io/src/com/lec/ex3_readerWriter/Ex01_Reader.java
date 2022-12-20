package com.lec.ex3_readerWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("D:\\JK\\sourse\\01_Java\\ch17_io\\txtFile\\inTest.txt");  //1단계
			while (true) {  //2단계  
				int i = reader.read();  //2byte씩 읽음
				if (i == -1) break;    //file의 끝이면 break
				System.out.print((char)i);  //형변환하여 출력
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}//try-catch-finally
	}//main
}
