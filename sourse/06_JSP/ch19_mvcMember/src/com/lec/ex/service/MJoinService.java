package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("/memberPhotoUp");
		int maxSize = 1024 * 1024 * 5;	
		String image = "";
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", 
									new DefaultFileRenamePolicy()); 
			Enumeration<String> paramNames = mRequest.getFileNames();
			while(paramNames.hasMoreElements()){
					String param = paramNames.nextElement();
					image = mRequest.getFilesystemName(param);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		InputStream  is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path + "/" + image);
			if(serverFile.exists()){	
				is = new FileInputStream(image);		
				os = new FileOutputStream("D:/full-stack/sourse/06_JSP/ch19_mvcMember/WebContent/memberPhotoUp/" + image);		
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int nReadCnt = is.read(bs);
					if(nReadCnt == -1) break;
					os.write(bs, 0, nReadCnt);
				}
				System.out.println("서버에 업로드한 파일을 소스폴더로 복사 완료");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		
		String mid = mRequest.getParameter("mid"); 
		String mpw = mRequest.getParameter("mpw"); 
		String mname = mRequest.getParameter("mname"); 
		String memail = mRequest.getParameter("memail"); 
		String mphoto = mRequest.getParameter("mphoto");
		if(mphoto == null) {
			mphoto = "default.png";
		}
		String mbirthStr = mRequest.getParameter("mbirth");
		Date mbirth = null;
		if(!mbirthStr.equals("")) {
			mbirth = Date.valueOf(mbirthStr);
		}
		String maddress = mRequest.getParameter("maddress");
		String mrdateStr = mRequest.getParameter("mrdate");
		Date mrdate = null;
		HttpSession session = request.getSession();
		MemberDao mDao = new MemberDao();
		MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
		int result = mDao.join(member);
		if(result == mDao.SUCCESS) {
			session.setAttribute("member", member);
		}
		request.setAttribute("joinResult", result );
	}
}
