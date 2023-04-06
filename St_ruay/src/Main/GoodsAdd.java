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
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;

public class GoodsAdd extends JPanel implements ActionListener {
	public static final String Refresh_STR = "Refresh";

	private static final String cancelString = "cancel";
	private static final String ADD_STR = "Add";
	static int id;
	private static JTable table;
	private JTextField priceField , catagoryCB, typeCB, modelsqlCB;;
	private JTextField stockField;
	int categoryId, typeId, modelId;
	String goodName;
	DefaultTableModel model;
	Main main;
	DefaultTableModel tableModel;
	private JTextField NameField;

	DAO dao = new DAO();

	public GoodsAdd(Main main) {

		JLabel label = new JLabel("Add Goods");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(146, 47, label.getPreferredSize().width, label.getPreferredSize().height);
		add(label);
		setPreferredSize(new Dimension(418, 600));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 266, 352, 311);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		String[] columnNames = { "Column1", "Column1", "Column1", "Column1", "Column1", "Column1", "Column1" };
		tableModel = new DefaultTableModel(columnNames, 0);

		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(130, 147, 80, 20);
		add(priceField);

		stockField = new JTextField();
		stockField.setColumns(10);
		stockField.setBounds(271, 147, 137, 20);
		add(stockField);

		NameField = new JTextField();
		NameField.setBounds(271, 114, 137, 20);
		add(NameField);

		JLabel lbPrice = new JLabel("Unit Price");
		lbPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPrice.setBounds(43, 153, 77, 14);
		add(lbPrice);

		JLabel lbStock = new JLabel("Stock");
		lbStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbStock.setBounds(218, 153, 63, 14);
		add(lbStock);

		JButton BtnAdd = new JButton(ADD_STR);
		BtnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		BtnAdd.setForeground(new Color(34, 139, 34));
		BtnAdd.setBounds(46, 233, 89, 23);
		add(BtnAdd);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(146, 233, 89, 23);
		add(btnCancle);

		catagoryCB = new JTextField();
		catagoryCB.setBounds(130, 81, 80, 22);
		add(catagoryCB);

		

		typeCB = new JTextField();
		typeCB.setBounds(271, 81, 137, 22);
		add(typeCB);

		modelsqlCB = new JTextField();
		modelsqlCB.setBounds(130, 114, 80, 22);
		add(modelsqlCB);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(216, 112, 65, 20);
		add(lblName);

		JLabel lblModel = new JLabel("Name");
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModel.setBounds(43, 113, 77, 20);
		add(lblModel);

		JLabel lbType = new JLabel("Name");
		lbType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbType.setBounds(218, 80, 77, 20);
		add(lbType);

		JLabel lbCatagory = new JLabel("Name ");
		lbCatagory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbCatagory.setBounds(43, 85, 82, 20);
		add(lbCatagory);

		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(245, 233, 115, 23);
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

			 if (command.equals(ADD_STR)) {
				System.out.println("actionCommand:" + ADD_STR);
				try {
					// retrieve values from text fields.
					int lv3 = Integer.parseInt(catagoryCB.getText());
					int lv2 =Integer.parseInt(typeCB.getText());;
					int lv1 = Integer.parseInt(modelsqlCB.getText());
					String name = NameField.getText();
					int unp = Integer.parseInt(priceField.getText());
					int stc = Integer.parseInt(stockField.getText());
					Goods Add = new Goods(0, lv3, lv2, lv1, name, unp, stc);
					System.out.println("goods:" + Add.toString());
					DAO.addGoods(Add);
					// reset text fields
//				NameField.setText(null);
					catagoryCB.setText(null);
					typeCB.setText(null);
					modelsqlCB.setText(null);
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
