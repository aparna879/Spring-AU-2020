package Inventory;

import java.util.LinkedList;
import java.util.List;

public class Manage {
	public static List<Integer> invt=new LinkedList<Integer>();
	
	public static void main(String args[])
	{
		Thread prod1=new Thread(new Producer(),"producer1");
		
		for(int i=0;i<3;i++) {
			
			new Thread(new Producer(),("producer"+String.valueOf(i))).start();
		}
		
		for(int i=0;i<3;i++){

			new Thread(new Customer(),("customer"+String.valueOf(i))).start();
		}

	}

}
