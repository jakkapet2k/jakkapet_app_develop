package Procurement;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class Menu extends JPanel implements ActionListener {

	private static final String mainString = "Main Menu";
	private static final String OrderString = "Order";
	private static final String CheckString = "Check Order";;
	private static final String exitString = "Exit";
	
	private static final int frameWidth = 400;
	private static final int frameHeight = 300;
	
	OrderReceipt addForm;
	CheckOrder editForm;

	
	public Menu(JFrame frame) {
		
		super();
		
		addForm = new OrderReceipt(frame);
		editForm = new CheckOrder(frame);

		
		int panelWidth = 400;
		int panelHeight = 300;
		
		setLayout(null);
		
		JLabel mainLabel = new JLabel(mainString);
		mainLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		
		JButton addBtn = new JButton(OrderString);
		JButton editBtn = new JButton(CheckString);
		JButton exitBtn = new JButton(exitString);
		
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		add(mainLabel);
		add(addBtn);
		add(editBtn);
		add(exitBtn);
		
		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds(149, 33, 87, 21);
		size = addBtn.getPreferredSize();
		addBtn.setBounds(138, 83, 108, 23);
		size = editBtn.getPreferredSize();
		editBtn.setBounds(138, 117, 108, 23);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds(153, 151, 79, 23);
		
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
	}


	
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		System.out.println("ActionCommand:" + actionCommand);
		if(actionCommand.equals(OrderString)) {
			System.out.println("equals " + OrderString);
			addForm.setVisible(true);
		}else if(actionCommand.equals(CheckString)) {
			System.out.println("equals " + CheckString);
			editForm.setVisible(true);
		}else if(actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			System.exit(0);
		}
	}
}
