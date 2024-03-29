package com.lec.ch05.quiz;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("DEV? RUN?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("DEV")) {
			config = "dev";	
		}else if(answer.equalsIgnoreCase("RUN")) {
			config = "run";
		}else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다. 확인요망");
			System.exit(0); 
		}
		sc.close();
		// 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		String loc1 = "classpath:META-INF/quiz/dev.xml";
		String loc2 = "classpath:META-INF/quiz/run.xml";
		ctx.load(loc1, loc2);
		ctx.refresh();
		EnvInfo envInfo = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("ipNum = " + envInfo.getIpNum());
		System.out.println("portNum = " + envInfo.getPortNum());
		System.out.println("userId = " + envInfo.getUserId());
		System.out.println("pw = " + envInfo.getPw());
		ctx.close();
		
	}
}
