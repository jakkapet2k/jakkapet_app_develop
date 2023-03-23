package main;

import javax.swing.JFrame;

import java.awt.BorderLayout;

public class MainAll {
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Mini supplier");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new Menu(frame), BorderLayout.CENTER);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
