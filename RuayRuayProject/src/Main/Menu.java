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
import Goods.GoodsDAO;
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
	static final String HOME_STR = "Home";
	
	
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
	
	
	private static final String CATLV1_ADD_STR = "ADD Catagory Lv.1";
	private static final String CATLV1_EDIT_STR = "Edit Catagory Lv.1";
	private static final String CATLV1_DELETE_STR = "Delete Catagory Lv.1";
	
	private static final String CATLV2_ADD_STR = "ADD Catagory Lv.2";
	private static final String CATLV2_EDIT_STR = "Edit Catagory Lv.2";
	private static final String CATLV2_DELETE_STR = "Delete Catagory Lv.2";
	
	private static final String CATLV3_ADD_STR = "ADD Catagory Lv.3";
	private static final String CATLV3_EDIT_STR = "Edit Catagory Lv.3";
	private static final String CATLV3_DELETE_STR = "Delete Catagory Lv.3";
	
	
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
		
		  JMenu  file,menu, submenu ,goods,clv1,clv2,clv3;
          JMenuItem ihome,i1, i2, i3, i4, i5, i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20 ,iexit;  
          JMenuBar mb=new JMenuBar();
 
		
          setJMenuBar(mb);  
          file = new JMenu("File");
          ihome = new JMenuItem(HOME_STR);
          iexit = new JMenuItem(EXIT_STR);
          file.add(ihome);
          file.add(iexit);
          
          
          menu = new JMenu("CRUD");
          
          
          
          goods = new JMenu("Goods");
          clv1 = new JMenu("Catagory Lv.1");
          clv2 = new JMenu("Catagory Lv.2");
          clv3 = new JMenu("Catagory Lv.3");
          submenu=new JMenu(GoodsString);  
          i1=new JMenuItem(Goods_ADD_STR);  
          i2=new JMenuItem(Goods_EDIT_STR);  
          i3=new JMenuItem(Goods_DELETE_STR);    
          i4=new JMenuItem(CATLV1_ADD_STR);  
          i5=new JMenuItem(CATLV1_EDIT_STR);  
          i6=new JMenuItem(CATLV1_DELETE_STR); 
          i7=new JMenuItem(CATLV2_ADD_STR);  
          i8=new JMenuItem(CATLV2_EDIT_STR);  
          i9=new JMenuItem(CATLV2_DELETE_STR);
          i10=new JMenuItem(CATLV3_ADD_STR);  
          i11=new JMenuItem(CATLV3_EDIT_STR);  
          i12=new JMenuItem(CATLV3_DELETE_STR); 
          submenu.add(goods);        
          goods.add(i1); 
          goods.add(i2); 
          goods.add(i3); 
          submenu.add(clv1); 
          clv1.add(i4); 
          clv1.add(i5); 
          clv1.add(i6); 
          submenu.add(clv2); 
          clv2.add(i7); 
          clv2.add(i8); 
          clv2.add(i9); 
          submenu.add(clv3); 
          clv3.add(i10); 
          clv3.add(i11); 
          clv3.add(i12); 
          menu.add(submenu);  
          
          
          submenu=new JMenu(SupplierString);  
          i13=new JMenuItem(Supplier_ADD_STR);   
          i14=new JMenuItem(Supplier_EDIT_STR);  
          i15=new JMenuItem(Supplier_DELETE_STR);  
          submenu.add(i13); 
          submenu.add(i14); 
          submenu.add(i15); 
          menu.add(submenu);  
        
          submenu=new JMenu(ProcurementString);  
          i16=new JMenuItem(Procurement_ORDER_STR );    
          i17=new JMenuItem(Procurement_CKORDER_STR );  
          submenu.add(i16); 
          submenu.add(i17); 
          menu.add(submenu);
        
          submenu=new JMenu(CustomerString);  
          i18=new JMenuItem(Customer_ADD_STR);   
          i19=new JMenuItem(Customer_EDIT_STR);
          i20=new JMenuItem(Customer_DELETE_STR);    
          submenu.add(i18); 
          submenu.add(i19); 
          submenu.add(i20); 
          menu.add(submenu);
          
          ihome.addActionListener(this);
          iexit.addActionListener(this);
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
          i13.addActionListener(this); 
          i14.addActionListener(this);
          i15.addActionListener(this);
          i16.addActionListener(this);
          i17.addActionListener(this); 
          i18.addActionListener(this);
          i19.addActionListener(this); 
          i20.addActionListener(this);
          
          			mb.add(file);
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
