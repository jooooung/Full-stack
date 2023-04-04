package com.lec.ch03.method3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.Student;

public class Method3TestMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/Method3_apploctionCTX.xml");
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student1);
		System.out.println(student2);
		ctx.close();
	}
}
