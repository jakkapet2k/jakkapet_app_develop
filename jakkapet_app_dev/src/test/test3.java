package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test3 implements ActionListener {
    JComboBox<Item> comboBox;
    JButton button;

    public test3() {
        // Create a new JFrame
        JFrame frame = new JFrame("ComboBox Custom Item Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a new JComboBox with custom items
        comboBox = new JComboBox<>();
        comboBox.addItem(new Item("Item 1", "111"));
        comboBox.addItem(new Item("Item 2", "222"));
        comboBox.addItem(new Item("Item 3", "333"));

        // Add a custom item to the JComboBox
        comboBox.addItem(new Item("dddd", "888"));

        // Create a new JButton to call a method with the selected item's value as a parameter
        button = new JButton("Call Method");
        button.addActionListener(this);

        // Create a new JPanel to hold the JComboBox and JButton
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(comboBox);
        panel.add(button);

        // Add the JPanel to the JFrame
        frame.add(panel, BorderLayout.CENTER);

        // Display the JFrame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected item from the JComboBox
        Item selected = (Item) comboBox.getSelectedItem();

        // Call a method with the selected item's value as a parameter
        myMethod(selected.getValue());
    }

    public void myMethod(String value) {
        // Do something with the value
        System.out.println("Value passed to myMethod: " + value);
    }

    public static void main(String[] args) {
        new test3();
    }

    private class Item {
        private String label;
        private String value;

        public Item(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
