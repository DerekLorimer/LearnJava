package generic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer aInt[] = {1,2,3};
		
		List<Integer> aList = fromIntegerArrayToList(aInt);
		
		aList.forEach(item -> System.out.println(item));
		
		String aStr[] = {"Derek","Hugo","Sophie","Catherine"};
		
		fromArrayToList(aStr).forEach(item -> System.out.println(item));
		
		

	}
	
	public static <T> List<T> fromArrayToList(T[] a) {   

		return Arrays.stream(a).collect(Collectors.toList());
	}
	
	public static List<Integer> fromIntegerArrayToList(Integer[] a) {
		return Arrays.stream(a).collect(Collectors.toList());
	}

}
