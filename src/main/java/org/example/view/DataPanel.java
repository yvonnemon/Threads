package org.example.view;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataPanel extends JPanel {
    private final TablePanel resourcesTable;
    private final TablePanel consumersTable;
    private final TablePanel producersTable;

    public DataPanel() {
        setLayout(new GridLayout(3, 1, 10, 10)); // Increased spacing for a better look
        setPreferredSize(new Dimension(750, 0)); // Slightly wider panel
        setBackground(new Color(240, 240, 240)); // Light background color

        // Table Headers
        String[] resourceHeaders = {"Resource ID", "Quantity", "Min Quantity", "Max Quantity", "Consumers #", "Producers #", "Overflow", "Underflow"};
        String[] consumerHeaders = {"Consumer ID", "Thread ID", "Belongs to", "Start Delay", "Consume Delay", "Status", "Start Time"};
        String[] producerHeaders = {"Producer ID", "Thread ID", "Belongs to", "Start Delay", "Produce Delay", "Status", "Start Time"};

        // Create table panels with a modern design
        resourcesTable = new TablePanel("Resources", createStyledModel(resourceHeaders));
        consumersTable = new TablePanel("Consumers", createStyledModel(consumerHeaders));
        producersTable = new TablePanel("Producers", createStyledModel(producerHeaders));

        // Add padding for better spacing
        resourcesTable.setBorder(new EmptyBorder(10, 10, 10, 10));
        consumersTable.setBorder(new EmptyBorder(10, 10, 10, 10));
        producersTable.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Add the panels to the layout
        add(resourcesTable);
        add(consumersTable);
        add(producersTable);
    }

    // Create a modern-styled table model
    private DefaultTableModel createStyledModel(String[] columnNames) {
        return new DefaultTableModel(columnNames, 0);
    }

    // Thread-Safe: Methods to update each table
    public void updatePanel1(Object[][] data) { resourcesTable.updateTableData(data); }
    public void updatePanel2(Object[][] data) { consumersTable.updateTableData(data); }
    public void updatePanel3(Object[][] data) { producersTable.updateTableData(data); }
}

