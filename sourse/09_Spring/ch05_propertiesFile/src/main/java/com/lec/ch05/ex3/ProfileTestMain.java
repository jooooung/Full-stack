package com.lec.ch05.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileTestMain {
	public static void main(String[] args) {
		String config = null; // 환경변수
		Scanner sc = new Scanner(System.in);
		System.out.println("DEV? RUN?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("DEV")) {
			config = "dev";	// beans의 profile
		}else if(answer.equalsIgnoreCase("RUN")) {
			config = "run";
		}else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다. 확인요망");
			System.exit(0);  // 정상상태에서 강제종료
		}
		sc.close();
		// 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	
		// profile에 따라 xml 파일 활성화
		ctx.getEnvironment().setActiveProfiles(config);
		String loc1 = "classpath:META-INF/ex3/CTX_DEV.xml";
		String loc2 = "classpath:META-INF/ex3/CTX_RUN.xml";
		ctx.load(loc1, loc2);
		ctx.refresh();  // 객체 생성
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("Port : " + info.getPortNum());
		ctx.close();
	}
}
