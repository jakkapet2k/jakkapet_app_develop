package Memberlist;

public class Item {
	public String id;
	public String name;

	

	public Item (String name ,String id) {
		this.id = id;
		this.name = name;
//		System.err.print("Name : "+name+", ID : "+id+"\n");
	}


	public String getName() {
		return name;
	}
	public String getid() {
		return id;
	}
}

