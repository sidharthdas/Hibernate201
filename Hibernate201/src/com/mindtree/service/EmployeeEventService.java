package com.mindtree.service;

import java.util.ArrayList;

import com.mindtree.exception.DAOException;
import com.mindtree.model.Employees;
import com.mindtree.util.HibernateConfig;

public class EmployeeEventService {

	HibernateConfig config = new HibernateConfig();

	public Boolean checkEmployee(String NAME) throws DAOException {
		config.getSession().beginTransaction();
		String empId = config.getSession().createQuery("SELECT empId FROM EMPLOYEES WHERE NAME = ?")
				.setParameter(0, NAME).list().toString();
		if (empId.equals("[]")) {
			throw new DAOException("Name not found");
		}
		return true;

	}

	public Boolean checkEvent(String EVENT_TITLE) throws DAOException {
		String eventId = config.getSession().createQuery("SELECT EVENT_ID FROM EVENTS WHERE EVENT_TITLE = ?")
				.setParameter(0, EVENT_TITLE).list().toString();
		if (eventId.equals("[]")) {
			throw new DAOException("Event not found");
		}
		return true;

	}

	public String registerEmployeeForEvent(String NAME, String EVENT_TITLE) {
		try {
			Boolean name = checkEmployee(NAME);
			Boolean event = checkEmployee(EVENT_TITLE);
			
			if(name.equals(true) && event.equals(true)) {
				
			}
		}catch(DAOException ee) {
			System.out.println(ee.getMessage());
		}
		
		
		return null;

	}

	public ArrayList<Employees> allEmployees() {
		return null;
	}

}
