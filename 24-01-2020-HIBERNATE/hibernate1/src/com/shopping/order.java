package com.shopping;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="ORDER_DETAILS")
public class order {
	
	@Id
	long order_id;
	int  bill=0;

	@GenericGenerator(name="abc",strategy="sequence")
	@CollectionId(columns= {@Column(name="ITEM_Id")}, generator="abc", type=@Type(type="long"))
	private static Map<Integer,cart> OrderMap = new HashMap<Integer, cart>();

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public static Map<Integer, cart> getAllOrders() {
		return OrderMap;
	}

	public static void setAllOrders(Map<Integer, cart> allOrders) {
		order.OrderMap = allOrders;
	}

	public void PlaceOrder(customer cust, cart mycart) {
		for(Entry<Integer, cart> entry : OrderMap.entrySet()) {
			if(entry.getKey() == cust.getId()) {
				for(item itm : mycart.getMyItems()) {
					entry.getValue().addItem(itm);
					bill += item.getPrice();
				}
				System.out.println("The Order bill is: "+this.bill);
				cust.getMyorder().order_id = (System.nanoTime());
				customer.setMycart(null);
				return;
			}
		}
		customer.setMycart(null);
		OrderMap.put(cust.getId(), mycart);
	}
	
	public void cancelOrder(shop myshop,customer cust, cart mycart) {
		for(Map.Entry<Integer, cart> i: OrderMap.entrySet()) {
			if(i.getKey() == cust.getId()) {
				for(item item : i.getValue().getMyItems()) {
					shop.receive(item);
				}
			}
		}
	}
	

		
	
}	
