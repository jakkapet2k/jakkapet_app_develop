package Supplier;

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

public class SupplierAdd extends JPanel  {
	private JTable table;
	private JTextField idField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField provinceField;
	private JTextField phoneField;
	
	public SupplierAdd(Main main) {
		
		
		JLabel lblAddSupplier = new JLabel("Add Supplier");
		lblAddSupplier.setFont(new Font("Quark", Font.BOLD, 20));
		lblAddSupplier.setBounds(363, 28,lblAddSupplier.getPreferredSize().width,lblAddSupplier.getPreferredSize().height);
		add(lblAddSupplier);
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
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(173, 133, 189, 20);
		add(nameField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(173, 174, 189, 20);
		add(addressField);
		
		provinceField = new JTextField();
		provinceField.setColumns(10);
		provinceField.setBounds(174, 216, 189, 20);
		add(provinceField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(173, 257, 189, 20);
		add(phoneField);
		
		JLabel id = new JLabel("Supplier ID");
		id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setBounds(43, 95, 120, 14);
		add(id);
		
		JLabel Name = new JLabel(" Name");
		Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		Name.setBounds(43, 134, 120, 14);
		add(Name);
		
		JLabel address = new JLabel("Address");
		address.setFont(new Font("Tahoma", Font.BOLD, 15));
		address.setBounds(43, 175, 120, 14);
		add(address);
		
		JLabel province = new JLabel("Province");
		province.setFont(new Font("Tahoma", Font.BOLD, 15));
		province.setBounds(43, 217, 120, 14);
		add(province);
		
		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Tahoma", Font.BOLD, 15));
		phone.setBounds(43, 258, 120, 14);
		add(phone);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setForeground(new Color(34, 139, 34));
		btnAdd.setBounds(173, 311, 89, 23);
		add(btnAdd);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(273, 311, 89, 23);
		add(btnCancle);

	}
}
