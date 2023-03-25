package test;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Goods.ConnMariaDB;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Test {

//	private static JTable table;
//    private DefaultTableModel tableModel;
//
//    public void Test() {
//        tableModel = new DefaultTableModel();
//        table = new JTable(tableModel);
//        String[] columnNames = {"ID", "C_Lv.1", "C_Lv.2", "C_Lv.3", "Name", "Unit Price"};
//        tableModel.setColumnIdentifiers(columnNames);
//    	ConnMariaDB connDB = new ConnMariaDB();
//    	Connection conn = connDB.getConnection();
//        try {
//            String sql = "SELECT * FROM goods";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                
//            		int id = rs.getInt("id");
//            		int lv3 = rs.getInt("lv3");
//            		int lv2 = rs.getInt("lv2");
//            		int lv1 = rs.getInt("lv1");		
//            		String name = rs.getString("name");
//            		int unit_price = rs.getInt("unit_price");
//            		int stocks = rs.getInt("stocks");
//                
//                
//                Object[] row = {id, lv3, lv2,lv1,name,unit_price,stocks};
//                tableModel.addRow(row);
//            }
//
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//    	
//    	JFrame frame = new JFrame("Main Window");
//    	//
//    		frame.setPreferredSize(new Dimension(900, 600));
//    		frame.pack();
//    		frame.setVisible(true);
//    		
//    		frame.setBounds(100,100, 600, 300);
//    		
//    		JScrollPane scrollPane = new JScrollPane();
//    		scrollPane.setBounds(300, 66, 360, 174);
//    		frame.getContentPane().add(scrollPane);
//    	
//    		table = new JTable();
//    		scrollPane.setViewportView(table);
//        
//    }
//}

	private static final String[] COLUMN_NAMES = { "ID", "C_Lv.1", "C_Lv.2", "C_Lv.3", "Name", "Unit Price" };
	private static JTable table;

public static void showTable() {

	try {
	      // create our mysql database connection
			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM Goods";
	 
	      // create the java statement
	      Statement st = con.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {

	        
	        
	        int id = rs.getInt("id"); 
	        int lv3 = rs.getInt("lv3"); 
	        int lv2 = rs.getInt("lv2"); 
	        int lv1 = rs.getInt("lv1");
	        String name = rs.getString("name"); 
	        int unp = rs.getInt("unit_price"); 
	        int sto = rs.getInt("stocks");
	        
	        // print the results
	        System.out.format("%s, %s, %s, %s, %s, %s\n", id, lv3, lv2, lv1, name, unp,sto);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }



	public static void main(String[] args) {

		JFrame frame = new JFrame("Main Window");

		frame.setPreferredSize(new Dimension(900, 600));
		frame.pack();
		frame.setVisible(true);

		frame.setBounds(100, 100, 600, 300);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 66, 360, 174);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		showTable();

		System.out.println("Done!");

	}
}
