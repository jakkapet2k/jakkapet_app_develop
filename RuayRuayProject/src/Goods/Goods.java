package Goods;

public class Goods {
	public int id;
	public int lv3;
	public int lv2;
	public int lv1;
	public String name;
	public int unit_price;
	public int stocks;

	public Goods(int id, int lv3, int lv2, int lv1, String name, int unit_price, int stocks) {
		this.id = id;
		this.lv3= lv3;
		this.lv2 = lv2;
		this.lv1 = lv1;
		this.name = name;
		this.unit_price = unit_price;
		this.stocks = stocks;
	}
	public String toString() {
		return  name;
	}
	public int getid() {
		return id;
	}
	public int getlv1() {
		return lv1;
	}
	public int getlv2() {
		return lv2;
	}
	public int getlv3() {
		return lv3;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return unit_price;
	}
	public int getStocks() {
		return stocks;
	}
}
