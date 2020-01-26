package com.shopping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		item i1 = new item();
		i1.setId(1);
		i1.setName("Bread");
		i1.setPrice(50);
		
		item i2 = new item();
		i2.setId(2);
		i2.setName("Jam");
		i2.setPrice(100);
		
		item i3 = new item();
		i3.setId(3);
		i3.setName("Butter");
		i3.setPrice(30);
		
		item i4 = new item();
		i4.setId(4);
		i4.setName("Chocolate");
		i4.setPrice(200);
		
		customer c1 = new customer();
		c1.setId(1);
		c1.setName("Aparna");
		
		customer c2 = new customer();
		c2.setId(2);
		c2.setName("Tanzy");
		
		List<item> itemlist = new ArrayList<item>();
		itemlist.add(i1);
		itemlist.add(i2);
		itemlist.add(i3);
		itemlist.add(i4);
		
		List<customer> customerlist = new ArrayList<customer>();
		customerlist.add(c1);
		customerlist.add(c2);
		
		shop s = new shop();
		s.setShop_id(10);
		s.setCustomers(customerlist);
		s.setItems(itemlist);
		
		s.addtocart(c1, i4);
		s.addtocart(c1, i3);
		s.addtocart(c2, i2);
		s.addtocart(c2, i1);
		s.remove(i3, c1);
		s.placeOrder(c2);
		s.placeOrder(c2);
		
		order o = new order();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(i1);
		session.save(i2);
		session.save(i3);
		session.save(i4);
		session.save(c1);
		session.save(c2);
		session.save(s);
		session.save(o);
		session.getTransaction().commit();
		session.close();
		System.out.println("DONE!!");
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		System.out.println(".................HQL Query..................."); //HQL QUERY
		List<item> res1 = session2.createQuery("from item", item.class).getResultList();
		for(item i: res1) {
			System.out.println("  Name : "+i.getName()+" Price: "+item.getPrice());
		}
		
		List<customer> res2 = session2.createQuery("from customer", customer.class).getResultList();
		for(customer u: res2) {
			System.out.println(u.getName());
		}
		
		
		System.out.println(".............NAMED Query..................."); //NAMED QUERY
		Query query1 = session2.getNamedQuery("GET_ALL_ITEMS");
		List<item> res3 = query1.getResultList();
		for(item itm: res3) {
			System.out.println(itm.getName());
		}
		
		System.out.println(".................Named Native Query....................."); //Named Native Query
		Query query2 = session2.getNamedNativeQuery("DISPLAY_ALL_CUSTOMERS");
		List res4 = query2.getResultList();
		for(Object name: res4) {
			System.out.println(name);
		}		

	}

}
