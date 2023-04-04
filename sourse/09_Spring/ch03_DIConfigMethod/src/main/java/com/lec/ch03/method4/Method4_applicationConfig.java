package com.lec.ch03.method4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.lec.ch03.Student;

@Configuration

// java 안에 xml 넣기
@ImportResource("classpath:META-INF/Method4_apploctionCTX.xml")

public class Method4_applicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("영화보기");
		hobbies.add("맛집가기");
		Student student1 = new Student("홍길동", 25, hobbies);
		student1.setHeight(177);
		student1.setWeight(77);
		return student1;
 	}
}
