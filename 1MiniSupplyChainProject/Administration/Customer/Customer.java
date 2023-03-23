package Customer;

public class Customer {
	int id;
	String user;
	String pass;
	public Customer(int id, String user, String pass) {
		this.id = id;
		this.user = user;
		this.pass = pass;;
	}
	public String toString() {
		return "id:" + id +", user:" + user +", pass:" + pass;
	}
}
