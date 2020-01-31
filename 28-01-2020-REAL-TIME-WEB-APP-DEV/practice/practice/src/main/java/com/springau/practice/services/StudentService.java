package com.springau.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springau.practice.dao.StudentDAO;
import com.springau.practice.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	public List<Student> getallStudent() {
		return studentDAO.getallStudent();
	}

	public List<Student> addstudent(Student studentobj) {
		return studentDAO.addstudent(studentobj);
	}
}
