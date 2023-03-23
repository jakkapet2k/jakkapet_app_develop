package week9_window;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class WindowMain {
	

	public static void main(String[] args) {
		System.out.println("Go Home Now!!!");
		JFrame frame = new JFrame("Main Window");
		
		frame.setPreferredSize(new Dimension(500,300));
		
		MainPage mainpage = new MainPage();
//		frame.add(mainpage);
//		frame.getContentPane().add(mainpage);
		
		
		AddPage addpage = new AddPage();
		frame.add(addpage);
//		frame.getContentPane().add(addpage);
		
		ViewPage viewpage = new ViewPage();
		frame.add(viewpage);
//		frame.getContentPane().add(viewpage);
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Manage Data");
		
		JMenuItem jMenuItem = new JMenuItem("Main Page");
		frame.setJMenuBar(jMenuBar);
		
		
//		 jMenuItem = new JMenuItem("View Page");
		
		jMenu.add(jMenuItem);
		jMenuBar.add(jMenu);
		jMenuItem = new JMenuItem("Add Page");
		jMenu.add(jMenuItem);
		jMenuItem = new JMenuItem("View Page");
		jMenu.add(jMenuItem);
		
		frame.pack();
		frame.setVisible(true);
		
		frame.setBounds(100,100, 600, 300);
		

		
		
	} 
}
