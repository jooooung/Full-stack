package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// DataInputStream은 InputStream의 보조 스트림
public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis);
			while(true) { 		// 데이터 가져오기
				String name = dis.readUTF();	//write 변수와 같은 read 가져오기
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.printf("%s는 %d학년 %.1f점\n", name, grade, score);
			}
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
		}
	}
}
