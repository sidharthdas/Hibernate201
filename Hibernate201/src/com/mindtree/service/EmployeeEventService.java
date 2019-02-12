package com.mindtree.service;

import java.util.ArrayList;

import org.hibernate.Query;

import com.mindtree.exception.DAOException;
import com.mindtree.model.Employees;
import com.mindtree.model.Events;
import com.mindtree.util.HibernateConfig;

public class EmployeeEventService {

	HibernateConfig config = new HibernateConfig();

	public String employeeMIDFromDB(String MID) {
		config.getSession().beginTransaction();
		String empMID = config.getSession().createQuery("SELECT MID FROM EMPLOYEES WHERE MID = ?").setParameter(0, MID)
				.list().toString();
		return empMID;
	}

	public String eventTileFromDB(String eventTitle) {
		config.getSession().beginTransaction();
		String eveTitle = config.getSession().createQuery("SELECT EVENT_TITLE FROM EVENTS WHERE EVENT_TITLE = ?")
				.setParameter(0, eventTitle).list().toString();
		return eveTitle;

	}

	public Boolean checkEmployee(String MID) throws DAOException {
		String empName = employeeMIDFromDB(MID);
		if (empName.equals("[]")) {
			throw new DAOException("Name not found");
		}
		return true;

	}

	public Boolean checkEvent(String EVENT_TITLE) throws DAOException {
		String eveTitle = eventTileFromDB(EVENT_TITLE);
		if (eveTitle.equals("[]")) {
			throw new DAOException("Event not found");
		}
		return true;

	}

	public Boolean checkEmployeesEvent(String MID, String EVENT_TITLE) {
		config.getSession().beginTransaction();
		String EVENT_ID = config.getSession().createQuery("SELECT EVENT_ID FROM EVENTS WHERE EVENT_TITLE = ?")
				.setParameter(0, EVENT_TITLE).list().toString();
		int eveID = Integer.parseInt(EVENT_ID.substring(1, EVENT_ID.length() - 1));
		String employee_events = config.getSession()
				.createSQLQuery(
						"SELECT employees_MID FROM EMPLOYEES_EVENTS WHERE employees_MID = ? AND events_EVENT_ID = ?")
				.setParameter(0, MID).setParameter(1, eveID).list().toString();
		System.out.println("employee_events : " + employee_events);
		if (employee_events.equals("[]")) {
			return true;
		}

		return false;
	}

	public String registerEmployeeForEvent(String MID, String EVENT_TITLE) {
		try {
			Boolean name = checkEmployee(MID);
			Boolean event = checkEvent(EVENT_TITLE);

			if (name.equals(true) && event.equals(true)) {
				Boolean employeesEvents = checkEmployeesEvent(MID, EVENT_TITLE);
				if (employeesEvents) {
					config.getSession().beginTransaction();
					ArrayList<Employees> emp = (ArrayList<Employees>) config.getSession().createQuery("FROM EMPLOYEES WHERE MID = ?")
							.setParameter(0, MID).list();

					ArrayList<Events> eve = (ArrayList<Events>) config.getSession().createQuery("FROM EVENTS WHERE EVENT_TITLE = ?")
							.setParameter(0, EVENT_TITLE).list();
					Employees empp = emp.get(0);
					System.out.println(empp.getEMAIL_ID());
					System.out.println(empp.getMID());
					Events evee = eve.get(0);
					empp.getEvents().add(evee);
					evee.getEmployees().add(empp);
					config.getSession().update(empp);
					config.getSession().update(evee);
					config.getSession().getTransaction().commit();

					/*
					 * String EVENT_ID = config.getSession()
					 * .createQuery("SELECT EVENT_ID FROM EVENTS WHERE EVENT_TITLE = ?")
					 * .setParameter(0, EVENT_TITLE).list().toString(); int eveID =
					 * Integer.parseInt(EVENT_ID.substring(1, EVENT_ID.length() - 1));
					 * System.out.println(eveID); Query qu= config.getSession()
					 * .createSQLQuery("INSERT INTO employees_events(employees_MID,events_EVENT_ID) VALUES (?,?)"
					 * ) .setParameter(0, MID).setParameter(1, eveID); int res = qu.executeUpdate();
					 */
					return "Event tagged to Employee with MID: "+MID+" sucessfully.";
				}
			}
		} catch (DAOException ee) {
			System.out.println(ee.getMessage());
		}

		return "Could'nt Add" ;

	}

}
