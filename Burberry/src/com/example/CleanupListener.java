package com.example;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CleanupListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
        // enter cleanup code here
    	System.out.println("CleanupListener.contextDestroyed");
    	
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=Staging";
    	Driver driver;
		try {
			driver = DriverManager.getDriver(url);
			DriverManager.deregisterDriver(driver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    public void contextInitialized(ServletContextEvent arg0) { }
}