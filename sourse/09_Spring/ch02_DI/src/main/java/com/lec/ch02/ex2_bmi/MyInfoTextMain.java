package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyInfoTextMain {
	public static void main(String[] args) {
		String resource1 = "classpath:applicationCTX2_m.xml";
		String resource2 = "classpath:applicationCTX2_f.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resource1, resource2);
		MyInfo man = ctx.getBean("man", MyInfo.class);
		MyInfo woman = ctx.getBean("woman", MyInfo.class);
		man.infoPrint();
		woman.infoPrint();
		ctx.close();
	}
}
