package test05;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test05A extends JFrame implements MouseListener, MouseMotionListener {
	 JTextArea log;
	public Test05A() {
		super("Mouse Form");
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setVisible(true);
		
	}
	
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Clicked at: x :  " + x + " , y: " + y);
		
	}
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Pressed at: x :  " + x + " , y: " + y);
		
	}
	
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Released at: x :  " + x + " , y: " + y);
		
	}
	
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Dragged at: x :  " + x + " , y: " + y);
		
	}
	
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Moved at: x : " + x + " , y: " + y);
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	
	
	public static void main(String []args) {
		new Test05A();
	}
}