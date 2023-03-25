package Goods;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class GoodsDAO {

	private static final String[] COLUMN_NAMES = { "ID", "C_Lv.1", "C_Lv.2", "C_Lv.3", "Name", "Unit Price" };
	private static JTable table;

//	public void addGoods(Goods goods) {
//		System.out.println("Add Goods");
//
//		try {
//			String insertSql = "INSERT INTO goods VALUES" + "(" + goods.id + ", '" + goods.name + "', '"
//					+ goods.Description + "', '" + goods.stock + "', '" + goods.price + "')";
//			System.out.println("insertSql:" + insertSql);
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(insertSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Goods added successfully.");
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//
//	}
//
//	public void editGoods(Goods goods) {
//		System.out.println("Edit Goods");
//
//		try {
//			String updateSql = "UPDATE goods SET name = '" + goods.name + "', description='" + goods.Description
//					+ "',stock='" + goods.stocks + "',unit_price=" + goods.price + "' WHERE id_goods = " + goods.id;
//			System.out.println("updateSql:" + updateSql);
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(updateSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Goods updated successfully.");
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//
//	}

	public void deleteCar(int id) {
		System.out.println("Delete goods");
		try {
			String deleteSql = "DELETE FROM goods WHERE id =" + id;
			System.out.println("deleteSql:" + deleteSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(deleteSql);
				stmnt.close();
				con.close();
				System.out.println("Deleted successfully.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	

	public static void showTable( DefaultTableModel tableModel) {
		
		try {
		      // create our mysql database connection
				ConnMariaDB connDB = new ConnMariaDB();
				Connection con = connDB.getConnection();
		      

		      String query = "SELECT  t1.nameL1,t2.nameL2,t3.nameL3,t4.name,t4.id ,t4.unit_price,t4.stocks FROM goods AS t4 INNER JOIN c_l1 AS t1 ON t4.lv1 = t1.id INNER JOIN c_l2 AS t2 ON t4.lv2 = t2.id INNER JOIN c_l3 AS t3 ON t4.lv3 = t3.id;";
		 
		      Statement st = con.createStatement();
		      
		      ResultSet rs = st.executeQuery(query);
		      
		      while (rs.next())
		      {
  
		    	  String id = rs.getString("id"); 
		    	  String lv3 = rs.getString("nameL3"); 
		    	  String lv2 = rs.getString("nameL2"); 
		    	  String lv1 = rs.getString("nameL1");
		        String name = rs.getString("name"); 
		        String unp = rs.getString("unit_price"); 
		        String sto = rs.getString("stocks");
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s, %s, %s\n", id, lv1, lv2, lv3, name, unp,sto);
		        
	            // create a new row object with the retrieved data
	            Object[] row = {id, lv1, lv2, lv3, name, unp, sto};

	            // add the row to the table model
	            tableModel.addRow(row);
		      }
		      st.close();
		      rs.close();
				
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		

		
		  }
	

	
}



