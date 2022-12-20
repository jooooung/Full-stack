package com.lec.ex1_InputStreamOutputStream;
import java.io.File;
// 속도 높이기
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//JSP나 Spring에서 파일첨부게시판 작정시 copy할 로직
//C:\Users\EZEN 203\Desktop\bts.mp4  -> C:\Users\EZEN 203\Desktop\bts_copy.mp4 
public class Ex07_FileCopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		long start = System.currentTimeMillis();
		try {
			File file = new File("C:\\Users\\EZEN 203\\Desktop\\bts.mp4");
			is = new FileInputStream(file); // 1. 스트림 객체 생성
			os = new FileOutputStream("C:\\Users\\EZEN 203\\Desktop\\bts_copy.mp4");
			byte[] bs = new byte[(int) file.length()];  //1킬로바이트
			int cnt = 0; // 몇 번 수행하는지 체크
			while (true) { //2번 수행
				cnt++;
				int Count = is.read(bs); // 2. read(bs에 읽는다) & write
				if (Count == -1)
					break;
				os.write(bs, 0, Count); // bs배열을 0번 index부터 Count의 바이트 만큼 write
			}
			System.out.println(cnt + "번 while문 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) // 3. 파일 닫기(스트림 해제\)
					os.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} //
		long end = System.currentTimeMillis(); // 1970. 1.1 ~ 끝나는 시점까지의 밀리세컨
		System.out.println(end - start);
	}
}
