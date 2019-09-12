package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Laptop> laps = new ArrayList<>();
		
		laps.add(new Laptop("dell",16,800));
		laps.add(new Laptop("apple",8,1200));
		laps.add(new Laptop("acer",12,700));
		laps.add(new Laptop("apple",16,2000));
		
		// Using Anonymous Inner Class
		
		Comparator<Laptop> compare = new Comparator<Laptop>()
		{

			@Override
			public int compare(Laptop o1, Laptop o2) {
				// TODO Auto-generated method stub
				return o1.getPrice() > o2.getPrice() ? 1 :-1;
			}
			
		};
		
		Test test = new Test();
		
		Collections.sort(laps,compare);
		
		laps.forEach(lap -> {
			System.out.println(lap.toString());
		});
		
		Phone p = new Phone()
		{

			@Override
			public void show() {
				System.out.println("Phone");
				
			}
			
			
			
		};
		
		p.show();
		
		MyPhone mp = new MyPhone();
		mp.show();
		
		

	}
	
	
	
	

}

interface Phone {
	public void show();
}

class MyPhone implements Phone {

	@Override
	public void show() {
		System.out.println("MyPhone");
		
	}
	
}

class Test implements Comparator<Laptop>
{

	@Override
	public  int compare(Laptop o1, Laptop o2) {
		// TODO Auto-generated method stub
		return o1.getPrice() > o2.getPrice() ? 1 :-1;
	}
	
}
