package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public DataPanel() {
        setLayout(new GridLayout(3, 1, 5, 5)); // 3 rows in a vertical grid
        setPreferredSize(new Dimension(400, 0)); // Fixed width

        // Add table to JPanel1
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(BorderFactory.createTitledBorder("JPanel 1"));

        // Create table model with 3 columns
        tableModel = new DefaultTableModel(new Object[]{"Column 1", "Column 2", "Column 3"}, 0);
        table = new JTable(tableModel);

        // Wrap table in scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane, BorderLayout.CENTER);

        // Add panel1 with the table to the layout
        add(panel1);

        // Add JPanel2
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("JPanel 2"));
        add(panel2);

        // Add JPanel3
        JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createTitledBorder("JPanel 3"));
        add(panel3);
    }

    // Method to dynamically add rows to the table
    public void addRow(Object[] rowData) {
        tableModel.addRow(rowData);
    }
}
