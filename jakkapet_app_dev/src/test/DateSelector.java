package test;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateSelector extends JFrame {

    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;

    public DateSelector() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        // Create the JComboBox objects for day, month, and year
        dayComboBox = new JComboBox<String>();
        monthComboBox = new JComboBox<String>();
        yearComboBox = new JComboBox<String>();

        // Add items to the day and year JComboBox objects
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.format("%02d", i));
        }
        for (int i = Calendar.getInstance().get(Calendar.YEAR); i >= 1900; i--) {
            yearComboBox.addItem(String.valueOf(i));
        }

        // Add items to the month JComboBox object
        String[] months = {"01", "02", "03", "04", "05",
                "06", "07", "08", "09", "10", "11", "12"};
        for (String month : months) {
            monthComboBox.addItem(month);
        }

        // Add a listener to the JComboBox objects to retrieve the selected date
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected day, month, and year from the JComboBox objects
                String day = (String) dayComboBox.getSelectedItem();
                String month = String.format("%02d", monthComboBox.getSelectedIndex() + 1);
                String year = (String) yearComboBox.getSelectedItem();

                // Parse the selected date into a Date object
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    String dateString = day + "/" + month + "/" + year;
                    format.parse(dateString);
                    // Display the selected date in a message dialog
                    JOptionPane.showMessageDialog(DateSelector.this,
                            "Selected date: " + dateString);
                } catch (Exception ex) {
                    // Display an error message if the selected date is invalid
                    JOptionPane.showMessageDialog(DateSelector.this,
                            "Invalid date");
                }
            }
        };
        dayComboBox.addActionListener(listener);
        monthComboBox.addActionListener(listener);
        yearComboBox.addActionListener(listener);

        // Create a JPanel object to hold the JComboBox objects
        JPanel panel = new JPanel();
        panel.add(dayComboBox);
        panel.add(monthComboBox);
        panel.add(yearComboBox);

        // Add the JPanel object to the JFrame
        getContentPane().add(panel);

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new DateSelector();
    }
}
