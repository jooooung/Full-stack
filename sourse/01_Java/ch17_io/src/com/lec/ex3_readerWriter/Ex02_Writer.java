package com.lec.ex3_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt");
			String msg = "안녕하세요 자바\n추운 날씨 감기 조심\n";
			writer.write(msg);
			String msg1 = "이번 겨울\n너무 추워";
			writer.write(msg1);
		} catch (IOException e) {
		System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
