package com.shopping;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedNativeQueries({ @NamedNativeQuery(name = "DISPLAY_ALL_CUSTOMERS", query = "select Customer_name from Customer_Details") })
@Table(name="Customer_Details")
public class customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)    //surogate key
	private int id;
	
	@Column(name="Customer_name")
	private String name;
	
	@Embedded
	private static cart mycart;
	
//	@ManyToOne
//	private shop flipkart;
	
	@OneToOne
	@JoinColumn(name="ORDER_ID")
	private order myorder;

	public static cart getMycart() {
		return mycart;
	}

	public static void setMycart(cart mycart) {
		customer.mycart = mycart;
	}

	public order getMyorder() {
		return myorder;
	}

	public void setMyorder(order myorder) {
		this.myorder = myorder;
	}

	public int getId() {
		return id;
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
	
	
}
