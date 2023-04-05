package com.lec.ch06.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TextMain {
	public static void main(String[] args) {
		String loc = "classpath:META-INF/applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);
		
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo(); // 핵심기능 호출
		System.out.println("==============================");
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo();
	}
}
