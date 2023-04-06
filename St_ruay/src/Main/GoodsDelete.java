package Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import java.awt.SystemColor;

public class GoodsDelete extends JPanel implements ActionListener {
	public static final String Refresh_STR = "Refresh";
	private static final String cancelString = "cancel";
	private static final String DeleteString = "Delete";

	private JTable table;
	private JTextField idField;
	DefaultTableModel tableModel;

	public GoodsDelete(Main main) {

		JLabel lblDeleteGoods = new JLabel("Delete Product");
		lblDeleteGoods.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDeleteGoods.setBounds(22, 27, lblDeleteGoods.getPreferredSize().width,
				lblDeleteGoods.getPreferredSize().height);
		add(lblDeleteGoods);
		setPreferredSize(new Dimension(418, 600));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 114, 332, 428);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		

		String[] columnNames = { "Column1", "Column1", "Column1", "Column1", "Column1", "Column1", "Column1" };
		tableModel = new DefaultTableModel(columnNames, 0);


		idField = new JTextField();
		idField.setBounds(122, 65, 189, 20);
		add(idField);
		idField.setColumns(10);

		JLabel lbGoodID = new JLabel("Goods ID");
		lbGoodID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbGoodID.setBounds(32, 63, 80, 21);
		add(lbGoodID);

		JButton btnDelete = new JButton(DeleteString);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setForeground(new Color(165, 42, 42));
		btnDelete.setBounds(200, 29, 89, 23);
		add(btnDelete);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(299, 29, 89, 23);
		add(btnCancle);

		btnDelete.addActionListener(this);
		btnCancle.addActionListener(this);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(10, 553, 113, 23);
		add(btnRefresh);
		
		
		btnRefresh.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancle.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
}
