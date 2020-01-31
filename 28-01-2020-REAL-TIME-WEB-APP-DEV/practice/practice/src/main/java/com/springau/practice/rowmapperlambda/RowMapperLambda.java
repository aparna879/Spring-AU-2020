package com.springau.practice.rowmapperlambda;

import org.springframework.jdbc.core.RowMapper;

import com.springau.practice.model.Student;

public class RowMapperLambda {

	private RowMapperLambda() {}
	public static final RowMapper<Student> studentRowMapperLambda = (rs,rownum) -> {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setBranch(rs.getString("branch"));
		return student;	
	};
}
