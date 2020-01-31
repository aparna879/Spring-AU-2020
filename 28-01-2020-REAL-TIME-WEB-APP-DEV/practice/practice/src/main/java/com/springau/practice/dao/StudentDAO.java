package com.springau.practice.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.springau.practice.model.Student;
import com.springau.practice.rowmapperlambda.RowMapperLambda;

@Repository
public class StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate1;
	
	List<Student> listStudent = new LinkedList<>();
	
	public List<Student> getallStudent() {
		return  jdbcTemplate.query("select id,name,branch from student",RowMapperLambda.studentRowMapperLambda);
	}

	public List<Student> addstudent(Student studentobj) {
		SqlParameterSource parameters = new MapSqlParameterSource();
		((MapSqlParameterSource) parameters).addValue("id", studentobj.getId());
		((MapSqlParameterSource) parameters).addValue("name", studentobj.getName());
		((MapSqlParameterSource) parameters).addValue("branch", studentobj.getBranch());	
		String query = "insert into student values(:id,:name,:branch)";
		jdbcTemplate1.update(query, parameters);
		return getallStudent();
	}

}
