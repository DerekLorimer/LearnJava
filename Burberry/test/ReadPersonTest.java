import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.database.Person;
import com.dev.PersonDAO;
import com.dev.PersonDAOWork;

public class ReadPersonTest {

	@Ignore
	@Test
	public void test() {

		PersonDAO dao = new PersonDAO();

		EntityManager em = Mockito.mock(EntityManager.class);
		Query query = Mockito.mock(Query.class);

		Mockito.when(em.createQuery("SELECT person from Person person")).thenReturn(query);

		List<Person> people = new ArrayList<Person>();

		Person p = new Person();
		p.setName("Derek");
		people.add(p);

		Mockito.when(query.getResultList()).thenReturn(people);

		dao.setEm(em);

		dao.getPerson().forEach(person -> {
			System.out.println(person.getName());
		});
	}

	@Test
	public void readPerson() throws SQLException {

		PersonDAO dao = new PersonDAO();

		EntityManager em = Mockito.mock(EntityManager.class);
		Session session = Mockito.mock(Session.class);
		
	//	ResultSet rs = Mockito.mock(ResultSet.class);
		
		ResultSet rs = MockResultSet.create(
		           new String[] { "name" }, //columns
		           new Object[][] { // data
		             { "Alice" },
		             { "Bob"},
		             { "Charles" }
		           });

		
		Statement statement = Mockito.mock(Statement.class);

		Query query = Mockito.mock(Query.class);
		
		Connection cn = Mockito.mock(Connection.class);
		Mockito.when(em.unwrap(Connection.class)).thenReturn(cn);

		Mockito.when(em.unwrap(Session.class)).thenReturn(session);
		
		Mockito.when(cn.createStatement()).thenReturn(statement);
		
		Mockito.when(statement.executeQuery(Matchers.anyString())).thenReturn(rs);
		
		dao.connection = cn;
		
		
		PersonDAOWork work = new PersonDAOWork();

	//	doNothing().when(session).doWork(Matchers.anyObject());
/*
		doAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) {
				 Object[] args = invocation.getArguments();
				// Mock mock = (Mock) invocation.getMock();
			//	 PersonDAO callback = (PersonDAO) invocation.getArguments()[0];
			    //    session.doWork(work);
			      
				
				System.out.println("Answer...");
				return null;
			}
		}).when(session).doWork(Matchers.anyObject());
		*/
		
		//Mockito.when(session).doWork(Matchers.anyObject()).thenCallRealMethod();

		// Mockito.when(em.createQuery("SELECT person from Person
		// person")).thenReturn(query);

		// List<Person> people = new ArrayList<Person>();

		// Person p = new Person();
		// p.setName("Derek");
		// people.add(p);

		// Mockito.when(query.getResultList()).thenReturn(people);

		dao.setEm(em);
		dao.setWork(work);

		dao.readPerson();

	}

}
