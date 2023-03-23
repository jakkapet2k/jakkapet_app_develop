package week9_window;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ViewPage extends JPanel {
	
	public ViewPage() {
		
		
		setPreferredSize(new Dimension(500,300));
		setLayout(null);
		setBackground(Color.orange);
		
		JLabel label = new JLabel("View Page");
		label.setBounds(0, 0, label.getPreferredSize().width,label.getPreferredSize().height);
		add(label);
		
		
	}
}
