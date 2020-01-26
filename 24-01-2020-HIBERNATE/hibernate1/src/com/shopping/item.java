package com.shopping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name="GET_ALL_ITEMS", query="from item")})
public class item {
	
	@Id
	private int id;
	private String name;
	private static int price;
	
	public int getId() {
		return id;
	}
	public static int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		item.price = price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
