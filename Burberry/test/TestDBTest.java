import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.junit.Test;
import org.mockito.Mockito;

import com.database.Person;
import com.dev.HibernateSession;
import com.dev.PersonDB;

import junit.framework.TestCase;

public class TestDBTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void test() {
		
		System.out.println("Read database...");
		
		PersonDB db = new PersonDB();
		
		HibernateSession hibernateSession = Mockito.mock(HibernateSession.class);
		Session session = Mockito.mock(Session.class);
		CriteriaBuilder criteriaBuilder = Mockito.mock(CriteriaBuilder.class);
		
		Mockito.when(hibernateSession.getSession()).thenReturn(session);
		Mockito.when(session.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		
		// setup query object //
        ////////////////////////
        final CriteriaQuery<Person> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        Mockito.when(criteriaBuilder.createQuery(Person.class)).thenReturn(criteriaQuery);        
         
        final Root<Person> root = Mockito.mock(Root.class);
        Mockito.when(criteriaQuery.from(Person.class)).thenReturn(root); 
        
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person());
        
        Mockito.when(session.createQuery(criteriaQuery).getResultList()).thenReturn(personList);
       
		
		db.setHibernateSession(hibernateSession);
		
		db.getPerson().forEach(person -> {
			System.out.print("PERSON");
			System.out.println(person.getName());
		});
		
	}

}
