package com.derek;

import javax.ejb.Local;

@Local
public interface MyBeanLocal {
	
	public void doSomething();
	
    public String message();

}
