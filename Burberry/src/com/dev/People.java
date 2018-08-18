package com.dev;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.database.Person;

@Stateless(name="PeopleService")
@LocalBean
public class People implements PeopleLocal {

  //  @PersistenceContext(unitName = "test")    
  //  private EntityManagerFactory entityManagerFactory;

   
    public List<Person> getPerson() {
    	
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    		
    	
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT m from Person as m");
        
        List<Person> results = query.getResultList();
        
        entityManager.close();
        
         return results;
    }
}