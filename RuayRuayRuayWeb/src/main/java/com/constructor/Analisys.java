package com.constructor;



public class Analisys {
	public 	int id;
	public  String ordate;
	public  String time;
	public  String username;
	public  String name;
	public  String qty;
	public  String tp;

	public Analisys(int id, String ordate, String time, String username, String name, String qty, String tp) {
		this.id = id;
		this.ordate= ordate;
		this.time = time;
		this.username = username;
		this.name = name;
		this.qty = qty;
		this.tp = tp;
	}
	

	public int getid() {
		return id;
	}
	

	public String getordate() {
		return ordate;
	}
	

	public String gettime() {
		return time;
	}
	

	public String getusername() {
		return username;
	}
	

	
	public String getName() {
		return name;
	}
	

	
	public String getqty() {
		return qty;
	}
	

	
	public String gettp() {
		return tp;
	}
	
	public  String toString() {
		return  id+ordate+time+username+name+qty+tp;
	}
	


	public int getfor() {
		int count = 0;
		for(int i =0 ; i<=id; i++) {
			count = i;
		}
		return count;
	}


	
}
