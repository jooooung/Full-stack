package com.lec.ch13.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUpService {

	public boolean fileUp(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		boolean isUpload = false;
		// mRequest에 들어온 파일을 서버에 저장 -> 소스폴더로 복사
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "C:/Full-stack/sourse/09_Spring/ch13_fileupload/src/main/webapp/upload/";
		String[] fileNames = new String[3];
		int i = 0;
		Iterator<String> params = mRequest.getFileNames();
		while(params.hasNext()) {
			String param = params.next();
			System.out.println(param);
			MultipartFile mFile = mRequest.getFile(param);	// 파라미터의 파일 객체
			String originalFileName = mFile.getOriginalFilename();	// 업로드한 파일 이름
			fileNames[i] = originalFileName;
			System.out.println(originalFileName == null ? "널이야" : 
				originalFileName.equals("")? "빈스트링이야" : "첨부파일 : " + originalFileName);
			// 첨부를 안 하면 빈스트링
			if(fileNames[i] != null && !fileNames[i].equals("")) {
				// 첨부함
				if(new File(uploadPath + fileNames[i]).exists()) {
					// 파일명 중복 시 
					fileNames[i] = System.currentTimeMillis() + fileNames[i];
				} // if
				try {
					// 첨부파일 서버에 저장
					mFile.transferTo(new File(uploadPath+fileNames[i]));
					System.out.println("서버에 저장된 파일 : " + uploadPath + fileNames[i]);
					System.out.println("복사될 파일 : " + backupPath + fileNames[i]);
					// 파일 복사(소스 폴더로)
					isUpload = filecopy(uploadPath + fileNames[i], backupPath + fileNames[i]);
				}catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				// 첨부 안 함
				System.out.println(i + "번째 첨부 안함 : " + fileNames[i].equals("") != null ? "빈스트링" : "빈스트링 아님");
			} // if
			i++;
		} // while
		mav.addObject("fileNames", fileNames);
		return isUpload;
	}

	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}
