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

public class CustomerAdd extends JPanel  {
	private JTable table;
	private JTextField usernameField;
	private JTextField passwordField;
	
	public CustomerAdd(Main main) {
		
		
		JLabel lblAddCustommer = new JLabel("Add Customer");
		lblAddCustommer.setFont(new Font("Quark", Font.BOLD, 20));
		lblAddCustommer.setBounds(398, 27,lblAddCustommer.getPreferredSize().width,lblAddCustommer.getPreferredSize().height);
		add(lblAddCustommer);
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setForeground(new Color(34, 139, 34));
		btnAdd.setBounds(592, 76, 89, 23);
		add(btnAdd);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(592, 111, 89, 23);
		add(btnCancle);

	}
}
