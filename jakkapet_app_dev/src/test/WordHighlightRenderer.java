package test;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class WordHighlightRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    private String wordToHighlight;

    public WordHighlightRenderer(String wordToHighlight) {
        this.wordToHighlight = wordToHighlight;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && value.toString().contains(wordToHighlight)) {
            c.setBackground(Color.YELLOW); // Highlight the cell with yellow color
        } else {
            c.setBackground(table.getBackground()); // Reset the background color
        }

        return c;
    }
}