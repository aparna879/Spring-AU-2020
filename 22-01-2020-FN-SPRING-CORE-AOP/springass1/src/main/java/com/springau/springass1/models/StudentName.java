package com.springau.springass1.models;

public class StudentName {
	private String fname;
	private String lname;
	
	StudentName(String firstname, String lastname){
		this.fname=firstname;
		this.lname=lastname;
	}
	
	@Override
	public String toString() {
		return "StudentName [fname=" + fname + ", lname=" + lname + "]";
	}
}
