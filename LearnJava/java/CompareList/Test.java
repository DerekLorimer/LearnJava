package CompareList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Customer> customers = new ArrayList<Customer>();
		
		
		customers.add(new Customer(1,"1- Derek"));
		customers.add(new Customer(2,"2 - Derek"));
		customers.add(new Customer(1,"1 - Alan"));
		customers.add(new Customer(1,"1 - Catherine"));
		customers.add(new Customer(2,"2 - Alan"));
		customers.add(new Customer(3,"3 - John"));
		customers.add(new Customer(4,"4-Fred"));
		
		
		
		
		List<MajorCustomer> majorCustomers = new ArrayList<MajorCustomer>();
		
		HashMap<Integer,Customer> customerMap = new HashMap<Integer,Customer>();
		
		Customer previousCustomer = null;
		
		for ( Customer customer : customers) {
			System.out.println(customer.getName());
			
			int customerSequenceNo = customer.getSequenceNo();
			
			if ( customerMap.containsKey(customerSequenceNo)) {
				previousCustomer = customerMap.get(customerSequenceNo);
			} else {
				previousCustomer = null;
			}
			
			customerMap.put(customerSequenceNo, customer);
			
			majorCustomers.add(new MajorCustomer(customer,previousCustomer));
			
			
			
			
		} 
		
		majorCustomers.forEach(majorCustomer -> {
				System.out.print("CURRENT " + majorCustomer.majorCustomer.getName());
				if ( majorCustomer.previousCustomer != null ) {
					System.out.print("PREVIOUS " + majorCustomer.previousCustomer.getName());
				}
				System.out.println();
	    });
		
		RemmDMTest dm = new RemmDMTest();
		
		dm.setEntityManager("Entity Manager Object");
		
		dm.readDB();
	}

}
