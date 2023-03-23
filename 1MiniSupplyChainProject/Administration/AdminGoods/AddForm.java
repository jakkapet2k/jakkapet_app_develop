package AdminGoods;

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

public class AddForm extends JDialog implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	JTextField idTxt;
	JTextField nameTxt;
	JTextField DescriptionTxt;
	JTextField priceTxt;
	JTextField stockTxt;

	private static final String addString = "Add";
	private static final String cancelString = "cancel";
	private static final String RefreshString = "Refresh";

	private JTable table;
	private JScrollPane scrollPane;

	public AddForm(JFrame frame) {
		super(frame, true);

		
		setTitle("Add");
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
			@Override
			public void windowActivated(WindowEvent e) {
				ShowData();
			}
		});

		// Create pane as container
		Container pane = getContentPane();
		// set layout manager to manual
		pane.setLayout(null);

		// create labels
		JLabel addformlabel = new JLabel("Add Goods");
		addformlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLabel idLabel = new JLabel("Goods ID");
		JLabel nameLabel = new JLabel("Name");
		JLabel DescriptionLabel = new JLabel("Description");
		JLabel priceLabel = new JLabel("Price");
		JLabel stockLabel = new JLabel("Stock");

		// create buttons
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
		DescriptionTxt = new JTextField(15);
		priceTxt = new JTextField(10);
		stockTxt = new JTextField(10);

		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(addformlabel);
		pane.add(idLabel);
		pane.add(nameLabel);
		pane.add(DescriptionLabel);
		pane.add(priceLabel);
		pane.add(stockLabel);

		// add text fields
		pane.add(idTxt);
		pane.add(nameTxt);
		pane.add(DescriptionTxt);
		pane.add(priceTxt);
		pane.add(stockTxt);

		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);
		pane.add(Refresh);

		// set sizes and positions for labels
		Dimension size = addformlabel.getPreferredSize();
		addformlabel.setBounds(277, 11, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(29, 66, size.width, size.height);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(29, 96, size.width, size.height);
		size = DescriptionLabel.getPreferredSize();
		DescriptionLabel.setBounds(29, 126, size.width, size.height);
		size = priceLabel.getPreferredSize();
		priceLabel.setBounds(29, 156, size.width, size.height);
		size = stockLabel.getPreferredSize();
		stockLabel.setBounds(29, 186, size.width, size.height);
		Refresh.setBounds(299, 244, 89, 23);

		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(99, 66, 166, 20);
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(99, 96, 166, 20);
		size = DescriptionTxt.getPreferredSize();
		DescriptionTxt.setBounds(99, 126, 166, 20);
		size = priceTxt.getPreferredSize();
		priceTxt.setBounds(99, 156, 166, 20);
		size = stockTxt.getPreferredSize();
		stockTxt.setBounds(99, 186, 166, 20);

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
		if (actionCommand.equals(addString)) {
			System.out.println("actionCommand:" + addString);
			try {
				// retrieve values from text fields.
				String id = idTxt.getText();
				String name = nameTxt.getText();
				String Description = DescriptionTxt.getText();
				int price = Integer.parseInt(priceTxt.getText());
				int stock = Integer.parseInt(stockTxt.getText());
				Goods DBgoods = new Goods(id, name, Description, price, stock);
				System.out.println("goods:" + DBgoods.toString());
				addGoods(DBgoods);

				// reset text fields
				idTxt.setText(null);
				nameTxt.setText(null);
				DescriptionTxt.setText(null);
				priceTxt.setText(null);
				stockTxt.setText(null);

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

	private void addGoods(Goods goods) {
		System.out.println("GoodsDB.addGoods()");
		try {
			String insertSql = "INSERT INTO goods VALUES" + "('" + goods.id + "', '" + goods.name + "', '"
					+ goods.Description + "', '" + goods.stock + "', '" + goods.price + "')";
			System.out.println("selectSql:" + insertSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Goods added successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid id.");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void ShowData() {
        ConnMariaDB connDB = new ConnMariaDB();
        Connection con = connDB.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Goods ID");
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Stock");
        model.addColumn("Unit price");

        try {
            String query = "SELECT * FROM GOODS";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getString("id_goods"),
                        rs.getString("name"),
                        rs.getString("Description"),
                        rs.getString("stock"),
                        rs.getString("unit_price")
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
            table.getColumnModel().getColumn(3).setPreferredWidth(60);
            table.getColumnModel().getColumn(4).setPreferredWidth(80);


        } catch (Exception e) {
            System.out.println("error: " + e);
        }
	}
}
