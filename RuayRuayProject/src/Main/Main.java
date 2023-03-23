package Main;

import javax.swing.JFrame;

import java.awt.BorderLayout;

public class Main {
	
	Menu menu;
	
	public Main(){
		
		menu =  new Menu(this);
		menu.setVisible(true);
	}

	public static void main(String[] args) {
		
		new Main();
	}

}
