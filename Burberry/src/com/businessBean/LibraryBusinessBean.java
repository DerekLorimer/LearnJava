package com.businessBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.database.Person;
import com.derek.MyBeanLocal;
import com.dev.People;
import com.dev.PeopleLocal;
import com.ejb.LibrarySessionBeanLocal;
import com.second.SecondBeanLocal;
import com.third.ThirdBeanLocal;

@ManagedBean(name="LibraryBusiness")
public class LibraryBusinessBean {
	
	@EJB
	LibrarySessionBeanLocal library;
	
	
	@EJB
	MyBeanLocal myBean;
	
	@EJB 
	SecondBeanLocal secondBean;
	
	@EJB
	ThirdBeanLocal thirdBean;
	

	@EJB(name="PeopleService")
	private PeopleLocal db;
	
	
	

	public String getMyBean() {
		
		
		return myBean.message();
	}
	
	public List<Person> getPerson() {
		return null; //db.getPerson();
	}

	public String getSecondBean() {
		
		
		
		try {
			System.out.println(db.getPerson().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return secondBean.message();
	}
	
	public String getThirdBean() {
		return thirdBean.message();
	}






	public List<String> getLibrary() {
		
		
		// Injector only called when we use the object
		myBean.doSomething();
		
		
		library.getBooks().clear();
		
	    library.addBook("Great Expectations");
	    
	 	
		
		return library.getBooks();
	}
	
	
	

}
