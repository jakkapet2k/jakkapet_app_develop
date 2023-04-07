package com.constructor;


public class OrderCont {
	int row;
	public String supplier;
	public String goods;
	public String qty;
	public String ordate;
	public String ortime;
	public String tp;
	public OrderCont( String supplier, String goods, String qty, String ordate,String ortime,String tp,int row) {
		this.goods = goods;
		this.supplier = supplier;
		this.qty = qty;
		this.ordate = ordate;
		this.ortime=ortime;
		this.tp=tp;
		this.row=row;
	}

	

	public String getsup() {
		return supplier;
	}

	public String getgoods() {
		return goods;
	}
	public String getqty() {
		return qty;
	}

	public String getordate() {
		return ordate;
	}	
	
	public String getortime() {
		return ortime;
	}
	public String gettp() {
		return tp;
	}
	
	public int getfor() {
		int count = 0;
		for (int i = 0; i <= row; i++) {
			count = i;
		}
		return count;
	}


	
}
