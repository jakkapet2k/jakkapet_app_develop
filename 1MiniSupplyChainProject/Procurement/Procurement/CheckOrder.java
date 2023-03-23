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
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CheckOrder extends JDialog implements ActionListener {

	private static final int LINE = 0;

	private static final int width = 700;
	private static final int height = 300;

	JTextField idTxt;
	JTextField receivedateTxt;


	private static final String AcceptString = "Accept";
	private static final String cancelString = "cancel";
	private static final String RefreshString = "Refresh";
	private JTable table;
	private JScrollPane scrollPane;

	public CheckOrder(JFrame frame) {
		super(frame, true);
		setTitle("Edit ");
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
		JLabel editformlabel = new JLabel("Check Order");
		editformlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel goodsLabel = new JLabel("ID");
		JLabel receivedateLabel = new JLabel("Receive Date");


		// create buttons
		JButton editBtn = new JButton(AcceptString);
		JButton cancelBtn = new JButton(cancelString);
		JButton Refresh = new JButton(RefreshString);
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowData();
			}
		});


		// create texts
		idTxt = new JTextField(10);
		receivedateTxt = new JTextField(20);



		// create control buttons.
		editBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(editformlabel);
		pane.add(goodsLabel);
		pane.add(receivedateLabel);


		// add text fields
		pane.add(idTxt);
		pane.add(receivedateTxt);


		// add control buttons
		pane.add(editBtn);
		pane.add(cancelBtn);
		pane.add(Refresh);
		
		// set sizes and positions for labels
		Dimension size = editformlabel.getPreferredSize();
		editformlabel.setBounds(207, 28, size.width, size.height);
		size = goodsLabel.getPreferredSize();
		goodsLabel.setBounds(117, 61, size.width, size.height);
		size = receivedateLabel.getPreferredSize();
		receivedateLabel.setBounds(64, 92, size.width, size.height);

		size = Refresh.getPreferredSize();
		Refresh.setBounds(287, 120, size.width, size.height);
		

		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(164, 58, 194, 20);
		size = receivedateTxt.getPreferredSize();
		receivedateTxt.setBounds(164, 89, 194, 20);


		// set sizes and positions for controls buttons
		size = editBtn.getPreferredSize();
		editBtn.setBounds(90, 122, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(189, 122, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(500, 350));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 480, 174);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel receivedateLabel_1 = new JLabel("* 2022-02-22");
		receivedateLabel_1.setForeground(Color.RED);
		receivedateLabel_1.setBounds(368, 92, 84, 14);
		getContentPane().add(receivedateLabel_1);
		




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
		if (actionCommand.equals(AcceptString)) {
			System.out.println("actionCommand:" + AcceptString);
			try {
				// retrieve values from text fields.
				int id = Integer.parseInt(idTxt.getText());
				String receivedate = receivedateTxt.getText();
				Check Check = new Check(id, receivedate);
				System.out.println("Check:" + Check.toString());
				CheckGoods(Check);
				
				// reset text fields
				idTxt.setText(null);
				receivedateTxt.setText(null);

				
			} catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
			// user presses "Cancel"
		} else if (actionCommand.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}
		ShowData();
	}
	private void CheckGoods(Check Check) {
		System.out.println("Check_GoodsDB.CheckGoods()");
		try {
			String updateSql = "UPDATE order_goods SET receive_date='" + Check.receivedate  + "' WHERE id= '"+Check.id+"'";
			
			String updateGoodsSql = "UPDATE goods,order_goods SET goods.stock = goods.stock + order_goods.quantity  "
					+ "WHERE goods.id_goods = order_goods.id_goods AND order_goods.id = '" + Check.id+"' ";
			
			
			System.out.println("updateSql:" + updateSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.executeUpdate(updateGoodsSql);
				stmnt.close();
				con.close();
				System.out.println("Goods updated successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid plate.");
		} catch (SQLException ex) {
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
