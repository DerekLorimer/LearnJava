package Serialize;



import java.io.Serializable;

public class Employee implements Show {
	
	void Show() {
		
		if (this instanceof Employee) System.out.println("Employee available..");
		
		if (this instanceof Serializable) System.out.println("Serializable available..");
		
		if (this instanceof Show) System.out.println("Show available..");
	}

}
