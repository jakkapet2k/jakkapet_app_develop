package test01;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test01A extends JPanel {

	public Test01A() {

		setBounds(0, 0, 500, 300);
		setPreferredSize(new Dimension(448, 176));
		setLayout(null);

		JLabel lblTestA = new JLabel("TEST 01 A ");
		lblTestA.setBounds(204, 32, lblTestA.getPreferredSize().width, lblTestA.getPreferredSize().height);

		JLabel labelName = new JLabel("Name");
		labelName.setBounds(10, 81, labelName.getPreferredSize().width, labelName.getPreferredSize().height);

		JTextField textName = new JTextField(20);
		textName.setBounds(80, 81, textName.getPreferredSize().width, textName.getPreferredSize().height);

		JButton btnName = new JButton(" OK ");
		btnName.setBounds(352, 77, btnName.getPreferredSize().width, btnName.getPreferredSize().height);

		add(lblTestA);
		add(labelName);
		add(textName);
		add(btnName);

	}

	public static void main(String[] args) {

		Test01A panel = new Test01A();
		panel.setBackground(Color.lightGray);
		panel.setOpaque(true);

		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.pack();

	}

}
