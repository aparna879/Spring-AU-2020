package cart1;

public class customer {
	
	int cust_id;
	String cust_name;
	
	public customer(int id, String name) {
		this.cust_id=id;
		this.cust_name=name;
	}
	
	public int getcustomerId() {
		return cust_id;
	}
	public String getcustomerName() {
		return cust_name;
	}
	public void setcustomerName(String cust_name) {
		this.cust_name = cust_name;
	}
	public void setcustomerId(int id) {
		this.cust_id = id;
	}
}
