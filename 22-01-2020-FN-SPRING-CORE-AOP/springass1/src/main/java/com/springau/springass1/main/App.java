package com.springau.springass1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springau.springass1.models.StudentManager;

public class App {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		StudentManager s = context.getBean(StudentManager.class);
		s.show();
	}
}
