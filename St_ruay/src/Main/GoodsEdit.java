package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.SystemColor;

public class GoodsEdit extends JPanel implements ActionListener {

	public static final String Refresh_STR = "Refresh";

	
	static int id;
	private static final String cancelString = "cancel";
	private static final String Edit_STR = "Edit";

	private static JTable table;
	private JTextField priceField;
	private JTextField stockField;
	private JTextField IDField;

	Main main;
	DefaultTableModel tableModel;
	private JTextField NameField;

	DAO dao = new DAO();


	public GoodsEdit(Main main) {

		JLabel label = new JLabel("Edit Goods");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(143, 11,label.getPreferredSize().width,label.getPreferredSize().height);
		add(label);
		setPreferredSize(new Dimension(418, 600));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 268, 294, 287);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		String[] columnNames = { "Column1", "Column1", "Column1", "Column1", "Column1", "Column1", "Column1" };
		 tableModel = new DefaultTableModel(columnNames, 0);

	
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(130, 91, 165, 20);
		add(priceField);
		
		stockField = new JTextField();
		stockField.setColumns(10);
		stockField.setBounds(130, 157, 165, 20);
		add(stockField);
		
		NameField = new JTextField();
		NameField.setBounds(130, 124, 165, 20);
		add(NameField);
		
		JLabel lbPrice = new JLabel("Unit Price");
		lbPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPrice.setBounds(43, 97, 77, 14);
		add(lbPrice);
		
		JLabel lbStock = new JLabel("Stock");
		lbStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbStock.setBounds(43, 163, 63, 14);
		add(lbStock);
		
		JButton BtnAdd = new JButton(Edit_STR);
		BtnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		BtnAdd.setForeground(new Color(34, 139, 34));
		BtnAdd.setBounds(43, 201, 89, 23);
		add(BtnAdd);
		
		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(143, 201, 89, 23);
		add(btnCancle);
		
		

		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(41, 122, 65, 20);
		add(lblName);
		
		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(242, 201, 115, 23);
		add(btnRefresh);
		
		BtnAdd.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);

		
		JLabel lblD = new JLabel("ID");
		lblD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblD.setBounds(43, 59, 65, 20);
		add(lblD);
		
		IDField = new JTextField();
		IDField.setBounds(130, 61, 165, 20);
		add(IDField);

	}

	public void actionPerformed(ActionEvent evt) {
		
	}
}
