package com.lec.lect;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3_LifeCycle
 */
@WebServlet(name = "LifeCycle", urlPatterns = { "/LifeCycle" })
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PostConstruct
	private void postConstruct() {
		// 서블릿 객체 생성 되자마자 실행
		System.out.println("Ex3+LifeCycle 서블릿 객체가 생성될 때 수행- 1");
	} 
	
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 객체가 생성될 때 실행
		System.out.println("Ex3+LifeCycle 서블릿 객체가 생성(메모리에 load)될 때 수행 - 2");
	}
	
	public void destroy() {
		// 서블릿 객체가 소멸될 때 실행
		System.out.println("Ex3+LifeCycle 서블릿 객체가 소멸(메모리에서 사라질)될 때 수행 - 1");
	}
	@PreDestroy
	private void PreDestroy() {
		// 서블릿 객체가 소멸된 직후에 실행
		System.out.println("Ex3+LifeCycle 서블릿 객체가 소멸된 직후에 수행 - 2");
	}
	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * response.setContentType("text/html; charset=UTF-8");
	 * response.getWriter().append("<h2>service() 수행</h2>");
	 * System.out.println("service() 실행"); }
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("<h2>doGet() 수행</h2>");
		System.out.println("doGet() 실행");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("<h2>doPost() 수행</h2>");
		System.out.println("doPost() 실행");
	}
}
