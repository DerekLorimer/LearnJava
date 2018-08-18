package com.dev;

import java.util.List;

import javax.ejb.Local;

import com.database.Person;

@Local
public interface PersonDBLocal {
	
	public List<Person> getPerson();

}
