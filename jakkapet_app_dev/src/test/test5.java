package test;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class test5 {
   public static void main(String[] args) {
      // Create a table with some sample data
      String[][] data = {{"apple", "orange", "banana"}, {"dog", "cat", "fish"}, {"red", "green", "blue"}};
      String[] columnNames = {"Column 1", "Column 2", "Column 3"};
      JTable table = new JTable(data, columnNames);
      
      // Set up a custom cell renderer to highlight the word "apple"
      TableCellRenderer renderer = new DefaultTableCellRenderer() {
         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String text = c instanceof JLabel ? ((JLabel) c).getText() : String.valueOf(value);
            if (text.toLowerCase().contains("apple")) {
               c.setBackground(Color.YELLOW);
            } else {
               c.setBackground(null);
            }
            return c;
         }
      };
      
      // Apply the custom cell renderer to the table
      for (int i = 0; i < table.getColumnCount(); i++) {
         table.getColumnModel().getColumn(i).setCellRenderer(renderer);
      }
      
      // Display the table
      JFrame frame = new JFrame();
      frame.add(new JScrollPane(table));
      frame.pack();
      frame.setVisible(true);
   }
}
