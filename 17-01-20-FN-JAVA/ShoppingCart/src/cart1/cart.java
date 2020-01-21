package cart1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class cart extends customer {
	
	public  static List<item> itemarray = new ArrayList<item>();
	public Map <customer, ArrayList> myCart = new HashMap <customer, ArrayList>();
	private customer cust;
	private int bill=0;
	
	public cart(customer user){
		super (user.cust_id, user.cust_name);
		this.cust = user;
	}
	
	public void ViewItems() {
		int cntr = 1;
		for(item i: itemarray) {
			System.out.println(cntr+". "+"Item: Item_id: " +" "+ i.getItemId() +" "+ " Item Name: " +" "+ i.getItemName() +" "+"   Item Price:  " + i.getItemRate());
			cntr++;
		}
		
	}
	
	public item getItemFromList(int id) {
		for(item i: itemarray) {
			if(i.getItemId() == id) return i;
		}
		return null;
	}
	
	public void AddtoCart(item i) {
		customer u = this.cust;
		if(i.isAvail()) {
			int qty = i.getQty();
			i.setQty(qty-1); 
			ArrayList<item> temp = new ArrayList<item>();
			if(myCart.get(u)!=null)temp = myCart.get(u);
			temp.add(i);
			myCart.put(u,temp);
		}
		else {
			System.out.println("ITEM NOT AVAILABLE");
		}
		
	}
	
	public void Cartview() {
		Set s = this.myCart.entrySet();
		Iterator i = s.iterator();
		if(!i.hasNext()) 
			System.out.println("Shopping cart of this user is Empty.");
		while(i.hasNext()) {
			Map.Entry m = (Map.Entry)i.next();
			customer u = (customer)m.getKey();
			ArrayList<item> li = (ArrayList<item>)m.getValue();
			System.out.println("======================================"+this.cust.getcustomerName()+"'s Shopping Cart======================================");
			if(li.size()>0) {
				System.out.println();
				int cnt=1;
				for(item curr_itm:li) {
					System.out.println(cnt+". "+"Item Id: "+curr_itm.getItemId()+" Item name: "+curr_itm.getItemName());
					cnt++;
				}
				System.out.println("---------------------------------------------------------------------------------------------------");
			}
			else {
				System.out.println("Shopping Cart  of User is Empty."); return;
			}
		}
	}
	
	public void RemoveFromCart(item i) {
		customer u = this.cust;
		if(myCart.get(u)!=null) {
			ArrayList<item> temp = new ArrayList<item>();
			temp = myCart.get(u);
			boolean removed_itm =temp.remove(i);
			if(removed_itm) System.out.println(i.getItemName()+" was removed from the Shopping Cart of the user "+u.getcustomerName());
			else System.out.println("Item: "+i+"could not be removed.");
			
		}
		else {
			System.out.println("This user has no items to remove from cart.");
		}
	}
	
	public void placeOrder() {
		int cnt =0 ;
		ArrayList<item> temp = new ArrayList<item>();
		temp = myCart.get(cust);
		if(temp.size()<=0) {
			System.out.println("Cannot Place order. Cart Empty!!");
			return;
		}
		for(item i : temp) {
			bill += i.getItemRate();
		}
		System.out.println("Thakyou! "+this.cust+" for placing the order. Order placed successfully!");
		System.out.println("==========================ORDER DETAILS==========================");
		for(item i:temp) {
			System.out.println(cnt+". "+"Item: Item_id: " +" "+ i.getItemId() +" "+ " Item Name: " +" "+ i.getItemName() +" "+"   Item Price:  " + i.getItemRate());
			cnt++;
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Total Amount Payable : "+bill);
		myCart.remove(cust);
	}
	
	//////NOT WORKING YET............./////////
	public void cancelOrder() {
		ArrayList<item> temp = new ArrayList<item>();
		temp = myCart.get(cust);
		for(item i:temp) {
			for(item j:itemarray) {
				if(i.getItemId() == j.getItemId()) {
					j.setQty(j.getQty()+i.getQty());
				}
			}
		}
		myCart.remove(cust);
		System.out.println("----------------------------ORDER CANCELLED---------------------------");
	}
	

}
