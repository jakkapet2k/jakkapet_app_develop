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

public class CheckOrder extends JPanel  {
	private JTable table;
	private JTextField idField;
	private JTextField RecDateField;
	
	public CheckOrder(Main main) {
		
		
		JLabel lblDeleteGoods = new JLabel("Check Order");
		lblDeleteGoods.setFont(new Font("Quark", Font.BOLD, 20));
		lblDeleteGoods.setBounds(411, 24,lblDeleteGoods.getPreferredSize().width,lblDeleteGoods.getPreferredSize().height);
		add(lblDeleteGoods);
		setPreferredSize(new Dimension(900,400));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 154, 629, 235);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		idField = new JTextField();
		idField.setBounds(343, 64, 243, 20);
		add(idField);
		idField.setColumns(10);
		
		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbId.setBounds(307, 65, 34, 21);
		add(lbId);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.setBounds(365, 120, 89, 23);
		add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(464, 120, 89, 23);
		add(btnCancle);
		
		RecDateField = new JTextField();
		RecDateField.setColumns(10);
		RecDateField.setBounds(343, 95, 243, 20);
		add(RecDateField);
		
		JLabel lblReceive = new JLabel("Receive Date");
		lblReceive.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReceive.setBounds(223, 96, 118, 21);
		add(lblReceive);
		
		JLabel lbRecDate = new JLabel("*2022-10-15");
		lbRecDate.setForeground(Color.RED);
		lbRecDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbRecDate.setBounds(611, 98, 120, 20);
		add(lbRecDate);

	}
}
