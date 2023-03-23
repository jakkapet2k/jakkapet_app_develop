package Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormEdit extends JPanel {

	public FormEdit(Main main) {
		
		
		setPreferredSize(new Dimension(500,300));
		setLayout(null);
		setBackground(Color.blue);
		
		JLabel label = new JLabel("Add Page");
		label.setBounds(0, 0,label.getPreferredSize().width,label.getPreferredSize().height);
		add(label);
	}

}
