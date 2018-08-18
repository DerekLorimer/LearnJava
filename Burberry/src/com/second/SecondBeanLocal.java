package com.second;

import javax.ejb.Local;

@Local
public interface SecondBeanLocal {
	
	public void doSomething();
	
    public String message();

}
