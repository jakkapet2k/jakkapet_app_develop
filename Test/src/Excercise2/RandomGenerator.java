package Excercise2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RandomGenerator extends JPanel implements ActionListener {
    
	static final String INT_STR = "int";
    static final String DOUBLE_STR = "double";
    static final String BOUND_STR = "bound";
    static final String NUMBER_STR = "number";
    static final String GENERATE_STR = "Generate";
    
    static final int INT_TYPE = 0;
    static final int DOUBLE_TYPE = 1;
    
    JRadioButton intButton;
    JRadioButton doubleButton;
    
    JTextField boundTextField;
    JTextField numberTextField;
    
    JButton genButton;
    
    static int typeRadioCol = 25;
    static int typeLabelCol = 30;
    static int boundTextCol = 120;
    static int boundLabelCol = 220;
    static int genButtonCol = 400;
    
    static int intRadioRow = 25;
    static int doubleRadioRow = 50;
    
    static int width = 800;
    static int height = 600;
    
    int type = INT_TYPE;
    int number = 0;
    int bound = 0;
    
    RandomNumber randomNumber;

    public RandomGenerator() {
        super(new BorderLayout());
        
        setLayout(null);
        setPreferredSize(new Dimension(800, 400));

        
        intButton = new JRadioButton(INT_STR);
        intButton.setMnemonic(KeyEvent.VK_B);
        intButton.setActionCommand(INT_STR);
        intButton.setSelected(true);
        intButton.setBounds(typeRadioCol, intRadioRow, 
        		intButton.getPreferredSize().width, 
        		intButton.getPreferredSize().height);
        add(intButton);
        
        doubleButton = new JRadioButton(DOUBLE_STR);
        doubleButton.setMnemonic(KeyEvent.VK_C);
        doubleButton.setActionCommand(DOUBLE_STR);
        intButton.setSelected(true);
        doubleButton.setBounds(typeRadioCol, doubleRadioRow, 
        		doubleButton.getPreferredSize().width, 
        		doubleButton.getPreferredSize().height);
        add(doubleButton);
        
        
        ButtonGroup group = new ButtonGroup();
        group.add(intButton);
        group.add(doubleButton);

        
        intButton.addActionListener(this);
        doubleButton.addActionListener(this);

        boundTextField = new JTextField(7);
        boundTextField.setBounds(boundTextCol, intRadioRow, 
        		boundTextField.getPreferredSize().width, 
        		boundTextField.getPreferredSize().height);
        add(boundTextField);
        JLabel boundLabel = new JLabel(BOUND_STR);
        boundLabel.setBounds(boundLabelCol, intRadioRow, 
        		boundLabel.getPreferredSize().width+50, 
        		boundLabel.getPreferredSize().height);
        add(boundLabel);

        numberTextField = new JTextField(7);
        numberTextField.setBounds(boundTextCol, doubleRadioRow, 
        		numberTextField.getPreferredSize().width, 
        		numberTextField.getPreferredSize().height);
        add(numberTextField);
        JLabel numberLabel = new JLabel(NUMBER_STR);
        numberLabel.setBounds(boundLabelCol, doubleRadioRow, 
        		numberLabel.getPreferredSize().width+40, 
        		numberLabel.getPreferredSize().height);
        add(numberLabel);
        
        genButton = new JButton(GENERATE_STR);
        genButton.setBounds(genButtonCol, intRadioRow, 
        		genButton.getPreferredSize().width+90, 
        		genButton.getPreferredSize().height);
        add(genButton);
        genButton.addActionListener(this);
        
        randomNumber = new RandomNumber();
        
    }

    
    public void actionPerformed(ActionEvent e) {
    	
    	String command = e.getActionCommand();
		System.out.println("command:" + command);
    	if(command.equals(INT_STR)) {
    		type = INT_TYPE;
    	} else if(command.equals(DOUBLE_STR)) {
    		type = DOUBLE_TYPE;	
    	} else if(command.equals(GENERATE_STR)) {
    		String strBound = boundTextField.getText();
    		String strNumber = numberTextField.getText();
    		try {
    			bound = Integer.parseInt(strBound);
    		} catch(NumberFormatException ex) {
    			bound = 0;
    			
    		}
    		try {
    			number = Integer.parseInt(strNumber);
    		} catch(NumberFormatException ex) {
    			number = 0;
    			
    		}
    		System.out.println("type:" + type + ", bound:" + bound + 
    				", number:" + number);
    		if(number == 0) {
    			return;
    		}
    		System.out.println("Generating...");
    		if(type == INT_TYPE) {
    			int[] array;
    			if(bound == 0) {
    				array = randomNumber.genInt(number);
    			} else {
    				array = randomNumber.genInt(number, bound);
    			}
    			ArrayViewer.view1DIntArray(array);
    			int data[] = new int[array.length];
    			
    			for(int i = 0; i< array.length; i++) {
    				data[i] = array[i];
    			}
    			int max = array[0];
    			for(int counter = 1; counter < array.length; counter++) {
    				if(array[counter]>max) {
    					max = array[counter];
    				}
    			}
    			new Mytap(array,max+10);
    			
    			
    		} else if(type == DOUBLE_TYPE) {
    			double[] array = randomNumber.genGaussian(number);
    			ArrayViewer.view1DDoubleArray(array);
    		}
    	} 
    	
    }

    
    protected static ImageIcon createImageIcon(String path) {
        if (path != null) {
            return new ImageIcon(path);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

   
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("RadioButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JComponent newContentPane = new RandomGenerator();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);

       
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
