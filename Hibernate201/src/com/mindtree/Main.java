package com.mindtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.model.Employees;
import com.mindtree.model.Events;
import com.mindtree.service.EmployeeEventService;
import com.mindtree.util.HibernateConfig;

public class Main {

	public static void main(String[] args) throws IOException {

		EmployeeEventService ees = new EmployeeEventService();
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		Scanner sc = new Scanner(System.in);
		/*
		 * String result = ees.registerEmployeeForEvent("m1041928", "test2 event");
		 * System.out.println(result);
		 */
		while (true) {
			System.out.println("          Welcome        ");
			System.out.println("Choose Option");
			System.out.println("  1.Register Employee For Event.");
			System.out.println("  2.Display All Employees");
			System.out.println("  3.Bye");
			int a = 0;
			try {
				a = sc.nextInt();
			} catch (Exception ee) {
				System.out.println("Input Should Be An Integer");
			}
			if(a != 0) {
			switch(a) {
			
			case 1:
				System.out.println("Enter MID of the Employee.(ex. MXXXXXXX): ");
				String MID = reader.readLine();
				System.out.println("Enter Event title: ");
				String EVENT_TITLE = reader.readLine();
				//EVENT_TITLE = EVENT_TITLE.concat(" ").concat(sc.next());
				System.out.println(EVENT_TITLE);
				System.out.println(ees.registerEmployeeForEvent(MID, EVENT_TITLE));
				break;
				
			case 2:
				break;
				
			default:
				System.out.println("Please enter 1, 2 or 0");
				break;
			}
			}
			if(a == 0) {
				System.out.println("Bye bye");
				break;
			}

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * // TODO Auto-generated method stub Employees emp = new Employees(); Events
		 * event = new Events();
		 * 
		 * Events event2 = new Events();
		 * 
		 * emp.setMID("m1041928"); emp.setEMAIL_ID("test@gmail.com");
		 * emp.setJOIN_DATE("10/10/20");
		 * 
		 * emp.getEvents().add(event); emp.getEvents().add(event2);
		 * 
		 * event.setEVENT_TITLE("test event"); event.setDESCRIPTION("test description");
		 * event.getEmployees().add(emp);
		 * 
		 * event2.setEVENT_TITLE("test2 event");
		 * event2.setDESCRIPTION("test2 description"); event2.getEmployees().add(emp);
		 * 
		 * HibernateConfig config = new HibernateConfig();
		 * config.getSession().beginTransaction();
		 * 
		 * config.getSession().save(emp); config.getSession().save(event);
		 * config.getSession().save(event2);
		 * 
		 * config.getSession().getTransaction().commit(); config.getSession().close();
		 */

	}

}
