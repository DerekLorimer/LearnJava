package equality;

public class TestEquality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Equal t = new Equal();
		Equal s = new Equal();
		
		if (t.equals(s)) {
			System.out.println("Strings equal");
			
		}
		
		if ( t == s) {
			System.out.println("Also equal");
		}

	}

}

class Equal {
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
}
