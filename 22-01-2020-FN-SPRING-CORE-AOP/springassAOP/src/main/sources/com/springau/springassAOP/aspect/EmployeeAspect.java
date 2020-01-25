package com.springau.springassAOP.aspect;

import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	
	long time1;
	long time2;
	@Before("execution(* com.springau.springassAOP.services.EmployeeService.getALLEmployee(..))")
	public void logBeforeV2(JoinPoint joinPoint) {
		this.time1 = System.nanoTime();
		System.out.println("Time before Execution: "+this.time1+" nanoseconds");
		
	}
	
	@After("execution(* com.springau.springassAOP.services.EmployeeService.getALLEmployee(..))")
	public void logAfterV2(JoinPoint joinPoint) {
		this.time2 = System.nanoTime();
		System.out.println("Time After Execution: "+this.time2+" nanoseconds");
		System.out.println("Time Taken by method to execute is: "+(this.time2-this.time1)+" nanoseconds");
	}
}





