package com.lec.ch03.method2;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.ch03.Student;
import com.lec.ch03.StudentInfo;

@Configuration
public class Method2_applicationConfig {
	@Bean
	public Student student1() {
		// bean타입   bean이름
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가");
		hobbies.add("마라톤");
		// return할 변수
		Student student = new Student("홍길동", 18, hobbies);
		student.setHeight(172.5);
		student.setWeight(62.5);
		return student;
	}
	@Bean
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudent(student1());
		return studentInfo;
	}
}
