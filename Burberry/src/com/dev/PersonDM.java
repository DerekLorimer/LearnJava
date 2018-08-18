package com.dev;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javax.persistence.Query;

import com.database.Debug;
import com.database.Person;


/**
 * Session Bean implementation class PersonDM
 */

@Stateless
@LocalBean
public class PersonDM implements PersonLocal {
	
	 String test;
		
	 public String getTest() {
		if ( db != null ) {
			try {
				System.out.println("call db.getPerson()");
				
				
				db.getPerson();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Injected PersonDB";
		}
		
		
		 
		return "Testing";
	}

	public void setTest(String test) {
		this.test = test;
	}

	

    @SuppressWarnings("unchecked")
	public List<Person> getPerson() {
    	return db.getPerson();
 		}

	/**
     * Default constructor. 
     */
    public PersonDM() {
        // TODO Auto-generated constructor stub
    }
    
    
	 @EJB
	 private PersonDBLocal db;
	
  

}
