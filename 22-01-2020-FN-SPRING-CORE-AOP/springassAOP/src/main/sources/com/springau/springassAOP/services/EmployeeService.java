package com.springau.springassAOP.services;

import java.util.LinkedList;
import java.util.List;

import com.springau.springassAOP.model.Employee;



public class EmployeeService {

	
	public void getALLEmployee(){
		List<Employee> list = new LinkedList<>();
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setEmpName("Aparna");
		e1.setPos("Intern");
		list.add(e1);
		
		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setEmpName("Tanzy");
		e2.setPos("FTE");
		list.add(e2);
		
		Employee e3 = new Employee();
		e3.setEmpId(3);
		e3.setEmpName("Sheenam");
		e1.setPos("Manager");
		list.add(e3);
		
		System.out.println("LIST OF ALL EMPLOYEES");
		
        for(Employee l1: list) {
        	System.out.println(l1);
        }
	}

}