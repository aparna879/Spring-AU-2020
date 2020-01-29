package com.springau.springmvc.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.springau.springmvc.exceptions.EmployeeNotFoundException;
import com.springau.springmvc.model.Employee;

public class DAOImplement implements DAO{
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override	
	public void save(Employee employee) throws EmployeeNotFoundException, SQLException {
		String query = "insert into Employee (id, name, role) values (?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{ 
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getRole());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee saved with id="+employee.getId());
			}else throw new EmployeeNotFoundException(employee.getId());
		}finally{
			ps.close();
			con.close();
		}
		
	}
	
	@Override
	public void update(Employee employee) throws EmployeeNotFoundException, SQLException {
		String query = "update Employee set name=?, role=? where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getRole());
			ps.setInt(3, employee.getId());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee updated with id="+employee.getId());
			}else throw new EmployeeNotFoundException(employee.getId());
		}finally{
			ps.close();
			con.close();
		}
	}

	@Override
	public void deleteById(int id) throws EmployeeNotFoundException, SQLException {
		String query = "delete from Employee where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee deleted with id="+id);
			}else throw new EmployeeNotFoundException(id);
		}finally{
			ps.close();
			con.close();
		}
	}

	@Override
	public List<Employee> getAll() throws SQLException {
		String query = "select id, name, role from Employee";
		List<Employee> empList = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setRole(rs.getString("role"));
				empList.add(emp);
			}
		}finally{
			ps.close();
			con.close();
		}
		return empList;
	}
	
}
