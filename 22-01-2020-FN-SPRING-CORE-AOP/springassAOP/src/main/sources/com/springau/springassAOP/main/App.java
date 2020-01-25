package com.springau.springassAOP.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springau.springassAOP.model.Employee;
import com.springau.springassAOP.services.EmployeeService;

@ComponentScan(basePackages = "com.springau.springassAOP")
public class App {

    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");      
        EmployeeService service = context.getBean(EmployeeService.class);
        service.getALLEmployee();   
    }

}
