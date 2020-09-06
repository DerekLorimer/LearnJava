package com.dev;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.database.Person;

public class PersonDAO implements PersonDBLocal {

	private EntityManager em;

	private PersonDAOWork work;

	public void setWork(PersonDAOWork work) {
		this.work = work;
	}
	
	public static Connection connection;

	public void init() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

		em = emf.createEntityManager();

		work = new PersonDAOWork();
	}

	@Override
	public List<Person> getPerson() {
		// TODO Auto-generated method stub

		Query query = em.createQuery("SELECT person from Person person");
		List<Person> people = query.getResultList();

		return people;
	}

	public void readPerson() throws SQLException {

		Session session = em.unwrap(Session.class);
		
		
	
		session.doWork(new org.hibernate.jdbc.Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				// do whatever you need to do with the connection
				PersonDAO.connection = connection;
				System.out.println("do whatever you need to do with the connection");
				Statement stmt = connection.createStatement();
				String sql;
				sql = "SELECT name From Person";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
			}
		});

		session.doWork(work);
		
		execute(this.connection);
		
		
	}

	private void execute(Connection connection) throws SQLException {
		System.out.println("Execute - do whatever you need to do with the connection");
		Statement stmt = connection.createStatement();
		String sql;
		sql = "SELECT name, age From Person";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.print(" age ");
			System.out.println(rs.getInt("age")); 
		}
	}

	

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
