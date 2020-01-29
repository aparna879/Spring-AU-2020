package com.springau.springmvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.springau.springmvc.exceptions.EmployeeNotFoundException;
import com.springau.springmvc.model.Employee;

public interface DAO {
	
	public void save(Employee employee) throws EmployeeNotFoundException, SQLException;
	public void update(Employee employee) throws EmployeeNotFoundException, SQLException;
	public void deleteById(int id) throws EmployeeNotFoundException, SQLException;
	public List<Employee> getAll() throws SQLException;
}
