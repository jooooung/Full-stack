package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// update 로직
		System.out.println("update 로직 수행");
		request.setAttribute("updateResult", 1);
	}
}
