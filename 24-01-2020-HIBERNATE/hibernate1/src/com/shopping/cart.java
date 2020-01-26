package com.shopping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Embeddable
public class cart {
	
	@Id
	private customer cust;
	
	@OneToMany
	@JoinTable(name="CUSTOMER_CART", joinColumns=@JoinColumn(name="CUSTOMER_ID"),inverseJoinColumns=@JoinColumn(name="ITEM_ID"))
	private List<item> myItems = new ArrayList<item>();
	
	public void addItem(item itm) {
		this.myItems.add(itm);
	}
	
	public void removeItem(item itm) {
		this.myItems.remove(itm);
	}

	public customer getCust() {
		return cust;
	}

	public void setCust(customer cust) {
		this.cust = cust;
	}

	public List<item> getMyItems() {
		return myItems;
	}

	public void setMyItems(List<item> myItems) {
		this.myItems = myItems;
	}
	
}
