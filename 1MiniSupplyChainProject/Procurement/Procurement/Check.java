package Procurement;

public class Check {
	int id ;
	String receivedate;
	public Check(	int id , String receivedate) {
		this.id = id;
		this.receivedate=receivedate;
	}
	
	public String toString() {
		return "id:" + id +", receivedate:" + receivedate ;
	}
}
