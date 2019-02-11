package com.mindtree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.model.Employees;
import com.mindtree.model.Events;
import com.mindtree.util.HibernateConfig;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employees emp = new Employees();
		Events event = new Events();
		
		Events event2 = new Events();

		emp.setMID("m1041928");
		emp.setEMAIL_ID("test@gmail.com");
		emp.setJOIN_DATE("10/10/20");

		emp.getEvents().add(event);
		emp.getEvents().add(event2);

		event.setEVENT_TITLE("test event");
		event.setDESCRIPTION("test description");
		event.getEmployees().add(emp);
		
		event2.setEVENT_TITLE("test2 event");
		event2.setDESCRIPTION("test2 description");
		event2.getEmployees().add(emp);

		HibernateConfig config = new HibernateConfig();
		config.getSession().beginTransaction();

		config.getSession().save(emp);
		config.getSession().save(event);
		config.getSession().save(event2);

		config.getSession().getTransaction().commit();
		config.getSession().close();

		/*
		 * SessionFactory sessionFactory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * sessionFactory.openSession(); session.beginTransaction(); session.save(emp);
		 * session.save(event); session.getTransaction().commit(); session.close();
		 */
		/*
		 * Rachit 9730659337 Harneet 8200707697
		 */
		/*
		 * 20th 17.5k 5400k
		 */

	}

}
