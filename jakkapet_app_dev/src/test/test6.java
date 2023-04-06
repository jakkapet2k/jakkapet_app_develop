package test;

public class test6 {
	
public static void main(String [] args) {
	Object[][] rows = {
		    {1, "2023-04-05", "12:34:56", "John Doe", "Product A", 3, 680},
		    {2, "2023-04-06", "10:11:12", "Jane Smith", "Product B", 5, 932},
		    {3, "2023-04-07", "14:15:16", "Bob Johnson", "Product C", 2, 621},
		    {4, "2023-04-08", "16:17:18", "Alice Lee", "Product D", 1, 384}
		};

		double sum = 0.0;

		for (int i = 0; i < rows.length; i++) {
		    sum += (double) rows[i];
		}

		System.out.println("Total: " + sum);


}

}
