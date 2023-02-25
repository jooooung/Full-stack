<%@page import="com.sun.net.httpserver.Authenticator.Success"%>
<%@page import="com.lec.book.BookDto"%>
<%@page import="com.lec.book.BookDao"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  <%
  	String path = request.getRealPath("bookFile");
  	int maxSize = 1024 * 1024 * 10;
  	String[] images = {"", ""};
  	MultipartRequest mRequest = null;
  	try{
  		mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
  		Enumeration<String> paramNames = mRequest.getFileNames();
  		int idx = 0;
  		while(paramNames.hasMoreElements()){
  			String param = paramNames.nextElement();
  			images[idx] = mRequest.getFilesystemName(param);
  			System.out.println(idx + "번째 처리한 파라미터 : " + param + "/파일이름 : " + images[idx]);
  			idx++;
  		}
  	}catch(IOException e){
			 System.out.println(e.getMessage());
  	}
  	// 서버파일 => 소스 폴더 복사
	  	for(String imgFile : images){
			InputStream  is = null;
			OutputStream os = null;
			File serverFile = new File(path + "/" + imgFile);
			if(serverFile.exists()){
				try{
						is = new FileInputStream(serverFile);
	  				os = new FileOutputStream("D:/full-stack/sourse/06_JSP/ch14_fileUp/WebContent/bookFile/" + imgFile);
	  				byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int readByteCnt = is.read(bs);	// bs만큼 is 서버파일 읽기
						if(readByteCnt == -1) break;		// 파일이 끝이면 break
						os.write(bs, 0, readByteCnt);
					}
				}catch(IOException e){
					System.out.println(e.getMessage());
				}finally{
					try{
						if(os != null) os.close();
						if(is != null) is.close();
					}catch(IOException e){
						System.out.println(e.getMessage());
					}
				} //try-catch-finally
			} // if 
		} // for
	  // book  테이블에 저장
	  String btitle  = mRequest.getParameter("btitle");
		int 	 bprice  = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimage1 = images[1] != null? images[1] : "noImg.png";
	  String bimage2 = images[0] != null? images[0] : "NOTHING.JPG";
		String bcontent = mRequest.getParameter("bcontent");
		if(bcontent == null) bcontent = "";
	  int 	 bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		BookDto dto = new BookDto(0, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, null);
		BookDao dao = BookDao.getInstance();
		int result = dao.insertBook(dto);
		if(result == dao.SUCCESS){
			out.println("책 등록 성공");
		}else{
			out.println("책 등록 실패");
		}
  %>
  <h3>제목 : <%=btitle %></h3>
  <h3>
  	가격<del><%=bprice %></del>
  	<b>
  		<%=bprice * (100-bdiscount) / 100 %>
  		(<%=bdiscount %>% 할인)
  	</b>
  </h3>
  <h3>대표이미지</h3>
  <img alt="" src="<%=conPath%>/bookFile/<%=bimage1%>">
  <h3>상세이미지</h3>
  <img alt="" src="<%=conPath%>/bookFile/<%=bimage2%>">
  <h3>책소개</h3>
  <pre><%=bcontent %></pre>
  <a href="ex2_list.jsp">책 1page리스트(게시판 스타일)</a><br>
  <a href="ex4_list.jsp">책 1page리스트(product list 스타일)</a><br>
  <button onclick="location.href='bookRegisterForm.html'">책 등록</button>
</body>
</html>