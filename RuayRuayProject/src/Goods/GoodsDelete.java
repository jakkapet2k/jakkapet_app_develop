package Goods;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.Main;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;

public class GoodsDelete extends JPanel  {
	private JTable table;
	private JTextField idField;
	DefaultTableModel tableModel;
	public GoodsDelete(Main main) {
		
		
		JLabel lblDeleteGoods = new JLabel("Delete Product");
		lblDeleteGoods.setFont(new Font("Quark", Font.BOLD, 20));
		lblDeleteGoods.setBounds(34, 30,lblDeleteGoods.getPreferredSize().width,lblDeleteGoods.getPreferredSize().height);
		add(lblDeleteGoods);
		setPreferredSize(new Dimension(900,400));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 70, 834, 306);
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
		
		idField = new JTextField();
		idField.setBounds(481, 32, 189, 20);
		add(idField);
		idField.setColumns(10);
		
		JLabel lbGoodID = new JLabel("Goods ID");
		lbGoodID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbGoodID.setBounds(391, 33, 80, 21);
		add(lbGoodID);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setForeground(new Color(165, 42, 42));
		btnDelete.setBounds(680, 30, 89, 23);
		add(btnDelete);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(779, 30, 89, 23);
		add(btnCancle);

	}
}
