package com.springau.springass1.models;

import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;

public class StudentManager {
		
		private Map<Integer, StudentName> map;

		StudentManager(HashMap<Integer,StudentName> map){
			this.map=map;
		}
		
		public void show() {
			for(Entry<Integer,StudentName> entry : map.entrySet() ) {
				System.out.println(entry);
				//System.out.println(entry.getKey()+"-->"+ entry.getValue());
			}
		}	
}
