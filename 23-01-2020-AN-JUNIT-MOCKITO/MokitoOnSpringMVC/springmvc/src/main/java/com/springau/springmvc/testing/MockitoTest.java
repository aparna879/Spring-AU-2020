package com.springau.springmvc.testing;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import com.springau.springmvc.dao.DAO;
import com.springau.springmvc.dao.DAOImplement;
import com.springau.springmvc.exceptions.EmployeeNotFoundException;
import com.springau.springmvc.model.Employee;

public class MockitoTest {
	
	@InjectMocks
	DAOImplement daoimplement = new DAOImplement();
	
	@Mock
	DAO  daoservice = Mockito.mock(DAO.class);
	
	@Test
	public void TestSave() throws EmployeeNotFoundException, SQLException {
		
		Mockito.doAnswer(invocation->{
			Employee emp = new Employee();
			emp=(Employee) invocation;
			Assert.notNull(emp);
			System.out.println("Saved Successfully");
			return null;
		}).when(daoservice).save(Mockito.any(Employee.class));
		
	}
	
	@Test
	public void TestUpdate() throws EmployeeNotFoundException, SQLException {
		
		Mockito.doAnswer(invocation->{
			Employee emp = new Employee();
			emp=(Employee) invocation;
			Assert.hasLength(emp.getName(), "Valid String should be added");
			System.out.println("Updated Successfully");
			return null;
		}).when(daoservice).update(Mockito.any(Employee.class));
		
	}
	
	@Test
	public void TestDeleteById() throws EmployeeNotFoundException, SQLException {
		
		Mockito.doAnswer(invocation->{
			Employee emp = new Employee();
			emp=(Employee) invocation;
			Assert.notNull(emp.getId());
			System.out.println("Deleted Successfully");
			return null;
		}).when(daoservice).deleteById(Mockito.any(Integer.class));
		
	}
	
	@Test
	public void TestgetAll() throws EmployeeNotFoundException, SQLException {
		List<Employee> emplist = new LinkedList<>();
		Employee emp1 = new Employee(10,"Tarun","Developer");
		Employee emp2 = new Employee(11,"Amit","Intern");
		emplist.add(emp1);
		emplist.add(emp2);
		Assert.notEmpty(emplist);
	}	
}
