package com.second;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MyBean
 */
@Stateless
@LocalBean
public class SecondBean implements SecondBeanLocal {

    /**
     * Default constructor. 
     */
    public SecondBean() {
        // TODO Auto-generated constructor stub
    	System.out.println("injected MyBean Constructor");
    }

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		return "My Second Bean saying hello";
	}

}
