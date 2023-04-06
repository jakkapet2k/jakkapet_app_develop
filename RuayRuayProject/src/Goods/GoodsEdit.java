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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JComboBox;

import Main.DAO;
import Main.Main;
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
		label.setBounds(292, 11,label.getPreferredSize().width,label.getPreferredSize().height);
		add(label);
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 156, 586, 287);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row >= 0 ) {
					String id1 = tableModel.getValueAt(row, 0).toString();
					String name1 = tableModel.getValueAt(row, 4).toString();
					String price1 = tableModel.getValueAt(row, 5).toString();
					String stock1 = tableModel.getValueAt(row, 6).toString();
					IDField.setText(id1);
					NameField.setText(name1);
					priceField.setText(price1);
					stockField.setText(stock1);
					
					System.out.println("--------------Start------------------");
					System.out.println("ConsoleLog ID: " + id1);
					System.out.println("ConsoleLog Name: " + name1);
					System.out.println("ConsoleLog Price: " + price1);
					System.out.println("ConsoleLog Stocks: " + stock1);
					System.out.println("---------------END-----------------");
				}
				
			}
			
		});

		String[] columnNames = {"ID", "Catagory", "Type", "Model", "Name", "Unit Price", "Stocks"};
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
		priceField.setBounds(130, 91, 165, 20);
		add(priceField);
		
		stockField = new JTextField();
		stockField.setColumns(10);
		stockField.setBounds(464, 92, 165, 20);
		add(stockField);
		
		NameField = new JTextField();
		NameField.setBounds(464, 59, 165, 20);
		add(NameField);
		
		JLabel lbPrice = new JLabel("Unit Price");
		lbPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPrice.setBounds(43, 97, 77, 14);
		add(lbPrice);
		
		JLabel lbStock = new JLabel("Stock");
		lbStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbStock.setBounds(377, 98, 63, 14);
		add(lbStock);
		
		JButton BtnAdd = new JButton(Edit_STR);
		BtnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		BtnAdd.setForeground(new Color(34, 139, 34));
		BtnAdd.setBounds(182, 122, 89, 23);
		add(BtnAdd);
		
		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(282, 122, 89, 23);
		add(btnCancle);
		
		

		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(375, 57, 65, 20);
		add(lblName);
		
		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(381, 122, 115, 23);
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
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		try {

			if (command.equals(Edit_STR)) {
				System.out.println("actionCommand:" + Edit_STR);
				try {
					// retrieve values from text fields.
					int id = Integer.parseInt(IDField.getText());
					String name = NameField.getText();
					int unp = Integer.parseInt(priceField.getText());
					int stc = Integer.parseInt(stockField.getText());
					Goods Add = new Goods(id, 0, 0, 0, name, unp, stc);
					System.out.println("goods:" + Add.toString());
					DAO.EditGoods(Add);
					// reset text fields
					IDField.setText(null);
					NameField.setText(null);
					priceField.setText(null);
					stockField.setText(null);

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

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());

		}

	}
}
