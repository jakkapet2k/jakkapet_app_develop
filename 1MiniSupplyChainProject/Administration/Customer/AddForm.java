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
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AddForm extends JDialog implements ActionListener{

	private static final int width = 400;
	private static final int height = 200;
	

	JTextField userTxt;
	JTextField passTxt;
	
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
		JLabel addformlabel = new JLabel("Add Customer");
		addformlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");

		
		
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
		userTxt = new JTextField(15);
		passTxt = new JTextField(10);
	
		
		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		// add labels
		pane.add(addformlabel);
		pane.add(userLabel);
		pane.add(passLabel);

		
		// add text fields
		pane.add(userTxt);
		pane.add(passTxt);
		
		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);
		pane.add(Refresh);
		
		// set sizes and positions for labels
		Dimension size = addformlabel.getPreferredSize();
		addformlabel.setBounds(277,11, size.width, size.height);
		
		size = userLabel.getPreferredSize();
		userLabel.setBounds(29, 96, size.width, size.height);
		size = passLabel.getPreferredSize();
		passLabel.setBounds(29, 126, size.width, size.height);


		
		// set sizes and positions for labels
		
		size = userTxt.getPreferredSize();
		userTxt.setBounds(99, 96, 166, 20);
		size = passTxt.getPreferredSize();
		passTxt.setBounds(99, 126, 166, 20);

		
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
				int id =0;
				String user = userTxt.getText();
				String pass = passTxt.getText();
			
				Customer DBcustommer = new Customer(id,user, pass);
				System.out.println("custommer:" + DBcustommer.toString());
				addCustommer(DBcustommer);
				
				// reset text fields

				userTxt.setText(null);
				passTxt.setText(null);


				
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
	private void addCustommer(Customer customer) {
		System.out.println("custommerDB.addCustommer()");
		try {
			String insertSql = "INSERT INTO customer VALUES" + "(NULL, '" + customer.user + "', '" + customer.pass + "')";
			System.out.println("selectSql:" + insertSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();	
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("customer added successfully.");
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
