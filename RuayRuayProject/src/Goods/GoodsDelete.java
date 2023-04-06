package Goods;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.DAO;
import Main.Main;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


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
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 66, 640, 306);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row >= 0 ) {
					String id1 = tableModel.getValueAt(row, 0).toString();
					idField.setText(id1);

					
					System.out.println("--------------Start------------------");
					System.out.println("ConsoleLog ID: " + id1);
					System.out.println("---------------END-----------------");
				}
				
			}
			
		});

		String[] columnNames = { "ID", "Catagory", "Type", "Model", "Name", "Unit Price", "Stocks" };
		tableModel = new DefaultTableModel(columnNames, 0);

		DAO.showTableGoods(tableModel);
		table.setModel(tableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(20);
		column1 = table.getColumnModel().getColumn(1);
		column1.setPreferredWidth(50);
		column1 = table.getColumnModel().getColumn(2);
		column1.setPreferredWidth(100);
		column1 = table.getColumnModel().getColumn(3);
		column1.setPreferredWidth(50);
		column1 = table.getColumnModel().getColumn(4);
		column1.setPreferredWidth(250);
		column1 = table.getColumnModel().getColumn(5);
		column1.setPreferredWidth(50);
		column1 = table.getColumnModel().getColumn(6);
		column1.setPreferredWidth(50);

		idField = new JTextField();
		idField.setBounds(275, 29, 189, 20);
		add(idField);
		idField.setColumns(10);

		JLabel lbGoodID = new JLabel("Goods ID");
		lbGoodID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbGoodID.setBounds(185, 30, 80, 21);
		add(lbGoodID);

		JButton btnDelete = new JButton(DeleteString);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setForeground(new Color(165, 42, 42));
		btnDelete.setBounds(474, 27, 89, 23);
		add(btnDelete);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(573, 27, 89, 23);
		add(btnCancle);

		btnDelete.addActionListener(this);
		btnCancle.addActionListener(this);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(22, 383, 113, 23);
		add(btnRefresh);
		
		
		btnRefresh.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancle.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		if (command.equals(DeleteString)) {
			System.out.println("actionCommand:" + DeleteString);
			try {
				int id = 0;
				int idgoods = Integer.parseInt(idField.getText());;

				Goods Delete = new Goods(idgoods, 0, 0, 0, command, 0, 0);
				DAO.DeleteGoods(Delete);

				// reset text fields
				idField.setText(null);

				tableModel.setRowCount(0);
				DAO.showTableGoods(tableModel);
				table.setModel(tableModel);
				
			} catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
			// user presses "Cancel"
		} else if (command.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}else if(command.equals(Refresh_STR)) {
			
			tableModel.setRowCount(0);
			DAO.showTableGoods(tableModel);
			table.setModel(tableModel);
			
			
	}

	}
}
