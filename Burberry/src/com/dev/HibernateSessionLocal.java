package com.dev;

import javax.ejb.Local;

import org.hibernate.Session;

@Local
public interface HibernateSessionLocal {
	
	
	Session getSession();

}
