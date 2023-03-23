package main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Customer.AddForm;
import Customer.DeleteForm;
import Customer.EditForm;

import java.awt.Font;

public class Customer extends JDialog implements ActionListener {

	private static final String mainString = "Customer Menu";
	private static final String addString = "Add";
	private static final String editString = "Edit";
	private static final String deleteString = "Delete";
	private static final String exitString = "Exit";
	
	private static final int panelWidth = 400;
	private static final int panelHeight = 300;
	
	AddForm addForm;
	EditForm editForm;
	DeleteForm deleteForm;
	
	public Customer(JFrame frame) {
		
		super(frame, true);
		Container pane = getContentPane();
		// set layout manager to manual
		pane.setLayout(null);
		
		addForm = new AddForm(frame);
		editForm = new EditForm(frame);
		deleteForm = new DeleteForm(frame);
		
		int panelWidth = 400;
		int panelHeight = 300;
		
		setLayout(null);
		
		JLabel mainLabel = new JLabel(mainString);
		mainLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		
		JButton addBtn = new JButton(addString);
		JButton editBtn = new JButton(editString);
		JButton deleteBtn = new JButton(deleteString);
		JButton exitBtn = new JButton(exitString);
		
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		add(mainLabel);
		add(addBtn);
		add(editBtn);
		add(deleteBtn);
		add(exitBtn);
		
		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds(153, 33, 87, 21);
		size = addBtn.getPreferredSize();
		addBtn.setBounds(161, 83, 79, 23);
		size = editBtn.getPreferredSize();
		editBtn.setBounds(161, 123, 79, 23);
		size = deleteBtn.getPreferredSize();
		deleteBtn.setBounds(161, 160, 79, 23);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds(161, 194, 79, 23);
		
		pane.setPreferredSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		pack();
		setLocationRelativeTo(null);
		setVisible(false);
	}


	
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		System.out.println("ActionCommand:" + actionCommand);
		if(actionCommand.equals(addString)) {
			System.out.println("equals " + addString);
			addForm.setVisible(true);
		}else if(actionCommand.equals(editString)) {
			System.out.println("equals " + editString);
			editForm.setVisible(true);
		
		}else if(actionCommand.equals(deleteString)) {
			System.out.println("equals " + deleteString);
			deleteForm.setVisible(true);
		}else if(actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			setVisible(false);
		}
	}
}
