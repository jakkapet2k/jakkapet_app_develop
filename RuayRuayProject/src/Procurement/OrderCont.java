package Procurement;

public class OrderCont {
	public int idgoods;
	public int supplier;
	public int gid;
	public int quantity;
	public String orderdate;
	public OrderCont(int idgoods, int supplier, int gid, int quantity, String orderdate) {
		this.idgoods = idgoods;
		this.supplier = supplier;
		this.gid = gid;
		this.quantity = quantity;
		this.orderdate = orderdate;
	}
	public String toString() {
		return "id:" + idgoods +", supplier:" + supplier +", gid:" + gid +", quantity:" + quantity +", orderdate:" + orderdate;
	}
}
