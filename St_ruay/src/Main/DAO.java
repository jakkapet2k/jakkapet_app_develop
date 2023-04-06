package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;



public class DAO {

	// -------------------------------------------------Goods-------------------------------------------------------------------//
	public static void addGoods(Goods goods) {
	
		try {
			String insertSql = "INSERT INTO goods  (lv3, lv2, lv1, name, unit_price, stocks)  VALUES" + "(" + goods.lv3 + "," + goods.lv2 + "," + goods.lv1+ ",'"+goods.name+"',"+goods.unit_price+","+goods.stocks+")";
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
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	

	public static void showTableGoods(DefaultTableModel tableModel) {

		try {

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			String query = "SELECT goods.id,c_l1.nameL1,c_l2.nameL2,c_l3.nameL3,goods.name,goods.unit_price,goods.stocks FROM goods LEFT JOIN c_l1 ON goods.lv1=c_l1.id LEFT JOIN c_l2 ON goods.lv2=c_l2.id LEFT JOIN c_l3 ON goods.lv3=c_l3.id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				String id = rs.getString("id");
				String lv3 = rs.getString("nameL3");
				String lv2 = rs.getString("nameL2");
				String lv1 = rs.getString("nameL1");
				String name = rs.getString("name");
				String unp = rs.getString("unit_price");
				String sto = rs.getString("stocks");

//				System.out.format("%s, %s, %s, %s, %s, %s\n", id, lv1, lv2, lv3, name, unp, sto);

				Object[] row = { id, lv1, lv2, lv3, name, unp, sto };

				tableModel.addRow(row);
			}
			st.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}
	
	

	
	
	
	
}
