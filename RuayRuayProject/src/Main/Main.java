package Main;

import javax.swing.JFrame;

import Goods.Goods;
import Goods.GoodsDAO;

import java.awt.BorderLayout;
import java.util.ArrayList;

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
