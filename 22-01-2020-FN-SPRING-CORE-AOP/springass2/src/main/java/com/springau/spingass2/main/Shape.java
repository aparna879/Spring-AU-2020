package com.springau.spingass2.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springau.springass2.config.AppConfig;
import com.springau.springass2.models.Point;

public class Shape {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Point p = context.getBean(Point.class);
		p.draw();
	}

}
