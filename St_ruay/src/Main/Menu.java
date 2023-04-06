package Main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class Menu extends JFrame  implements ActionListener {

	public final static int FRAME_WIDTH = 684;
	final public static int FRAME_HEIGHT = 486;

	static final String HOME_STR = "Home";

	private static final String GoodsString = "Goods";
	private static final String EXIT_STR = "Exit";

	private static final String Goods_ADD_STR = "ADD Goods";
	private static final String Goods_EDIT_STR = "Edit Goods";
	private static final String Goods_DELETE_STR = "Delete Goods";

	Main mainmenu;
	JPanel mainPanel;

	Home home;

	GoodsAdd goodsadd;
	GoodsDelete goodsdelete;
	GoodsEdit goodsedit;



	public Menu(Main main) {
		super("Ruay Ruay");
		
		setSize(418, 600);
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenDim.width - FRAME_WIDTH) / 2, (screenDim.height - FRAME_HEIGHT) / 2);

		JMenu file, menu, submenu, goods;
		JMenuItem ihome, i1, i2, i3, iexit;
		JMenuBar mb = new JMenuBar();

		setJMenuBar(mb);

		menu = new JMenu("CRUD");


		submenu = new JMenu(GoodsString);
		i1 = new JMenuItem(Goods_ADD_STR);
		i2 = new JMenuItem(Goods_EDIT_STR);
		i3 = new JMenuItem(Goods_DELETE_STR);
		submenu.add(i1);
		submenu.add(i2);
		submenu.add(i3);

		menu.add(submenu);

	

		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);

		
		mb.add(menu);


		
		mainPanel = new JPanel(new CardLayout());
		getContentPane().add(mainPanel);
		
		home = new Home(mainmenu);
		mainPanel.add(home, HOME_STR);

		
		
		
		
	}

	public void actionPerformed(ActionEvent evt) {

		String command = evt.getActionCommand();
		System.out.println("command:" + command);
//		Object source = evt.getSource();
		CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
		

		

		if(command.equals(HOME_STR)) {

			home = new Home(mainmenu);
			mainPanel.add(home, HOME_STR);
			cardLayout.show(mainPanel, HOME_STR);
			
			//-----------------Goods---------------------//
		} else if(command.equals(Goods_ADD_STR)) {
			goodsadd = new GoodsAdd(mainmenu);
			mainPanel.add(goodsadd, Goods_ADD_STR);
			cardLayout.show(mainPanel, Goods_ADD_STR);
			
		} else if(command.equals(Goods_DELETE_STR)) {
			goodsdelete = new GoodsDelete(mainmenu);
			mainPanel.add(goodsdelete, Goods_DELETE_STR);
			cardLayout.show(mainPanel, Goods_DELETE_STR);

		
			
		}else if(command.equals(Goods_EDIT_STR)) {
			goodsedit = new GoodsEdit(mainmenu);
			mainPanel.add(goodsedit, Goods_EDIT_STR);
			cardLayout.show(mainPanel, Goods_EDIT_STR);

			//------------------Supplier--------------------//
			
		
			
		}else if(command.equals(EXIT_STR)) {
			System.exit(0);
		}else {
			System.err.println("Not Command");
		}
		

	}
}
