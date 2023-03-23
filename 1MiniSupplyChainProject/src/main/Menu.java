package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;

public class Menu extends JPanel implements ActionListener {

	private static final String mainString = "Main Menu";
	private static final String GoodsString = "Goods";
	private static final String SupplierString = "Supplier";
	private static final String ProcurementString = "Procurement";
	private static final String CustomerString = "Customer";
	private static final String exitString = "Exit";
	
	private static final int frameWidth = 400;
	private static final int frameHeight = 300;
	
	Goods goods;
	Supplier supplier;
	Procurement procurement;
	Customer customer;
	
	
	public Menu(JFrame frame) {
		
		super();
		
		goods = new Goods(frame);
		supplier = new Supplier(frame);
		procurement = new Procurement(frame);
		customer = new Customer(frame);
		
		int panelWidth = 400;
		int panelHeight = 300;
		

		
		JLabel mainLabel = new JLabel(mainString);
		mainLabel.setBounds(168, 46, 79, 21);
		mainLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		
		JButton GoodsBtn = new JButton(GoodsString);
		GoodsBtn.setBounds(81, 112, 253, 23);
		JButton SupplierBtn = new JButton(SupplierString);
		SupplierBtn.setBounds(81, 146, 253, 23);
		JButton ProcurementBtn = new JButton(ProcurementString);
		ProcurementBtn.setBounds(81, 180, 253, 23);
		JButton CustomerBtn = new JButton(CustomerString);
		CustomerBtn.setBounds(81, 217, 253, 23);
		JButton exitBtn = new JButton(exitString);
		exitBtn.setBounds(81, 251, 253, 23);
		
		GoodsBtn.addActionListener(this);
		SupplierBtn.addActionListener(this);
		ProcurementBtn.addActionListener(this);
		CustomerBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		setLayout(null);
		
		add(mainLabel);
		add(GoodsBtn);
		add(SupplierBtn);
		add(ProcurementBtn);
		add(CustomerBtn);
		add(exitBtn);
		
		
		Dimension size = mainLabel.getPreferredSize();
		size = GoodsBtn.getPreferredSize();
		size = SupplierBtn.getPreferredSize();
		size = ProcurementBtn.getPreferredSize();
		size = CustomerBtn.getPreferredSize();
		size = exitBtn.getPreferredSize();
		
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
	}


	
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		System.out.println("ActionCommand:" + actionCommand);
		if(actionCommand.equals(GoodsString)) {
			System.out.println("equals " + GoodsString);
			goods.setVisible(true);
		}else if(actionCommand.equals(SupplierString)) {
			System.out.println("equals " + SupplierString);
			supplier.setVisible(true);
		
		}else if(actionCommand.equals(ProcurementString)) {
			System.out.println("equals " + ProcurementString);
			procurement.setVisible(true);
		}else if(actionCommand.equals(CustomerString)) {
			System.out.println("equals " + CustomerString);
			customer.setVisible(true);	
		}else if(actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			System.exit(0);
		}
	}
}
