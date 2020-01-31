package com.springau.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springau.practice.model.Student;
import com.springau.practice.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@GetMapping("/view")
	public List<Student> view() {
		return studentservice.getallStudent();
	}
	
	@PostMapping("/form")
	public List<Student> form(@RequestBody Student studentObj){
		return studentservice.addstudent(studentObj);
	}
}
