package com.lec.ch03.method2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.lec.ch03.Student;

public class Method2TestMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx 
		= new AnnotationConfigApplicationContext(Method2_applicationConfig.class, Method2_applicationConfig2.class);
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student1);
		System.out.println(student2);
		ctx.close();
	}
}
