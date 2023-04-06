package test;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GoodsAdd extends JPanel  implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;
	
	int idLv1,idLv2,idLv3;

	 
	JComboBox<CatagoryItem> lv1ComboBox,lv2ComboBox,lv3ComboBox;
	CatagoryItem selectedCode;
	
	JTextField nameTxt;
	JTextField priceTxt;
	JTextField stockTxt;

	private static final String addString = "Add";
	private static final String cancelString = "cancel";
	private JTable table;

	public GoodsAdd(Main mainmenu) {

		// set layout manager to manual
		JPanel pane = this;
		pane.setLayout(null);

		pane.add(new JLabel("1:"));
	    lv1ComboBox = new JComboBox<>();
	    lv1ComboBox.setBounds(30, 40, 100, 30);
	    DAO.ComboBoxVL1(lv1ComboBox, 0);
	    pane.add(lv1ComboBox);
	    
	    lv2ComboBox = new JComboBox<>();
	    pane.add(new JLabel("2:"));
	    lv2ComboBox.setBounds(30, 95, 100, 30);
	    pane.add(lv2ComboBox);
	   
	    
	    lv3ComboBox = new JComboBox<>();
	    lv3ComboBox.setBounds(30, 150, 100, 30);
	    pane.add(lv3ComboBox);
		
		// create labels
		JLabel addgoodlabel = new JLabel("Add Goods");
		JLabel nameLabel = new JLabel("Name");
		JLabel priceLabel = new JLabel("Price");
		JLabel stockLabel = new JLabel("Stock");

		// create buttons
		JButton addBtn = new JButton(addString);
		JButton cancelBtn = new JButton(cancelString);

		// create texts
		nameTxt = new JTextField(20);
		priceTxt = new JTextField(10);
		stockTxt = new JTextField(10);

		// Create the Code ComboBox
//	    lv1ComboBox = new JComboBox<>();
//	    add(new JLabel("1:"));
//	    add(lv1ComboBox);
	    
	        // Connect to the database
     
        


	    lv1ComboBox.addActionListener(this);
	    
		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(addgoodlabel);
		pane.add(nameLabel);
		pane.add(priceLabel);
		pane.add(stockLabel);

		// add text fields
		pane.add(nameTxt);
		pane.add(priceTxt);
		pane.add(stockTxt);

		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = addgoodlabel.getPreferredSize();
		addgoodlabel.setBounds((width - size.width) / 2, 5, size.width, size.height);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(180, 40, 100, 30);
		size = priceLabel.getPreferredSize();
		priceLabel.setBounds(180, 95, 100, 30);
		size = stockLabel.getPreferredSize();
		stockLabel.setBounds(180, 150, 100, 30);

		// set sizes and positions for labels
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(225, 40, 100, 30);
		size = priceTxt.getPreferredSize();
		priceTxt.setBounds(225, 95, 100, 30);
		size = stockTxt.getPreferredSize();
		stockTxt.setBounds(225, 150, 100, 30);

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(139, 190, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(210, 190, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 235, 380, 241);
		this.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		

		setVisible(true);

		System.out.println("AddformDialog() done!");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		Object source = e.getSource();
		
		try {
			
		if ( source == lv1ComboBox) {
			selectedCode = (CatagoryItem) lv1ComboBox.getSelectedItem();
			idLv1 = selectedCode.getid();
			System.err.println(idLv1);
			lv2ComboBox.removeAllItems();
			DAO.ComboBoxVL2(lv2ComboBox, idLv1);
			
		}else if (e.getSource() == lv2ComboBox) {


			selectedCode = (CatagoryItem) lv2ComboBox.getSelectedItem();
			idLv2 = selectedCode.getid();
			System.err.println(idLv2);
			lv3ComboBox.removeAllItems();
//			DAOGood.ComboBoxVL3(lv3ComboBox, idLv2);
		}else if (e.getSource() == lv3ComboBox) {
			try {
			selectedCode = (CatagoryItem) lv3ComboBox.getSelectedItem();
			idLv3 = selectedCode.getid();
			System.err.println(idLv3);
			} catch (Exception ex) {

			}
		}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
