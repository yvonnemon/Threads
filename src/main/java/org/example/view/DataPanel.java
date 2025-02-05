package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataPanel extends JPanel {
    private TablePanel panel1;
    private TablePanel panel2;
    private TablePanel panel3;

    public DataPanel() {
        setLayout(new GridLayout(3, 1, 5, 5)); // 3 rows in a vertical grid
        setPreferredSize(new Dimension(200, 0)); // Fixed width

        // Create table panels with appropriate titles
        panel1 = new TablePanel("JPanel 1");
        panel2 = new TablePanel("JPanel 2");
        panel3 = new TablePanel("JPanel 3");

        // Add the panels to the layout
        add(panel1);
        add(panel2);
        add(panel3);
    }

    // Example of how to add rows to the tables
    public void addRowToPanel1(Object[] rowData) {
        panel1.addRow(rowData);
    }

    public void addRowToPanel2(Object[] rowData) {
        panel2.addRow(rowData);
    }

    public void addRowToPanel3(Object[] rowData) {
        panel3.addRow(rowData);
    }
}
