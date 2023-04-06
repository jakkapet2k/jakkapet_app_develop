package sql.controllerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.constructor.Goods;
import com.constructor.SaleReport;
import com.constructor.UserLogin;


public class DAOController {

	
	
	public static boolean validate(UserLogin bean) {
		boolean status = false ;
		try {
			System.out.println("userInput : "+bean.user);
			System.out.println("passInput : "+bean.pass);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			String query = "select * from customer where username='" + bean.user + "' and password='" + bean.pass + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				
				rs.getString("username");
				rs.getString("password");
				
				System.out.println("userOutput : "+rs.getString("username"));
				System.out.println("passOutput : "+rs.getString("password"));
				
				if(rs.getString("username")!=null || rs.getString("username")!= null && rs.getString("username")== bean.pass) {
					status = true;
					System.out.println("status : "+status);
				}else {
					status = false;
					System.out.println("status : "+status);
				}
				

			}
		
			st.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	
	
	
	
	
	

	public static List<Goods> getGoods() {
		List<Goods> list = new ArrayList<Goods>();

		try {
			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			;

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"SELECT goods.id,c_l1.nameL1,c_l2.nameL2,c_l3.nameL3,goods.name,goods.unit_price,goods.stocks FROM goods LEFT JOIN c_l1 ON goods.lv1=c_l1.id LEFT JOIN c_l2 ON goods.lv2=c_l2.id LEFT JOIN c_l3 ON goods.lv3=c_l3.id");
			ResultSet rs = ps.executeQuery();

			
			
			
			while (rs.next()) {

				int id = rs.getInt("id");
				String lv3 = rs.getString("nameL3");
				String lv2 = rs.getString("nameL2");
				String lv1 = rs.getString("nameL1");
				String name = rs.getString("name");
				int unp = rs.getInt("unit_price");
				int sto = rs.getInt("stocks");

				Goods g = new Goods(id, lv3, lv2, lv1, name, unp, sto);
				list.add(g);

			}
		} catch (Exception e) {
			System.err.println(e);
		}

		return list;

	}

	public static List<SaleReport> getSalesReport() {
		List<SaleReport> list = new ArrayList<SaleReport>();

		try {
			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			;

			String query = "SELECT trans.id,trans.ordate,trans.time,customer.username,goods.name,goods.unit_price,trans.qty,goods.unit_price*trans.qty AS total_price FROM trans LEFT JOIN customer ON trans.cid=customer.id LEFT JOIN goods ON trans.gid=goods.id ORDER BY trans.ordate ";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				int id = rs.getInt("id");
				String ordate = rs.getString("ordate");
				String time = rs.getString("time");
				String cust = rs.getString("username");
				String name = rs.getString("name");
				String qty = rs.getString("qty");
				String tp = rs.getString("total_price");

				SaleReport sp = new SaleReport(id, ordate, time, cust, name, qty, tp);

				list.add(sp);

			}
		} catch (Exception e) {
			System.err.println(e);
		}

		return list;

	}

	public static void StickGoodsUpdate(Goods goods) {

		try {
			String EditSql = "UPDATE goods,tran SET goods.stocks = goods.stocks - trans.qty WHERE goods.id = pcm.gid ";
			System.out.println("insertSql:" + EditSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(EditSql);
				stmnt.close();
				con.close();
				System.out.println("Goods Edited successfully.");
			}
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

}
