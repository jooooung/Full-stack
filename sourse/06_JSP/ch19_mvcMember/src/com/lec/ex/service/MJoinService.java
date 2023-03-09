package com.lec.ex.service;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
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
		String mid = mRequest.getParameter("mid"); 
		String mpw = mRequest.getParameter("mpw"); 
		String mname = mRequest.getParameter("mname"); 
		String memail = mRequest.getParameter("memail"); 
		String mphoto = mRequest.getParameter("mphoto"); 
		String mbirth = mRequest.getParameter("mbirth");
		String maddress = mRequest.getParameter("maddress");
		String mrdate = mRequest.getParameter("mrdate");
		MemberDao mDao = new MemberDao();
		MemberDto dto = new MemberDto();
		request.setAttribute("joinResult", mDao.join(dto));
	}
}
