package AdminGoods;

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
	private static final String addString = "Add";
	private static final String editString = "Edit";
	private static final String deleteString = "Delete";
	private static final String exitString = "Exit";
	
	private static final int frameWidth = 400;
	private static final int frameHeight = 300;
	
	AddForm addForm;
	EditForm editForm;
	DeleteForm deleteForm;
	
	public Menu(JFrame frame) {
		
		super();
		
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
		
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
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
			System.exit(0);
		}
	}
}
