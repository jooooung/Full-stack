package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// insert 로직
		System.out.println("insert 로직 수행");
		request.setAttribute("insertResult", 1);
	}
}
