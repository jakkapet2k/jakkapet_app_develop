package week9_window;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class AddPage extends JPanel {
	
	public AddPage() {
		
		
		setPreferredSize(new Dimension(500,300));
		setLayout(null);
		setBackground(Color.green);
		
		JLabel label = new JLabel("Add Page");
		label.setBounds(0, 0,label.getPreferredSize().width,label.getPreferredSize().height);
		add(label);
	}

}
