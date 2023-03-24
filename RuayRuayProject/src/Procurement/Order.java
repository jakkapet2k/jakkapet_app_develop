package Procurement;

public class Order {
	String idgoods;
	String supplier;
	String goods;
	int quantity;
	String orderdate;
	public Order(String idgoods, String supplier, String goods, int quantity, String orderdate) {
		this.idgoods = idgoods;
		this.supplier = supplier;
		this.goods = goods;
		this.quantity = quantity;
		this.orderdate = orderdate;
	}
	public String toString() {
		return "id:" + idgoods +", supplier:" + supplier +", goods:" + goods +", quantity:" + quantity +", orderdate:" + orderdate;
	}
}
