package com.dev;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Stateless
@LocalBean
public class HibernateSession implements HibernateSessionLocal {
	
	SessionFactory factory;
	Session session;
	
	public HibernateSession() {
		
		System.out.println("injected constructor HibernateSession");
		
		  
	    factory = new Configuration().configure().buildSessionFactory();
	    
	     session = factory.openSession();
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return session;
	}

}
