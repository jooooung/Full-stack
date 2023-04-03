package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTestMain {
	public static void main(String[] args) {
//		Calculation cal = new Calculation();
//		cal.setNum1(10);
//		cal.setNum2(5);
		
		// xml을 파싱하여 객체 생성(IOC 컨테이터에)  웹 프로젝트에서는 자동
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");/* xml경로 */
		// IOC 컨테이너에 있는 객체 주입(DI)
		Calculation cal = ctx.getBean("calculation", Calculation.class);
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		ctx.close(); // 웹프로젝트에서는 불필요
	}
}
