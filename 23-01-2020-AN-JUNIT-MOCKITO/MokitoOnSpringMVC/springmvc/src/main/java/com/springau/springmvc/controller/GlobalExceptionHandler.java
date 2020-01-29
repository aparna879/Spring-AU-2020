package com.springau.springmvc.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.springau.springmvc.exceptions.EmployeeNotFoundException;


public class GlobalExceptionHandler {

private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public void handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		logger.error("IOException handler");	
	}
	
	@ResponseStatus(reason="Employee not found", value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public void handleemployeeNotFound(){
		logger.error("Employee Not found");
	}
}

