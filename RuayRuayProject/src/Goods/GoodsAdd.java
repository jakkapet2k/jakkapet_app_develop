package Goods;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.Main;


import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GoodsAdd extends JPanel  {
	
	private static final String ADD_STR = "Add";
	
	
	private static JTable table;
	private JTextField priceField;
	private JTextField stockField;
	
	
	private static final String[] COLUMN_NAMES = { "ID", "C_Lv.1", "C_Lv.2", "C_Lv.3", "Name", "Unit Price" };
	 DefaultTableModel model;
	Main main;

	DefaultTableModel tableModel;
	private JTextField textField;
	public GoodsAdd(Main main) {
		
		
		JLabel label = new JLabel("Add Goods");
		label.setFont(new Font("Quark", Font.BOLD, 20));
		label.setBounds(363, 28,label.getPreferredSize().width,label.getPreferredSize().height);
		add(label);
		setPreferredSize(new Dimension(900,400));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 73, 586, 261);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		String[] columnNames = {"ID", "Catagory", "Type", "Model", "Name", "Unit Price", "Stocks"};
		 tableModel = new DefaultTableModel(columnNames, 0);

		
		GoodsDAO.showTable(tableModel);
		table.setModel(tableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(1);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(2);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(3);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(4);
		column1.setPreferredWidth(300);
		column1 = table.getColumnModel().getColumn(5);
		column1.setPreferredWidth(20);
		column1 = table.getColumnModel().getColumn(6);
		column1.setPreferredWidth(20);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(130, 211, 165, 20);
		add(priceField);
		
		stockField = new JTextField();
		stockField.setColumns(10);
		stockField.setBounds(130, 252, 165, 20);
		add(stockField);
		
		JLabel lbPrice = new JLabel("Unit Price");
		lbPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPrice.setBounds(43, 217, 120, 14);
		add(lbPrice);
		
		JLabel lbStock = new JLabel("Stock");
		lbStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbStock.setBounds(43, 258, 120, 14);
		add(lbStock);
		
		JButton btnNewButton = new JButton(ADD_STR);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setBounds(106, 311, 89, 23);
		add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(206, 311, 89, 23);
		add(btnCancle);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 81, 165, 22);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(130, 114, 165, 22);
		add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(130, 147, 165, 22);
		add(comboBox_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 180, 165, 20);
		add(textField);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(43, 186, 120, 14);
		add(lblName);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModel.setBounds(43, 155, 77, 14);
		add(lblModel);
		
		JLabel lbType = new JLabel("Type");
		lbType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbType.setBounds(43, 122, 77, 14);
		add(lbType);
		
		JLabel lbCatagory = new JLabel("Catagory ");
		lbCatagory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbCatagory.setBounds(43, 85, 82, 14);
		add(lbCatagory);

	}
	
	
	public void actionPerformed(ActionEvent evt) {
		

		
	}
}
