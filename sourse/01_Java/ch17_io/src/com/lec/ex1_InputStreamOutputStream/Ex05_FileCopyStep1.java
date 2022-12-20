package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//C:\Users\EZEN 203\Desktop\bts.mp4  -> C:\Users\EZEN 203\Desktop\bts_copy.mp4 
public class Ex05_FileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		long start = System.currentTimeMillis();
		try {
			is = new FileInputStream("C:\\Users\\EZEN 203\\Desktop\\bts.mp4"); // 1. 스트림 객체 생성
			os = new FileOutputStream("C:\\Users\\EZEN 203\\Desktop\\bts_copy.mp4");
			int cnt = 0; // 몇 번 수행하는지 체크
			while (true) {
				cnt++;
				int i = is.read(); // 2. read & write
				if (i == -1)
					break;
				os.write(i);
				if (cnt % 100000 == 0) { // cnt를 10만번에 한 번씩 출력
					System.out.println(cnt + (int) (cnt / 8075033.0 * 100) + "%");
				}
			}
			System.out.println(cnt + "번 while문 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)   //3. 파일 닫기(스트림 해제\) 
				    os.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}//
		long end = System.currentTimeMillis(); // 1970. 1.1 ~ 끝나는 시점까지의 밀리세컨
		System.out.println(end-start);
	}
}
