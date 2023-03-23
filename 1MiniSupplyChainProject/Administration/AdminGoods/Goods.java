package AdminGoods;

public class Goods {
	String id;
	String name;
	String Description;
	int price;
	int stock;
	public Goods(String id, String name, String Description, int price, int stock) {
		this.id = id;
		this.name = name;
		this.Description = Description;
		this.price = price;
		this.stock = stock;
	}
	public String toString() {
		return "id:" + id +", name:" + name +", Description:" + Description +", price:" + price +", stock:" + stock;
	}
}
