package Goods;

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
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JComboBox;

import Main.DAO;
import Main.Main;
import Procurement.Check;

import java.awt.SystemColor;

public class GoodsAdd extends JPanel implements ActionListener {
	public static final String Refresh_STR = "Refresh";

	private static final String cancelString = "cancel";
	private static final String ADD_STR = "Add";
	private static final String goods = "SELECT goods,id FROM pcm WHERE s_ag = 0 ";
	static int id;
	private static JTable table;
	private JTextField priceField;
	private JTextField stockField;
	int categoryId, typeId, modelId;
	String goodName;
	DefaultTableModel model;
	Main main;
	JComboBox<CatagoryItem> catagoryCB, typeCB, modelsqlCB;
	DefaultTableModel tableModel;
	private JTextField NameField;

	DAO dao = new DAO();

	public GoodsAdd(Main main) {

		JLabel label = new JLabel("Add Goods");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(293, 45, label.getPreferredSize().width, label.getPreferredSize().height);
		add(label);
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 212, 586, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

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

		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(130, 147, 165, 20);
		add(priceField);

		stockField = new JTextField();
		stockField.setColumns(10);
		stockField.setBounds(464, 148, 165, 20);
		add(stockField);

		NameField = new JTextField();
		NameField.setBounds(464, 115, 165, 20);
		add(NameField);

		JLabel lbPrice = new JLabel("Unit Price");
		lbPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPrice.setBounds(43, 153, 77, 14);
		add(lbPrice);

		JLabel lbStock = new JLabel("Stock");
		lbStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbStock.setBounds(377, 154, 63, 14);
		add(lbStock);

		JButton BtnAdd = new JButton(ADD_STR);
		BtnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		BtnAdd.setForeground(new Color(34, 139, 34));
		BtnAdd.setBounds(182, 178, 89, 23);
		add(BtnAdd);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(282, 178, 89, 23);
		add(btnCancle);

		catagoryCB = new JComboBox<>();
		catagoryCB.setBounds(130, 81, 165, 22);
		add(catagoryCB);

		DAO.ComboBoxGoodsLv1(catagoryCB);

		CatagoryItem selected = (CatagoryItem) catagoryCB.getSelectedItem();
		int categoryId = selected.getid();
		id = categoryId;
		catagoryCB.setSelectedIndex(-1);

		typeCB = new JComboBox<>();
		typeCB.setBounds(464, 82, 165, 22);
		add(typeCB);

		modelsqlCB = new JComboBox<>();
		modelsqlCB.setBounds(130, 114, 165, 22);
		add(modelsqlCB);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(375, 113, 65, 20);
		add(lblName);

		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModel.setBounds(43, 113, 77, 20);
		add(lblModel);

		JLabel lbType = new JLabel("Type");
		lbType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbType.setBounds(377, 81, 77, 20);
		add(lbType);

		JLabel lbCatagory = new JLabel("Catagory ");
		lbCatagory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbCatagory.setBounds(43, 85, 82, 20);
		add(lbCatagory);

		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(381, 178, 115, 23);
		add(btnRefresh);

		BtnAdd.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);
		catagoryCB.addActionListener(this);
		typeCB.addActionListener(this);
		modelsqlCB.addActionListener(this);

	}

	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		try {

			if (source == catagoryCB) {
				// Handle changes to the "catagoryCB" JComboBox
				CatagoryItem selected = (CatagoryItem) catagoryCB.getSelectedItem();
				categoryId = selected.getid();

				id = categoryId;

				// Refresh the "typeCB" JComboBox
				typeCB.removeAllItems();
				DAO.ComboBoxGoodsLv2(typeCB, id);

			} else if (source == typeCB) {
				// Handle changes to the "typeCB" JComboBox

				CatagoryItem selectedType = (CatagoryItem) typeCB.getSelectedItem();
				typeId = selectedType.getid();

				id = typeId;

				modelsqlCB.removeAllItems();
				DAO.ComboBoxGoodsLv3(modelsqlCB, id);
			} else if (source == modelsqlCB) {

				CatagoryItem selectedMedel = (CatagoryItem) modelsqlCB.getSelectedItem();
				modelId = selectedMedel.getid();

			} else if (command.equals(ADD_STR)) {
				System.out.println("actionCommand:" + ADD_STR);
				try {
					// retrieve values from text fields.
					int lv3 = modelId;
					int lv2 = typeId;
					int lv1 = categoryId;
					String name = NameField.getText();
					int unp = Integer.parseInt(priceField.getText());
					int stc = Integer.parseInt(stockField.getText());
					Goods Add = new Goods(0, lv3, lv2, lv1, name, unp, stc);
					System.out.println("goods:" + Add.toString());
					DAO.addGoods(Add);
					// reset text fields
//				NameField.setText(null);
					catagoryCB.setSelectedIndex(-1);
					typeCB.setSelectedIndex(-1);
					modelsqlCB.setSelectedIndex(-1);
					priceField.setText(null);
					stockField.setText(null);
					NameField.setText(null);

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
			} else if (command.equals(Refresh_STR)) {

				tableModel.setRowCount(0);
				DAO.showTableGoods(tableModel);
				table.setModel(tableModel);

			}

			System.out.println("--------------Start------------------");
			System.out.println("ConsoleLog Lavel1: " + categoryId);
			System.out.println("ConsoleLog Lavel2: " + typeId);
			System.out.println("ConsoleLog Lavel3: " + modelId);
			System.out.println("ConsoleLog Lavel3: " + goodName);
			System.out.println("---------------END-----------------");
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());

		}

	}

}
