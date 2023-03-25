package test;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Goods.ConnMariaDB;

// create a users class
class Goods {

	private int id;
	private int lv3;
	private int lv2;
	private int lv1;
	private String name;
	private int unit_price;
	private int stocks;

	public Goods(int id, int lv3, int lv2, int lv1, String name, int unit_price, int stocks) {
		this.id = id;
		this.lv3 = lv3;
		this.lv2 = lv2;
		this.lv1 = lv1;
		this.name = name;
		this.unit_price = unit_price;
		this.stocks = stocks;

	}

	public int getId() {
		return this.id;
	}

	public int getLv3() {
		return this.lv3;
	}

	public int getLv2() {
		return this.lv2;
	}

	public int getLv1() {
		return this.lv1;
	}

	public String getName() {
		return this.name;
	}

	public int getUnitprice() {
		return this.unit_price;
	}

	public int getStocks() {
		return this.stocks;
	}
}

public class test2 extends JFrame {

	public test2() {

		super("Bind JTable From MySQL DataBase");

		setLocationRelativeTo(null);

		setSize(600, 400);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	// create a function to fill the an arraylist from database

	static ArrayList<Goods> getGoods() {

		ArrayList<Goods> users = new ArrayList<Goods>();

		ConnMariaDB connDB = new ConnMariaDB();
		Connection con = connDB.getConnection();

		Statement st;

		ResultSet rs;

		Goods goods;

		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM goods");

			while (rs.next()) {

				goods = new Goods(
						rs.getInt("id"), 
						rs.getInt("lv3"), 
						rs.getInt("lv2"), 
						rs.getInt("lv1"),
						rs.getString("name"), 
						rs.getInt("unit_price"), 
						rs.getInt("stocks")
						);

				users.add(goods);
			}

		} catch (SQLException ex) {
			Logger.getLogger(test2.class.getName()).log(Level.SEVERE, null, ex);
		}

		return users;
	}

	public static void main(String[] args) {

		/*
		 * now we are gonna create and populate a jtable from the arraylist who is
		 * populated from mysql database
		 */

		JTable table = new JTable();

		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[7];

		columnsName[0] = "id";
		columnsName[1] = "lv3";
		columnsName[2] = "lv2";
		columnsName[3] = "lv1";
		columnsName[4] = "name";
		columnsName[5] = "unit_price";
		columnsName[6] = "stocks";

		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[7];

		for (int i = 0; i < getGoods().size(); i++) {

			rowData[0] = getGoods().get(i).getId();
			rowData[1] = getGoods().get(i).getLv3();
			rowData[2] = getGoods().get(i).getLv2();
			rowData[3] = getGoods().get(i).getLv1();
			rowData[4] = getGoods().get(i).getName();
			rowData[5] = getGoods().get(i).getUnitprice();
			rowData[6] = getGoods().get(i).getStocks();

			model.addRow(rowData);
		}

		table.setModel(model);

//        System.out.println(getUsers().size());

		test2 window = new test2();

		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());

		JScrollPane pane = new JScrollPane(table);

		panel.add(pane, BorderLayout.CENTER);

		window.setContentPane(panel);
	}
}