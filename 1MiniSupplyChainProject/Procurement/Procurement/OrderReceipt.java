package Procurement;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class OrderReceipt extends JDialog implements ActionListener{

	private static final int width = 400;
	private static final int height = 200;
	
	JTextField idTxt;
	JTextField supplierTxt;
	JTextField goodsTxt;
	JTextField quantityTxt;
	JTextField orderdateTxt;
	
	private static final String orderString = "Order";
	private static final String  cancelString = "cancel";
	private static final String RefreshString = "Refresh";
	
	private JTable table;
	private JScrollPane scrollPane;

	public OrderReceipt(JFrame frame) {
		super(frame, true);
		setTitle("Add");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
			public void windowActivated(WindowEvent e) {
				ShowData();
			}
		});
		
		// Create pane as container
		Container pane = getContentPane();
		// set layout manager to manual
		pane.setLayout(null);
		
		// create labels
		JLabel Orderformlabel = new JLabel("Order");
		Orderformlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLabel idLabel = new JLabel("ID");
		JLabel supplierLabel = new JLabel("Supplier");
		JLabel goodsLabel = new JLabel("Goods");
		JLabel quantityLabel = new JLabel("Quantity");
		JLabel orderdateLabel = new JLabel("orderdate");
		
		
		//create buttons
		JButton addBtn = new JButton(orderString);
		addBtn.setForeground(new Color(34, 139, 34));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setForeground(new Color(0, 0, 0));
		JButton Refresh = new JButton(RefreshString);
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ShowData();				
			}
		});
		Refresh.setForeground(Color.BLUE);
		
		// create texts
		idTxt = new JTextField(10);
		supplierTxt = new JTextField(20);
		goodsTxt = new JTextField(15);
		quantityTxt = new JTextField(10);
		orderdateTxt = new JTextField(10);
		
		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		// add labels
		pane.add(Orderformlabel);
		pane.add(idLabel);
		pane.add(supplierLabel);
		pane.add(goodsLabel);
		pane.add(quantityLabel);
		pane.add(orderdateLabel);
		
		// add text fields
		pane.add(idTxt);
		pane.add(supplierTxt);
		pane.add(goodsTxt);
		pane.add(quantityTxt);
		pane.add(orderdateTxt);
		
		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);
		pane.add(Refresh);
		
		// set sizes and positions for labels
		Dimension size = Orderformlabel.getPreferredSize();
		Orderformlabel.setBounds(277,11, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(29, 66, size.width, size.height);
		size = supplierLabel.getPreferredSize();
		supplierLabel.setBounds(29, 96, size.width, size.height);
		size = goodsLabel.getPreferredSize();
		goodsLabel.setBounds(29, 126, size.width, size.height);
		size = quantityLabel.getPreferredSize();
		quantityLabel.setBounds(29, 156, size.width, size.height);
		size = orderdateLabel.getPreferredSize();
		orderdateLabel.setBounds(29, 186, size.width, size.height);
		Refresh.setBounds(299, 244, 89, 23);
		
		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(99, 66, 166, 20);
		size = supplierTxt.getPreferredSize();
		supplierTxt.setBounds(99, 96, 166, 20);
		size = goodsTxt.getPreferredSize();
		goodsTxt.setBounds(99, 126, 166, 20);
		size = quantityTxt.getPreferredSize();
		quantityTxt.setBounds(99, 156, 166, 20);
		size = orderdateTxt.getPreferredSize();
		orderdateTxt.setBounds(99, 186, 166, 20);
		
		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(99, 217, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(160, 217, size.width, size.height);
		
		// set size and position for container
		pane.setPreferredSize(new Dimension(700, 300));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 66, 360, 174);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblY = new JLabel("*2022-10-15");
		lblY.setForeground(Color.RED);
		lblY.setBounds(25, 199, 77, 14);
		getContentPane().add(lblY);
		

		
		
	
	
		
		pack();
		setLocationRelativeTo(null);
		setVisible(false);

		System.out.println("AddformDialog() done!");

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String actionCommand = evt.getActionCommand();
		// user presses "Add"
		if(actionCommand.equals(orderString)) {
			System.out.println("actionCommand:" + orderString);
			try {
				// retrieve values from text fields.
				String idgood = idTxt.getText();
				String supplier = supplierTxt.getText();
				String goods = goodsTxt.getText();
				int quantity = Integer.parseInt(quantityTxt.getText());
				String orderdate = orderdateTxt.getText();
				Order DBorder = new Order(idgood, supplier, goods, quantity, orderdate);
				System.out.println("order:" + DBorder.toString());
				addsOrder(DBorder);
				
				// reset text fields
				idTxt.setText(null);
				supplierTxt.setText(null);
				goodsTxt.setText(null);
				quantityTxt.setText(null);
				orderdateTxt.setText(null);
				
			}catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
		// user presses "Cancel"
		}else if (actionCommand.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}
		
		ShowData();
	}
	private void addsOrder(Order order) {
		System.out.println("orderDB.addsOrder()");
		try {
			String insertSql = "INSERT INTO order_goods VALUES" + "(NULL,'" + order.idgoods + "', '" + order.supplier + "', '" + order.goods + "', " + order.quantity + ", '"  + order.orderdate + "'"+",'0')";
			System.out.println("selectSql:" + insertSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();	
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("supplier added successfully.");
			}
		}catch (NumberFormatException ex) {
			System.err.println("Error! Invalid id.");
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	private void ShowData() {
        ConnMariaDB connDB = new ConnMariaDB();
        Connection con = connDB.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Goods ID");
        model.addColumn("Supplier");
        model.addColumn("Goods");
        model.addColumn("Quantity");
        model.addColumn("Order Date");
        model.addColumn("Receive Date");

        try {
            String query = "SELECT * FROM order_goods";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[] {
                		rs.getString("id"),
                        rs.getString("id_goods"),
                        rs.getString("supplier"),
                        rs.getString("goods"),
                        rs.getString("quantity"),
                        rs.getString("order_date"),
                        rs.getString("receive_date")
                });
            }
            rs.close();
            st.close();
            con.close();

            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(40);
            table.getColumnModel().getColumn(1).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(120);
            table.getColumnModel().getColumn(3).setPreferredWidth(80);
            table.getColumnModel().getColumn(4).setPreferredWidth(80);
            table.getColumnModel().getColumn(5).setPreferredWidth(60);


        } catch (Exception e) {
            System.out.println("error: " + e);
        }
	}
}
