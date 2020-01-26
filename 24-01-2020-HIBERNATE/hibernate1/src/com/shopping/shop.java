package com.shopping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class shop {
	
	@OneToMany
	@JoinTable(name="SHOP_CUSTOMERS", joinColumns=@JoinColumn(name="SHOP_ID"),inverseJoinColumns=@JoinColumn(name="CUSTOMER_ID"))
	private List<customer> customers = new LinkedList<>();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id", column =@Column(name="ITEM_ID")),
		@AttributeOverride(name="name", column =@Column(name="ITEM_NAME"))
	})
	private static List<item> items = new LinkedList<>();
	
	@Id
	private int shop_id;
	
	public void addtocart(customer c, item itm) {

		if(customer.getMycart()!=null) customer.getMycart().addItem(itm);
		else {
			List<item> list = new ArrayList<item>();
			list.add(itm);
			cart mycart = new cart();
			mycart.setMyItems(list);
			customer.setMycart(mycart);
		}
		shop.send(itm);
	}
	
	public void remove(item itm, customer c) {
		customer.getMycart().removeItem(itm);
	}
	
	public void placeOrder(customer user) {
		if(user.getMyorder()!=null) {
			user.getMyorder().PlaceOrder(user, customer.getMycart());
		}	
	}
	
	public void cancelOrder(customer user) {
		user.getMyorder().cancelOrder(this, user, customer.getMycart());
	}
	
	public List<customer> getCustomers() {
		return customers;
	}
	
	public static void receive(item i) {
		items.add(i);
	}
	
	public static void send(item i) {
		items.remove(i);
	}

	public void setCustomers(List<customer> customers) {
		this.customers = customers;
	}

	public List<item> getItems() {
		return items;
	}

	public void setItems(List<item> items) {
		shop.items = items;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	
}
