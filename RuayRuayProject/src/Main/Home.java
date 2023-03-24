package Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class Home extends JPanel {
	private JTable table;
	
	public Home(Main main)  {
		
		
		
		this.setBounds(0,0,500,300);
		this.setLayout(null);
		
		JLabel lblGoodsInfo = new JLabel("Goods Info");
		lblGoodsInfo.setFont(new Font("Quark", Font.BOLD, 23));
		lblGoodsInfo.setBounds(379, 32, 106,33);
		this.add(lblGoodsInfo);
		setPreferredSize(new Dimension(900,400));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 880, 313);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
