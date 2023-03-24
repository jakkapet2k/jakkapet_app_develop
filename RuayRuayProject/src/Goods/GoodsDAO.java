package Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;



public class GoodsDAO {

	public void addGoods(Goods goods) {
		System.out.println("Add Goods");
		
		try {
			String insertSql = "INSERT INTO goods VALUES" + "(" + goods.id + ", '" + goods.name + "', '" + goods.Description 
					+ "', '" + goods.stock + "', '" + goods.price + "')";
			System.out.println("insertSql:" + insertSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Goods added successfully.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	public void editGoods(Goods goods) {
		System.out.println("Edit Goods");
		
		try {
			String updateSql = "UPDATE goods SET name = '"+goods.name+"', description='"
		    +goods.Description+"',stock='"+goods.stock+"',unit_price="+goods.price+"' WHERE id_goods = "+goods.id;
			System.out.println("updateSql:" + updateSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Goods updated successfully.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	public void deleteCar(int id) {
		System.out.println("Delete goods");
		try {
			String deleteSql = "DELETE FROM goods WHERE id_goods=" + id;
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
	
	
	
}
