package com.lec.ch05.ex1;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class AdminTestMain {
	public static void main(String[] args) {
		// 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// 속성 : ConfigurableEnvironment - Environment에 상속받음
		ConfigurableEnvironment env =  ctx.getEnvironment();
		// env의 속성과 속성값으로 되어있는 PS들 가져오기
		MutablePropertySources propertiesSources =  env.getPropertySources();
		// PS들 뒤에 admin.properties의 내용을 추가
		String resourceLocation = "classpath:META-INF/ex1/admin.properties";
		try {
			propertiesSources.addLast(new ResourcePropertySource(resourceLocation));
		} catch (IOException e) {
			// 파일이 없으면 예외 처리
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id : " + env.getProperty("admin.id"));
		System.out.println("admin.pw : " + env.getProperty("admin.pw"));
		
		// bean 생성(admin)을 위해 xml 파싱하고 객체생성
		ctx.load("classpath:META-INF/ex1/CTX.xml");
		ctx.refresh();
		
		// admin bean 사용
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println("adminId : " + admin.getAdminId());
		System.out.println("adminPw : " + admin.getAdminPw());
		System.out.println("env : " + admin.getEnv());
		ctx.close();
	}
}
