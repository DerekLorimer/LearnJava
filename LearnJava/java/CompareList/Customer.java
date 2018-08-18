package CompareList;

public class Customer {
	
	private int sequenceNo;
	private String name;
	
	
	
	public Customer(int sequenceNo, String name) {
		super();
		this.sequenceNo = sequenceNo;
		this.name = name;
	}
	
	public int getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
