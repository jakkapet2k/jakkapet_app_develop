package test02;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02A extends JPanel implements ActionListener {

	static JFrame frame;
	JLabel dateLabel, nLabel;
	String patternDate, patturnNum;
	JComboBox NumberlistList,patternList;

	public Test02A() {
		setLayout(null);
		setPreferredSize(new Dimension(500, 300));

		String[] patternarry = { "dd MMMMM yyyy", "dd.MM.yy", "MM/dd/yy", "yyyy.MM.dd G 'at' hh:mm:ss z",
				"EEE, MMM d, ''yy", "h:mm a", "H:mm:ss:SSS", "K:mm a,z", "yyyy.MMMMM.dd GGG hh:mm aaa" };

		patternDate = patternarry[0];

		 patternList = new JComboBox(patternarry);
		patternList.setEditable(true);
		patternList.addActionListener(this);
		patternList.setBounds(10, 40, patternList.getPreferredSize().width, patternList.getPreferredSize().height);

		dateLabel = new JLabel("Current Date/Time");
		dateLabel.setBounds(10, 70, 400, dateLabel.getPreferredSize().height);

		add(patternList);
		add(dateLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			patternList  = (JComboBox) e.getSource();
			String S1 = (String) patternList.getSelectedItem();
			patternDate = S1;
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(patternDate);
			String formattedDate = dateFormat.format(currentDate);
			dateLabel.setText(formattedDate);

		} catch (Exception er) {

		}

	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Test02A");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Test02A panel = new Test02A();

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
