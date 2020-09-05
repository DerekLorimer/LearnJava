package com.dev;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.database.Person;

@Stateless
@LocalBean
public class PersonDB implements PersonDBLocal {

	public List<Person> person;

	@EJB
	HibernateSessionLocal hibernateSession;

	public void setHibernateSession(HibernateSessionLocal hibernateSession) {
		this.hibernateSession = hibernateSession;
	}

	public PersonDB() {
		System.out.println("injected PersonDB constructor");

	}

	public List<Person> getPerson() {
		System.out.println("getPerson()");

		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();

		Session session = hibernateSession.getSession(); // factory.openSession();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
		Root<Person> root = query.from(Person.class);

		query.select(root);

		return session.createQuery(query).getResultList();

	}

}
