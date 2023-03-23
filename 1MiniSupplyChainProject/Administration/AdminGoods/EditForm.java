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
	JTextField DescriptionTxt;
	JTextField priceTxt;
	JTextField stockTxt;

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
		JLabel editformlabel = new JLabel("Edit Goods");
		editformlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel idLabel = new JLabel("Goods ID");
		JLabel nameLabel = new JLabel("Name");
		JLabel DescriptionLabel = new JLabel("Description");
		JLabel priceLabel = new JLabel("Price");
		JLabel stockLabel = new JLabel("Stock");

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
		DescriptionTxt = new JTextField(15);
		priceTxt = new JTextField(10);
		stockTxt = new JTextField(10);

		// create control buttons.
		editBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(editformlabel);
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
		size = DescriptionLabel.getPreferredSize();
		DescriptionLabel.setBounds(10, 123, size.width, size.height);
		size = priceLabel.getPreferredSize();
		priceLabel.setBounds(10, 153, size.width, size.height);
		size = stockLabel.getPreferredSize();
		stockLabel.setBounds(10, 183, size.width, size.height);
		size = Refresh.getPreferredSize();
		Refresh.setBounds(195, 214, size.width, size.height);
		

		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(80, 63, 194, 20);
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(80, 93, 194, 20);
		size = DescriptionTxt.getPreferredSize();
		DescriptionTxt.setBounds(80, 123, 194, 20);
		size = priceTxt.getPreferredSize();
		priceTxt.setBounds(80, 153, 194, 20);
		size = stockTxt.getPreferredSize();
		stockTxt.setBounds(80, 183, 194, 20);

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
				String id = idTxt.getText();
				String name = nameTxt.getText();
				String Description = DescriptionTxt.getText();
				int price = Integer.parseInt(priceTxt.getText());
				int stock = Integer.parseInt(stockTxt.getText());
				Goods goods = new Goods(id, name, Description, price, stock);
				System.out.println("goods:" + goods.toString());
				editGoods(goods);
				
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
	private void editGoods(Goods goods) {
		System.out.println("GoodsDB.editGoods()");
		try {
			String updateSql = "UPDATE GOODS SET name='" + goods.name + "', description='" + goods.Description +
					"', stock='" + goods.stock + "', unit_price='" + goods.price + "' WHERE id_goods='" + goods.id+"'";
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
