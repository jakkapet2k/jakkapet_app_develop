package test;
import javax.swing.*;
import java.awt.*;

public class test1 extends JFrame {

    private JLabel label;

    public test1() {
        setTitle("Image Display");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the image
        ImageIcon icon = new ImageIcon("C:/Users/Jakkapet2K/Desktop/web tem/img/navbar_logo.png");
        // Get the image object and scale it to the desired size
        Image img = icon.getImage().getScaledInstance(2448/6, 957/6, Image.SCALE_SMOOTH);


        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(img);

        // Create a label to display the scaled image
        label = new JLabel();
        label.setIcon(scaledIcon);
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;

        // Add the label to the center of the layout
//        add(label, c);
        
        setLocationRelativeTo(null);
//        pack();

        // Add the label to the content pane
        Container contentPane = getContentPane();
        contentPane.add(label, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        test1 frame = new test1();
        frame.setVisible(true);
    }
}
