package com.dev;

import java.util.List;

import javax.ejb.Local;

import com.database.Person;

@Local
public interface PeopleLocal {

	public List<Person> getPerson();
}
