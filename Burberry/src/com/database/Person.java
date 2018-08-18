package com.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Proxy;

@Entity
@Table(name="Person")
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	

	
	
	

	@Id
	@Column(name="Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="Age",nullable = true, columnDefinition = "int")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
