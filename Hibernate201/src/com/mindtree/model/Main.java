package com.mindtree.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employees emp = new Employees();
		Events event = new Events();
		emp.setMID("m1041928");
		emp.setEMAIL_ID("test@gmail.com");
		emp.setJOIN_DATE("10/10/20");
		
		emp.getEvents().add(event);
		
		
		
		event.setEVENT_TITLE("test event");
		event.setDESCRIPTION("test description");
		event.getEmployees().add(emp);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp);
		session.save(event);
		session.getTransaction().commit();
		session.close();
		/*
		 * Rachit 9730659337 Harneet 8200707697
		 */
		/*
		 * 20th 17.5k 5400k
		 */
		

	}

}
