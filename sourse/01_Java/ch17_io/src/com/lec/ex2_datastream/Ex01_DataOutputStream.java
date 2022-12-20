package com.lec.ex2_datastream;
//자바에서만 읽을 수 있는 파일 만들기
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//outputStream을 보조(조금 발전된 스트림)
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;		//기본 스트림
		DataOutputStream dos = null;	//보조 스트림
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat"/* , true */);   //true는 추가, 없으면 덮어쓰기
			dos = new DataOutputStream(fos);
		    dos.writeUTF("홍길동");   //스트링 저장
		    dos.writeInt(2);
		    dos.writeDouble(95.5);
		    
		    dos.writeUTF("마길동");   //스트링 저장
		    dos.writeInt(6);		//int 저장
		    dos.writeDouble(96.6);	//double 저장
		    System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
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
		}//try-catch-finally
	}//main
}
