package week9_window;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainPage extends JPanel{
	

	public MainPage() {
		
		this.setBounds(0,0,500,300);
		this.setLayout(null);
		this.setBackground(Color.pink);
		
		JLabel label = new JLabel("Main page");
		label.setBounds(30, 60, label.getPreferredSize().width,label.getPreferredSize().height);
		this.add(label);
	


		
	}


	
}
