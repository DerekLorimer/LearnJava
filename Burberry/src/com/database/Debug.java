package com.database;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Target
 *
 */
@Entity
@Table(name="Debug")
public class Debug implements Serializable {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@Column(name="Id")
	private int id;
	
	
	@Column(name="Name")
	private String name;

	
	private static final long serialVersionUID = 1L;

	public Debug() {
		super();
	}
   
}
