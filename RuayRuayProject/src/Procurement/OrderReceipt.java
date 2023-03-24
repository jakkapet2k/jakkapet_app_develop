package Procurement;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.Main;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OrderReceipt extends JPanel  {
	private JTable table;
	private JTextField idField;
	private JTextField supField;
	private JTextField qtyField;
	private JTextField goodsField;
	private JTextField ordateField;
	
	public OrderReceipt(Main main) {
		
		
		JLabel OrderLB = new JLabel("Order");
		OrderLB.setFont(new Font("Quark", Font.BOLD, 20));
		OrderLB.setBounds(363, 28,OrderLB.getPreferredSize().width,OrderLB.getPreferredSize().height);
		add(OrderLB);
		setPreferredSize(new Dimension(900,400));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 73, 518, 261);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		idField = new JTextField();
		idField.setBounds(173, 94, 189, 20);
		add(idField);
		idField.setColumns(10);
		
		supField = new JTextField();
		supField.setColumns(10);
		supField.setBounds(173, 133, 189, 20);
		add(supField);
		
		qtyField = new JTextField();
		qtyField.setColumns(10);
		qtyField.setBounds(173, 216, 189, 20);
		add(qtyField);
		
		goodsField = new JTextField();
		goodsField.setColumns(10);
		goodsField.setBounds(173, 174, 189, 20);
		add(goodsField);
		
		ordateField = new JTextField();
		ordateField.setColumns(10);
		ordateField.setBounds(173, 257, 189, 20);
		add(ordateField);
		
		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbId.setBounds(43, 95, 120, 14);
		add(lbId);
		
		JLabel lblSup = new JLabel("Supplier");
		lblSup.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSup.setBounds(43, 134, 120, 19);
		add(lblSup);
		
		JLabel lbGood = new JLabel("Goods");
		lbGood.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbGood.setBounds(43, 175, 120, 14);
		add(lbGood);
		
		JLabel lbQty = new JLabel("Quantity");
		lbQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbQty.setBounds(43, 217, 120, 19);
		add(lbQty);
		
		JLabel lbOrdate = new JLabel("Orderdate");
		lbOrdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbOrdate.setBounds(43, 258, 120, 19);
		add(lbOrdate);
		
		JButton btnNewButton = new JButton("Order");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setBounds(173, 311, 89, 23);
		add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(273, 311, 89, 23);
		add(btnCancle);
		
		JLabel lbOrdate_1 = new JLabel("*2022-10-15");
		lbOrdate_1.setForeground(new Color(255, 0, 0));
		lbOrdate_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbOrdate_1.setBounds(43, 283, 120, 20);
		add(lbOrdate_1);

	}
}
