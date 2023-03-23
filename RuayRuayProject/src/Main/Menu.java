package Main;

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

	
	public final static int FRAME_WIDTH = 500;
	final public static int FRAME_HEIGHT = 300;
	
	
	private static final String mainString = "Main Menu";
	
	private static final String GoodsString = "Goods";
	private static final String SupplierString = "Supplier";
	private static final String ProcurementString = "Procurement";
	private static final String CustomerString = "Customer";
	
	private static final String EXIT_STR = "Exit";
	
	private static final String Goods_ADD_STR = "ADD";
	private static final String Goods_EDIT_STR = "Edit";
	private static final String Goods_DELETE_STR = "Delete";
	
	private static final String Supplier_ADD_STR = "ADD";
	private static final String Supplier_EDIT_STR = "Edit";
	private static final String Supplier_DELETE_STR = "Delete";
	
	private static final String Procurement_ADD_STR = "ADD";
	private static final String Procurement_EDIT_STR = "Edit";
	private static final String Procurement_DELETE_STR = "Delete";
	
	private static final String Customer_ADD_STR = "ADD";
	private static final String Customer_EDIT_STR = "Edit";
	private static final String Customer_DELETE_STR = "Delete";
	
	Main mainmenu;
	FormDelete formdelete;
	FormAdd formadd;
	FormEdit formedit;
	JPanel mainPanel;
	
	public Menu(Main main) {
		super("Ruay Ruay");
		
		this.mainmenu=mainmenu;
		
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenDim.width-FRAME_WIDTH)/2, (screenDim.height-FRAME_HEIGHT)/2);
		
		  JMenu menu, submenu;  
          JMenuItem i1, i2, i3, i4, i5, i6,i7,i8,i9,i10,i11,i12;  
          JMenuBar mb=new JMenuBar();  
          
          
          menu=new JMenu("Menu");  
          submenu=new JMenu(GoodsString);  
          i1=new JMenuItem(Goods_ADD_STR);  
          i2=new JMenuItem(Goods_EDIT_STR);  
          i3=new JMenuItem(Goods_DELETE_STR);  
          submenu.add(i1); 
          submenu.add(i2); 
          submenu.add(i3); 
          menu.add(submenu);  
          
          
          submenu=new JMenu(SupplierString);  
          i4=new JMenuItem(Supplier_ADD_STR);   
          i5=new JMenuItem(Supplier_EDIT_STR);  
          i6=new JMenuItem(Supplier_DELETE_STR);  
          submenu.add(i4); 
          submenu.add(i5); 
          submenu.add(i6); 
          menu.add(submenu);  
          
          
          submenu=new JMenu(ProcurementString);  
          i7=new JMenuItem(Procurement_ADD_STR);    
          i8=new JMenuItem(Procurement_EDIT_STR);  
          i9=new JMenuItem(Procurement_DELETE_STR);    
          submenu.add(i7); 
          submenu.add(i8); 
          submenu.add(i9); 
          menu.add(submenu);
          
          
          submenu=new JMenu(CustomerString);  
          i10=new JMenuItem(Customer_ADD_STR);   
          i11=new JMenuItem(Customer_EDIT_STR);
          i12=new JMenuItem(Customer_DELETE_STR);    
          submenu.add(i10); 
          submenu.add(i11); 
          submenu.add(i12); 
          menu.add(submenu);

          
          i1.addActionListener(this);
          i2.addActionListener(this); 
          i3.addActionListener(this); 
          i4.addActionListener(this);
          i5.addActionListener(this);
          i6.addActionListener(this);
          i7.addActionListener(this); 
          i8.addActionListener(this); 
          i9.addActionListener(this); 
          i10.addActionListener(this);
          i11.addActionListener(this);
          i12.addActionListener(this);
           
          mb.add(menu);  
		
          setJMenuBar(mb);  

          
		formadd = new FormAdd(mainmenu);
		formdelete = new FormDelete(mainmenu);
		formedit= new FormEdit(mainmenu);
		
		
		
		mainPanel = new JPanel(new CardLayout());
		
		mainPanel.add(formadd, Goods_ADD_STR);
		mainPanel.add(formdelete, Goods_DELETE_STR);
		mainPanel.add(formedit, Goods_EDIT_STR);
		
		
		add(mainPanel);

	}
	
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		System.out.println("command:" + command);
		Object source = evt.getSource();
		System.out.println("source:" + source.toString());
		if(command.equals(Goods_ADD_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Goods_ADD_STR);
		} else if(command.equals(Goods_DELETE_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Goods_DELETE_STR);
		}else if(command.equals(Goods_EDIT_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Goods_EDIT_STR);
		} else if(command.equals(EXIT_STR)) {
			System.exit(0);
		}
	}
	
}
