package com.springau.springass2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.springau.springass2.models.Point;

@Configuration
@ComponentScan(basePackages = "com.*")
public class AppConfig {

    @Autowired
    private Environment env;
    
	@Bean(name="point")
	public Point getPoint() {
		Point p = new Point();	
		p.setX(Integer.parseInt((env.getProperty("X"))));
		p.setY(Integer.parseInt((env.getProperty("Y"))));	
//		System.out.println(p.getX());
//		System.out.println(p.getY());
		return p;
	}
}
