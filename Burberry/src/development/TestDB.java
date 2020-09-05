package development;

import com.dev.HibernateSession;
import com.dev.PersonDB;

public class TestDB {
	
	public static void main(String[] args) {
		
		System.out.println("Read Database...");
		
		PersonDB db = new PersonDB();
		
		HibernateSession session = new HibernateSession();
		
		db.setHibernateSession(session);
		
		db.getPerson().forEach(person -> {
			System.out.println(person.getName());
		});

	}
}
