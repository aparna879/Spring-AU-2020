package com.example.demo;


import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.util.*;

import javax.swing.text.Document;
import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.sun.research.ws.wadl.Response;


@Path("/apis")
public class employee {
	
	//JSONObject jo = "{\"name\": \"John\"}" ;
	static ArrayList<String> arr = new ArrayList<>();
	
	
	@Path("/post/{name1}/{name2}/{name3}")
	@POST
	@Produces("application/json")
	public ArrayList<String> AddingUser(@PathParam("name1") String name1,@PathParam("name2") String name2,@PathParam("name3") String name3) {
		arr.add(name1);
		arr.add(name2);
		arr.add(name3);
		String[] str1 = new String[arr.size()];
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
			str1[i] = arr.get(i);
		}
		return arr;
	}
	
	@Path("/get")
	@GET
	@Produces("application/json")
	public ArrayList<String> getallUsers() {
		return arr;
	}
	
	@Path("/put/{name}")
	@PUT
	@Produces("application/text")
	public String ModifyUserArray(@PathParam("name") String name1) {
		arr.add(name1);
		String str = "Successfully Modified";
		return str;
	}
	
	@Path("/delete/{name}")
	@DELETE
	@Produces("application/text")
	public String DeleteUser(@PathParam("name") String name1) {
		arr.remove(name1);
		String str = "Successfully Deleted";
		return str;
	}
	
	@Path("/put1")
	@PUT
	@Consumes("application/json")
	public String ModifyUserArray2(String name1) {
		arr.add(name1);
		String str = "Successfully Modified";
		return str;
	}
	
	@Path("/put2")
	@PUT
	@Produces("application/text")
	public String ModifyUserArray3() {
		arr.add("ram");
		arr.add("rohit");
		String str = "Successfully Modified";
		return str;
	}
    
	  @HEAD
	  @Produces("application/json")
	  @Path("head/{id}/{id2}")
	  public String getAllBooks(@PathParam("id") String bookId, @PathParam("id") String bookId2){
		  
		  return bookId+bookId2;
	  }

}
	
	
	

	

