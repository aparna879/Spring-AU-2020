package com.springau.springmvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springau.springmvc.dao.DAOImplement;
import com.springau.springmvc.exceptions.EmployeeNotFoundException;
import com.springau.springmvc.model.Employee;

@Controller
public class MainController {
	
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	DAOImplement employeeDAO = ctx.getBean("employeeDAO", DAOImplement.class);

	@RequestMapping("/add")
	public String a1() {
		return "add";
	}
	
	@RequestMapping(value = "/add1", method = RequestMethod.POST)
	public String add(@ModelAttribute("SpringWeb") Employee e , ModelMap model) throws EmployeeNotFoundException, SQLException {
		System.out.println(e);		
		employeeDAO.save(e);
		ctx.close();		
		return "add";
	}
	
	@RequestMapping("/modify")
	public String a2() {
		return "modify";
	}
	
	@RequestMapping(value = "/modify1", method = RequestMethod.POST)
	public String modify(@ModelAttribute("SpringWeb") Employee e , ModelMap model) throws EmployeeNotFoundException, SQLException {
		employeeDAO.update(e);
		ctx.close();		
		System.out.println("MODIFICATION DONE");
		return "modify";
	}
	
	@RequestMapping("/delete")
	public String a3() {
		return "delete";
	}
	
	@RequestMapping(value = "/delete1", method = RequestMethod.POST)
	public String delete(@ModelAttribute("SpringWeb") Employee e , ModelMap model) throws EmployeeNotFoundException, SQLException {
		employeeDAO.deleteById(e.getId());
		ctx.close();		
		return "delete";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public  ModelAndView view(@ModelAttribute("SpringWeb") Employee e) throws SQLException {
		
        ModelAndView model = new ModelAndView("view");
		List<Employee> list = employeeDAO.getAll();
		for(Employee e1 : list) {
			System.out.println(e1);
		}
		model.addObject("emplist", list);
		ctx.close();		
		return model;
	}	
	
}
