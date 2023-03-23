package Customer;

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

	JTextField idTxt;;
	JTextField userTxt;
	JTextField passTxt;

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
		JLabel editformlabel = new JLabel("Edit Customer");
		editformlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel idLabel = new JLabel("ID");
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");


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
		userTxt = new JTextField(15);
		passTxt = new JTextField(10);
	

		// create control buttons.
		editBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(editformlabel);
		pane.add(idLabel);
		pane.add(userLabel);
		pane.add(passLabel);
		
		// add text fields
		pane.add(idTxt);
		pane.add(userTxt);
		pane.add(passTxt);
		
		// add control buttons
		pane.add(editBtn);
		pane.add(cancelBtn);
		pane.add(Refresh);
		
		// set sizes and positions for labels
		Dimension size = editformlabel.getPreferredSize();
		editformlabel.setBounds(298, 21, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(64, 69, size.width, size.height);
		size = userLabel.getPreferredSize();
		userLabel.setBounds(27, 101, size.width, size.height);
		size = passLabel.getPreferredSize();
		passLabel.setBounds(29, 126, size.width, size.height);
		size = Refresh.getPreferredSize();
		Refresh.setBounds(195, 214, size.width, size.height);

		
		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(99, 66, 166, 20);
		size = userTxt.getPreferredSize();
		userTxt.setBounds(99, 96, 166, 20);
		size = passTxt.getPreferredSize();
		passTxt.setBounds(99, 126, 166, 20);

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
				String user = userTxt.getText();
				String pass = passTxt.getText();
				Customer DBcustommer = new Customer(id,user, pass);
				System.out.println("custommer:" + DBcustommer.toString());
				editCustomer(DBcustommer);
				
				// reset text fields
				idTxt.setText(null);
				userTxt.setText(null);
				passTxt.setText(null);
				
			} catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
			ShowData();
			// user presses "Cancel"
		} else if (actionCommand.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}
		ShowData();
	}
	private void editCustomer(Customer customer) {
		System.out.println("customerDB.editCustomer()");
		try {
			String updateSql = "UPDATE customer SET username='" + customer.user + "', password='" + 
					customer.pass + "' WHERE ID=" + customer.id;
			System.out.println("updateSql:" + updateSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("customer updated successfully.");
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
        model.addColumn("Username");
        model.addColumn("Password");



        try {
            String query = "SELECT * FROM customer";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                });
            }
            rs.close();
            st.close();
            con.close();

            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(40);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(120);



        } catch (Exception e) {
            System.out.println("error: " + e);
        }
	}
}
