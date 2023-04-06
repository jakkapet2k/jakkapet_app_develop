package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;



public class DAO {
	
	public static void ComboBoxVL1 (JComboBox<CatagoryItem> comboBox, int id) {
		try {

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM c_l1 ");

			while (rs.next()) {

				CatagoryItem item = new CatagoryItem(rs.getString("name"),rs.getInt("id"));
				comboBox.addItem(item);
				System.err.println(item); 
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	public static void ComboBoxVL2 (JComboBox<CatagoryItem> comboBox, int id) {
		try {

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM c_l2 WHERE lv1='" + id + "'");

			while (rs.next()) {

				CatagoryItem item = new CatagoryItem(rs.getString("name"),rs.getInt("id"));
				comboBox.addItem(item);
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	public static void ComboBoxVL3 (JComboBox<CatagoryItem> comboBox, int id) {
		try {

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM c_l3 WHERE lv2='" + id + "'");

			while (rs.next()) {

				CatagoryItem item = new CatagoryItem(rs.getString("name"),rs.getInt("id"));
				comboBox.addItem(item);
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

}
