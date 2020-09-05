package development;

public class ClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class cls = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			System.out.println("All good...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
