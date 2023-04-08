package test03;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class Test03A  extends JPanel implements ChangeListener {

    protected JColorChooser cc;
    protected JLabel banner;

    public Test03A() {super(new BorderLayout());

        banner = new JLabel("ColorShooser",JLabel.CENTER);
        banner.setPreferredSize(new Dimension(100, 65));
        cc = new JColorChooser();
        cc.getSelectionModel().addChangeListener(this);
       
        
        add(banner, BorderLayout.CENTER);
        add(cc, BorderLayout.PAGE_END);
    }

    public void stateChanged(ChangeEvent e) {
        Color newColor = cc.getColor();
        banner.setForeground(newColor);
    }

    public static void main(String[] args) {
    	
    	JFrame frame = new JFrame("Test03A ");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Test03A panel = new Test03A();
    	panel.setOpaque(true);
    	frame.setContentPane(panel);
    	frame.pack();
    	frame.setVisible(true);
    	
    }
}