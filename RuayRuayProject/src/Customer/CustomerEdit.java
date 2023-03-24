package Customer;

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

public class CustomerEdit extends JPanel  {
	private JTable table;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField idField;
	
	public CustomerEdit(Main main) {
		
		
		JLabel lblEditCustommer = new JLabel("Edit Customer");
		lblEditCustommer.setFont(new Font("Quark", Font.BOLD, 20));
		lblEditCustommer.setBounds(389, 21,lblEditCustommer.getPreferredSize().width,lblEditCustommer.getPreferredSize().height);
		add(lblEditCustommer);
		setPreferredSize(new Dimension(900,400));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 145, 573, 244);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		usernameField = new JTextField();
		usernameField.setBounds(363, 83, 189, 20);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(363, 114, 189, 20);
		add(passwordField);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbUsername.setBounds(217, 84, 120, 14);
		add(lbUsername);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPassword.setBounds(217, 115, 120, 14);
		add(lbPassword);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEdit.setForeground(new Color(255, 165, 0));
		btnEdit.setBounds(592, 76, 89, 23);
		add(btnEdit);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(592, 111, 89, 23);
		add(btnCancle);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(363, 52, 189, 20);
		add(idField);
		
		JLabel lbUId = new JLabel("ID");
		lbUId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbUId.setBounds(217, 55, 120, 14);
		add(lbUId);

	}
}
