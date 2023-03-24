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
import javax.swing.JButton;

public class GoodsAdd extends JPanel  {
	
	private static final String ADD_STR = "Add";
	
	
	public static JTable table;
	private JTextField idField;
	private JTextField descriptionField;
	private JTextField priceField;
	private JTextField nameField;
	private JTextField stockField;
	
	DefaultTableModel model ;
	Main main;
	
	
	public GoodsAdd(Main main) {
		
		
		JLabel label = new JLabel("Add Goods");
		label.setFont(new Font("Quark", Font.BOLD, 20));
		label.setBounds(363, 28,label.getPreferredSize().width,label.getPreferredSize().height);
		add(label);
		setPreferredSize(new Dimension(900,400));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 73, 518, 261);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		model = (DefaultTableModel)table.getModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Description");
		model.addColumn("Stock");
		model.addColumn("Unit Price");
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				GoodsDAO.ShowData();
			}
			@Override
			public void windowActivated(WindowEvent e) {
				GoodsDAO.ShowData();
			}
		});
		
		
		
		idField = new JTextField();
		idField.setBounds(173, 94, 189, 20);
		add(idField);
		idField.setColumns(10);
		
		descriptionField = new JTextField();
		descriptionField.setColumns(10);
		descriptionField.setBounds(173, 174, 189, 20);
		add(descriptionField);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(173, 216, 189, 20);
		add(priceField);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(173, 133, 189, 20);
		add(nameField);
		
		stockField = new JTextField();
		stockField.setColumns(10);
		stockField.setBounds(173, 257, 189, 20);
		add(stockField);
		
		JLabel lbGoodId = new JLabel("Goods ID");
		lbGoodId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbGoodId.setBounds(43, 95, 120, 14);
		add(lbGoodId);
		
		JLabel lblGoodsName = new JLabel("Goods Name");
		lblGoodsName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGoodsName.setBounds(43, 134, 120, 14);
		add(lblGoodsName);
		
		JLabel lbDescripttion = new JLabel("Descripttion");
		lbDescripttion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbDescripttion.setBounds(43, 175, 120, 14);
		add(lbDescripttion);
		
		JLabel lbPrice = new JLabel("Price");
		lbPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPrice.setBounds(43, 217, 120, 14);
		add(lbPrice);
		
		JLabel lbStock = new JLabel("Stock");
		lbStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbStock.setBounds(43, 258, 120, 14);
		add(lbStock);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setBounds(173, 311, 89, 23);
		add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(273, 311, 89, 23);
		add(btnCancle);

	}
	
	
	public void actionPerformed(ActionEvent evt) {
		
		String command = evt.getActionCommand();
		if(command.equals(ADD_STR)) {
			main.viewGoods();
				
		}
		
	}

	public void setForm(ArrayList<Goods> goods) {
		int rows = model.getRowCount();
		for(int i=0; i<rows; i++) {
			model.removeRow(0);
		}
		
		for(Iterator<Goods> it=goods.iterator(); it.hasNext();) {
			Goods good = it.next();
			Vector data = new Vector();
			data.add(String.valueOf(good.id));
			data.add(good.name);
			data.add(good.Description);
			data.add(good.price);
			data.add(good.stock);
			model.addRow(data);
		}
		
	}
}
