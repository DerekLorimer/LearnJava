package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  List<Integer> randomNumbers = new ArrayList<>();
		    for (int i = 0; i < 10; i++) {
		        Integer number = RandomNumbers.getNext();
		        randomNumbers.add(number);
		    }
		 
		    System.out.println(randomNumbers);
		    
		    Supplier<Integer> supplier = () -> RandomNumbers.getNext();
		    
		    System.out.println(supplier.get());
		    
		     randomNumbers = Stream
		            .generate(supplier)
		            .filter( number -> number > 5)
		            .limit(10)
		            .collect(Collectors.toList());
		     
		        System.out.println(randomNumbers);
	}

}


class RandomNumbers {
    public static Integer getNext() {
        return new Random().nextInt(10);
    }
}