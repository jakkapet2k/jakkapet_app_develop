package test;

import java.sql.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class test4 extends JFrame implements ActionListener {

	int idLv1, idLv2,idLv3;

	JComboBox<CatagoryItem> lv1ComboBox, lv2ComboBox, lv3ComboBox, goodsComboBox;
	CatagoryItem selectedCode;

	public test4() {
		// Initialize the JFrame
		setTitle("ComboBox Example");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 2));

		// Create the Code ComboBox
		lv1ComboBox = new JComboBox<CatagoryItem>();
		add(new JLabel("1:"));
		add(lv1ComboBox);

		// Query the database to retrieve the YOURID data
		try {
			// Connect to the database
			DAO.ComboBoxVL1(lv1ComboBox,0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		lv1ComboBox.addActionListener(this);

		// Create the Name ComboBox
		lv2ComboBox = new JComboBox<CatagoryItem>();
		add(new JLabel("2:"));
		add(lv2ComboBox);

		lv2ComboBox.addActionListener(this);

		lv3ComboBox = new JComboBox<CatagoryItem>();
		add(new JLabel("Brand:"));
		add(lv3ComboBox);

		lv3ComboBox.addActionListener(this);

		goodsComboBox = new JComboBox<CatagoryItem>();
		add(new JLabel("product:"));
		add(goodsComboBox);

		goodsComboBox.addActionListener(this);

		// Display the JFrame
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		try {
			if (e.getSource() == lv1ComboBox) {

					selectedCode = (CatagoryItem) lv1ComboBox.getSelectedItem();
					idLv1 = selectedCode.getid();
					System.err.println(idLv1);
					lv2ComboBox.removeAllItems();
					DAO.ComboBoxVL2(lv2ComboBox, idLv1);


			} else if (e.getSource() == lv2ComboBox) {


					selectedCode = (CatagoryItem) lv2ComboBox.getSelectedItem();
					idLv2 = selectedCode.getid();
					System.err.println(idLv2);
					lv3ComboBox.removeAllItems();
					DAO.ComboBoxVL3(lv3ComboBox, idLv2);


			} else if (e.getSource() == lv3ComboBox) {
				try {
				selectedCode = (CatagoryItem) lv3ComboBox.getSelectedItem();
				idLv3 = selectedCode.getid();
				System.err.println(idLv3);
				} catch (Exception ex) {

				}
			}
			
			System.out.println("--------------Start------------------");
		    System.out.println("ConsoleLog Lavel1: "+idLv1);
		    System.out.println("ConsoleLog Lavel2: "+idLv2);
		    System.out.println("ConsoleLog Lavel3: "+idLv3);
		    System.out.println("---------------END-----------------");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new test4();
	}
}