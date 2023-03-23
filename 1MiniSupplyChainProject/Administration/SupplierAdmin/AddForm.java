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
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AddForm extends JDialog implements ActionListener{

	private static final int width = 400;
	private static final int height = 200;
	
	JTextField idTxt;
	JTextField nameTxt;
	JTextField addressTxt;
	JTextField provinceTxt;
	JTextField phoneTxt;
	
	private static final String addString = "Add";
	private static final String  cancelString = "cancel";
	private static final String RefreshString = "Refresh";
	
	private JTable table;
	private JScrollPane scrollPane;

	public AddForm(JFrame frame) {
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
		JLabel addformlabel = new JLabel("Add Supplier");
		addformlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLabel idLabel = new JLabel("ID");
		JLabel nameLabel = new JLabel("Name");
		JLabel addressLabel = new JLabel("address");
		JLabel provinceLabel = new JLabel("province");
		JLabel phoneLabel = new JLabel("phone");
		
		
		//create buttons
		JButton addBtn = new JButton(addString);
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
		nameTxt = new JTextField(20);
		addressTxt = new JTextField(15);
		provinceTxt = new JTextField(10);
		phoneTxt = new JTextField(10);
		
		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		// add labels
		pane.add(addformlabel);
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
		pane.add(addBtn);
		pane.add(cancelBtn);
		pane.add(Refresh);
		
		// set sizes and positions for labels
		Dimension size = addformlabel.getPreferredSize();
		addformlabel.setBounds(277,11, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(29, 66, size.width, size.height);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(29, 96, size.width, size.height);
		size = addressLabel.getPreferredSize();
		addressLabel.setBounds(29, 126, size.width, size.height);
		size = provinceLabel.getPreferredSize();
		provinceLabel.setBounds(29, 156, size.width, size.height);
		size = phoneLabel.getPreferredSize();
		phoneLabel.setBounds(29, 186, size.width, size.height);
		Refresh.setBounds(299, 244, 89, 23);
		
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
		if(actionCommand.equals(addString)) {
			System.out.println("actionCommand:" + addString);
			try {
				// retrieve values from text fields.
				int id = Integer.parseInt(idTxt.getText());
				String name = nameTxt.getText();
				String address = addressTxt.getText();
				String province = provinceTxt.getText();
				String phone = phoneTxt.getText();
				Supplier DBsupplier = new Supplier(id, name, address, province, phone);
				System.out.println("goods:" + DBsupplier.toString());
				addsSupplier(DBsupplier);
				
				// reset text fields
				idTxt.setText(null);
				nameTxt.setText(null);
				addressTxt.setText(null);
				provinceTxt.setText(null);
				phoneTxt.setText(null);
				
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
	private void addsSupplier(Supplier supplier) {
		System.out.println("supplierDB.addsSupplier()");
		try {
			String insertSql = "INSERT INTO supplier VALUES" + "(" + supplier.id + ", '" + supplier.name + "', '" + supplier.address + "', '" + supplier.province + "', '"  + supplier.phone + "')";
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
            table.getColumnModel().getColumn(4).setPreferredWidth(60);


        } catch (Exception e) {
            System.out.println("error: " + e);
        }
	}
}
