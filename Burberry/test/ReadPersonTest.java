import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.mockito.Mockito;

import com.database.Person;
import com.dev.PersonDAO;

public class ReadPersonTest {

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

}
