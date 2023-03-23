package SupplierAdmin;

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

public class EditForm extends JDialog implements ActionListener {

	private static final int LINE = 0;

	private static final int width = 700;
	private static final int height = 300;

	JTextField idTxt;
	JTextField nameTxt;
	JTextField addressTxt;
	JTextField provinceTxt;
	JTextField phoneTxt;

	private static final String editString = "Edit";
	private static final String cancelString = "cancel";
	private static final String RefreshString = "Refresh";
	private JTable table;

	public EditForm(JFrame frame) {
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
		JLabel editformlabel = new JLabel("Edit Supplier");
		editformlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel idLabel = new JLabel("ID");
		JLabel nameLabel = new JLabel("Name");
		JLabel addressLabel = new JLabel("address");
		JLabel provinceLabel = new JLabel("province");
		JLabel phoneLabel = new JLabel("phone");

		// create buttons
		JButton editBtn = new JButton(editString);
		JButton cancelBtn = new JButton(cancelString);
		JButton Refresh = new JButton(RefreshString);
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowData();
			}
		});


		// create texts
		idTxt = new JTextField(10);
		nameTxt = new JTextField(20);
		addressTxt = new JTextField(15);
		provinceTxt = new JTextField(10);
		phoneTxt = new JTextField(10);

		// create control buttons.
		editBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(editformlabel);
		pane.add(idLabel);
		pane.add(nameLabel);
		pane.add(addressLabel);
		pane.add(provinceLabel);
		pane.add(phoneLabel);
		
		// add text fields
		pane.add(idTxt);
		pane.add(nameTxt);
		pane.add(addressTxt);
		pane.add(provinceTxt);
		pane.add(phoneTxt);
		
		// add control buttons
		pane.add(editBtn);
		pane.add(cancelBtn);
		pane.add(Refresh);
		
		// set sizes and positions for labels
		Dimension size = editformlabel.getPreferredSize();
		editformlabel.setBounds(298, 21, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(10, 63, size.width, size.height);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(10, 93, size.width, size.height);
		size = addressLabel.getPreferredSize();
		addressLabel.setBounds(29, 126, size.width, size.height);
		size = provinceLabel.getPreferredSize();
		provinceLabel.setBounds(29, 156, size.width, size.height);
		size = phoneLabel.getPreferredSize();
		phoneLabel.setBounds(29, 186, size.width, size.height);
		Refresh.setBounds(195, 214, 70, 23);
		

		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(99, 66, 166, 20);
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(99, 96, 166, 20);
		size = addressTxt.getPreferredSize();
		addressTxt.setBounds(99, 126, 166, 20);
		size = provinceTxt.getPreferredSize();
		provinceTxt.setBounds(99, 156, 166, 20);
		size = phoneTxt.getPreferredSize();
		phoneTxt.setBounds(99, 186, 166, 20);

		// set sizes and positions for controls buttons
		size = editBtn.getPreferredSize();
		editBtn.setBounds(60, 214, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(122, 214, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(width, height));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(298, 63, 392, 174);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		




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
		if (actionCommand.equals(editString)) {
			System.out.println("actionCommand:" + editString);
			try {
				// retrieve values from text fields.
				int id = Integer.parseInt(idTxt.getText());
				String name = nameTxt.getText();
				String address = addressTxt.getText();
				String province = provinceTxt.getText();
				String phone = phoneTxt.getText();
				Supplier supplier = new Supplier(id, name, address, province, phone);
				System.out.println("goods:" + supplier.toString());
				editGoods(supplier);
				
				// reset text fields
				idTxt.setText(null);
				nameTxt.setText(null);
				addressTxt.setText(null);
				provinceTxt.setText(null);
				phoneTxt.setText(null);
				
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
	private void editGoods(Supplier goods) {
		System.out.println("GoodsDB.editGoods()");
		try {
			String updateSql = "UPDATE supplier SET name='" + goods.name + "', address='" + 
					goods.address + "', province='" + goods.province + "', phone='" + 
					goods.phone+ "' WHERE ID=" + goods.id;
			System.out.println("updateSql:" + updateSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
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
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Province");
        model.addColumn("Phone");

        try {
            String query = "SELECT * FROM supplier";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("province"),
                        rs.getString("phone")
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
            table.getColumnModel().getColumn(3).setPreferredWidth(60);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);


        } catch (Exception e) {
            System.out.println("error: " + e);
        }
	}
}
