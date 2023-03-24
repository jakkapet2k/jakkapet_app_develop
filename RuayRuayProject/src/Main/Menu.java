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

import Customer.CustomerAdd;
import Customer.CustomerDelete;
import Customer.CustomerEdit;
import Goods.GoodsAdd;
import Goods.GoodsDelete;
import Goods.GoodsEdit;
import Procurement.CheckOrder;
import Procurement.OrderReceipt;
import Supplier.SupplierAdd;
import Supplier.SupplierDelete;
import Supplier.SupplierEdit;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Insets;





public class Menu extends JFrame  implements ActionListener {

	
	public final static int FRAME_WIDTH = 900;
	final public static int FRAME_HEIGHT = 400;
	
	
	private static final String mainString = "Main Menu";
	private static final String HOME_STR = "Home";
	
	
	private static final String GoodsString = "Goods";
	private static final String SupplierString = "Supplier";
	private static final String ProcurementString = "Procurement";
	private static final String CustomerString = "Customer";
	
	private static final String EXIT_STR = "Exit";
	
	private static final String Goods_ADD_STR = "ADD Goods";
	private static final String Goods_EDIT_STR = "Edit Goods";
	private static final String Goods_DELETE_STR = "Delete Goods";
	
	private static final String Supplier_ADD_STR = "ADD Supplier";
	private static final String Supplier_EDIT_STR = "Edit Supplier";
	private static final String Supplier_DELETE_STR = "Delete Supplier";
	
	
	
	private static final String Procurement_ORDER_STR = "Order ";
	private static final String Procurement_CKORDER_STR = "Check Order ";
	
	
	private static final String Customer_ADD_STR = "ADD Customer";
	private static final String Customer_EDIT_STR = "Edit Customer";
	private static final String Customer_DELETE_STR = "Delete Customer";
	
	
	Main mainmenu;
	JPanel mainPanel;
	
	Home home;
	
	GoodsAdd goodsadd;
	GoodsDelete goodsdelete;
	GoodsEdit goodsedit;
	
	SupplierAdd supplieradd;
	SupplierDelete supplierdelete;
	SupplierEdit supplieredit;
	
	CustomerAdd customeradd;
	CustomerDelete customerdelete;
	CustomerEdit customeredit;

	OrderReceipt order;
	CheckOrder ckorder;
	
	public Menu(Main main) {
		super("Ruay Ruay");

		
		
		setSize(920, 464);
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenDim.width-FRAME_WIDTH)/2, (screenDim.height-FRAME_HEIGHT)/2);
		
		  JMenu  menu, submenu;
          JMenuItem i0,i1, i2, i3, i4, i5, i6,i7,i8,i9,i10,i11,i12 ;  
          JMenuBar mb=new JMenuBar();
          mb.setEnabled(false);
          mb.setBorderPainted(false);
          mb.setBackground(Color.white);
          

         
          
          

          
         
		
          setJMenuBar(mb);  
          
          menu = new JMenu("Menu");
          

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
          i7=new JMenuItem(Procurement_ORDER_STR );    
          i8=new JMenuItem(Procurement_CKORDER_STR );  
          submenu.add(i7); 
          submenu.add(i8); 
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
          i10.addActionListener(this);
          i11.addActionListener(this);
          i12.addActionListener(this);
          
                    mb.add(menu);

        
          home = new Home (mainmenu);
          
          goodsadd = new GoodsAdd(mainmenu);
          goodsdelete = new GoodsDelete(mainmenu);
          goodsedit= new GoodsEdit(mainmenu);
          
          supplieradd = new SupplierAdd(mainmenu);
          supplierdelete = new SupplierDelete(mainmenu);
          supplieredit = new SupplierEdit(mainmenu);
          
          customeradd = new CustomerAdd (mainmenu); 
      	  customerdelete = new CustomerDelete (mainmenu); 
      	  customeredit = new CustomerEdit (mainmenu); 
      	  order = new OrderReceipt (mainmenu); 
      	  ckorder = new CheckOrder (mainmenu); 
		
      	  
      	  
		mainPanel = new JPanel(new CardLayout());
		
		mainPanel.add(home, HOME_STR);
		
		mainPanel.add(goodsadd, Goods_ADD_STR);
		mainPanel.add(goodsdelete, Goods_DELETE_STR);
		mainPanel.add(goodsedit, Goods_EDIT_STR);
		
		mainPanel.add(supplieradd, Supplier_ADD_STR);
		mainPanel.add(supplierdelete, Supplier_DELETE_STR);
		mainPanel.add(supplieredit, Supplier_EDIT_STR);
		
		mainPanel.add(customeradd, Customer_ADD_STR);
		mainPanel.add(customerdelete, Customer_DELETE_STR);
		mainPanel.add(customeredit, Customer_EDIT_STR);
		
		mainPanel.add(order, Procurement_ORDER_STR);
		mainPanel.add(ckorder, Procurement_CKORDER_STR);
		
		
		getContentPane().add(mainPanel);

	}
	


	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		System.out.println("command:" + command);
		Object source = evt.getSource();
		System.out.println("source:" + source.toString());
		if(command.equals(HOME_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, HOME_STR);
			
			//-----------------Goods---------------------//
		} else if(command.equals(Goods_ADD_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Goods_ADD_STR);
		} else if(command.equals(Goods_DELETE_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Goods_DELETE_STR);
		}else if(command.equals(Goods_EDIT_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Goods_EDIT_STR);
			
			//------------------Supplier--------------------//
			
		} else if(command.equals(Supplier_ADD_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Supplier_ADD_STR);
		}else if(command.equals(Supplier_DELETE_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Supplier_DELETE_STR);
		}else if(command.equals(Supplier_EDIT_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Supplier_EDIT_STR);
		}else if(command.equals(Customer_ADD_STR)) {
			
			//------------------Customer--------------------//
			
			
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Customer_ADD_STR);
		}else if(command.equals(Customer_DELETE_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Customer_DELETE_STR);
		}else if(command.equals(Customer_EDIT_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Customer_EDIT_STR);
			
			//----------------Procurement----------------------//
		}else if(command.equals(Procurement_ORDER_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Procurement_ORDER_STR);
		}else if(command.equals(Procurement_CKORDER_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, Procurement_CKORDER_STR);
			
			//----------------EXIT----------------------//
			
			
		}else if(command.equals(EXIT_STR)) {
			System.exit(0);
		}
	}
}
