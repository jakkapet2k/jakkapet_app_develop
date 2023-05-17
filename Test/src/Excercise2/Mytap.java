package Excercise2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Mytap {
	public Mytap(int[] data, int bound) {
		JFrame frame = new JFrame();
		
		
		
		BarGraph barGraph = new BarGraph(bound,data);
		LineGraph lineGraph = new LineGraph(bound,data);
		
		JTabbedPane tap = new JTabbedPane();
		tap.add("Bar Graph",barGraph);
		tap.add("Line Graph",lineGraph);
		
		frame.getContentPane().add(tap,BorderLayout.CENTER);
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(1,1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
