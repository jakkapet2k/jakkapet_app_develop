package week7;

import java.util.*;

class Footballer {
	int id;
	String name, surname, position ;
	int age;
	long price;

	public Footballer(int id, String name, String surname, String position, int age ,long price) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.age = age;
		this.price = price;
	}
	
	public String toString() {
		
		String data = " id:" + id + "\n name:" + name +
				"\n surname:" + surname + "\n position:" + position +
				"\n age:" + age + "\n price:" + price + " M.";
		return data;
		
	}
	
}


public class ArrayListFootballer {
	public static void main(String[] args) {
		// Creating list of Books
		List<Footballer> list = new ArrayList<Footballer>();
		// Creating Books
		Footballer f1 = new Footballer(1, "DAVID", "DE GEA", "GOALKEEPERS", 32, 36);
		Footballer f2 = new Footballer(2, "VICTOR", "LINDELOFVICTOR ", "DEFENDERS", 28, 40);
		Footballer f3 = new Footballer(8, "BRUNO", "DE FERNANDESBRUNO ", "MIDFIELDERS", 28, 60);
		Footballer f4 = new Footballer(9, "ANTHONY", "MARTIALANTHONY ", "FORWARDS", 27, 95);
		// Adding Books to list
		list.add(f1);
		list.add(f2);
		list.add(f3);
		list.add(f4);
		// Traversing list
		for (Footballer b : list) {
			System.out.println("\n players: \n " +"------------\n"+ b.toString());
			//System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}
	}

}



