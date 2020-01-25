package com.springau.springass2.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Point {
	
	//@Value("${X}")
	private int x;
	
	//@Value("${Y}")
	private int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw() {
		System.out.println("Value of x:"+x+" "+"Value of y:"+y);
	}
}