package test04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Test04A extends JPanel implements ActionListener {
    static private final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;

    public Test04A () {
        super(new BorderLayout());

        setPreferredSize(new Dimension(500, 300));
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        
        fc = new JFileChooser();

        openButton = new JButton("Open a File");
     

        saveButton = new JButton("Save a File");
       
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        add(logScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_START);
        
        
        saveButton.addActionListener(this);
        openButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	String fName;
        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(Test04A.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                fName = file.getPath();
                System.out.println(file.getPath());
                log.append(readFile(fName)+ newline);
                
            } else {
                System.out.println("Open command cancelled by user." + newline);
            }

        //Handle save button action.
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(Test04A.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                fName = file.getPath();
                System.out.println(file.getPath());
                writeFile(fName);
                log.append("Save file :"+file.getName()+ newline);

            } else {
                System.out.println("Save command cancelled by user." + newline);
            }
        }
    }

    public String writeFile(String fName) {
    	
		String fileName = fName;
		fileName = fName;
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
	        Date today = new Date();
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss");
	        String dateString = formatter.format(today);

			
			bw = new BufferedWriter(new FileWriter(fileName));
			bw.write("Jakkapet" +" : "+dateString);
			bw.flush();
			bw.close();
        } catch (IllegalArgumentException iae) {
            System.err.println("Error: " + iae.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;

    	
    }
    
    public String readFile(String fName) {
    
		String fileName = fName;
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				return line;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

    }
    
    public static void main(String[] args) {
    	
    	JFrame frame = new JFrame("Test04A - Color Chooser");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Test04A panel = new Test04A();
    	panel.setOpaque(true);
    	frame.setContentPane(panel);
    	
    	frame.pack();
    	frame.setVisible(true);
    }
}