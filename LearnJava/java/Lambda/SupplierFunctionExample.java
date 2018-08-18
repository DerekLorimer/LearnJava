package Lambda;

//SupplierFunctionExample.java
import java.util.Date;
import java.util.function.Supplier;


public class SupplierFunctionExample {
public static void main(String args[]) {
	//Supplier instance with lambda expression
	Supplier<String> helloStrSupplier = () -> new String("Hello");
	String helloStr = helloStrSupplier.get();
	System.out.println("String in helloStr is->"+helloStr+"<-");
	
	Person p = new Person("fred");
	Person p2 = p.get();
	
	System.out.println(p.toString());
	System.out.println(p2.toString());
	
	Supplier<Person> personSupplier = () ->  new Person("james");
	
	System.out.println(personSupplier.get().toString());
	
	Supplier<Person> ps = Person::new;
	
	System.out.println(ps.get().toString());
	 
	//Supplier instance using method reference to default constructor
	Supplier<String> emptyStrSupplier = String::new;
	String emptyStr = emptyStrSupplier.get();
	System.out.println("String in emptyStr is->"+emptyStr+"<-");
	 
	//Supplier instance using method reference to a static method
	Supplier<Date> dateSupplier= SupplierFunctionExample::getSystemDate;
	Date systemDate = dateSupplier.get();
	System.out.println("systemDate->" + systemDate);
}
public static Date getSystemDate() {
return new Date();
}
}
