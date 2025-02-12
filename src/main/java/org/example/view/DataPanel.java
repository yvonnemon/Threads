package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataPanel extends JPanel {
    private TablePanel resourcesTable;
    private TablePanel consumersTable;
    private TablePanel producersTable;

    public DataPanel() {
        setLayout(new GridLayout(3, 1, 5, 5)); // 3 rows in a vertical grid
        setPreferredSize(new Dimension(600, 0)); // Fixed width

        // Create table panels with appropriate titles
        resourcesTable = new TablePanel("Resources", new DefaultTableModel(new Object[]{"Resource ID", "Quantity", "Min Quantity", "Max Quantity", "Consumers #", "Producers #"}, 0));
        consumersTable = new TablePanel("Consumers", new DefaultTableModel(new Object[]{"Consumer ID", "Thread ID", "Belongs to", "Start Delay", "Consume Delay"}, 0));
        producersTable = new TablePanel("Producers", new DefaultTableModel(new Object[]{"Producer ID", "Thread ID", "Belongs to", "Start Delay", "Produce Delay"}, 0));

        // Add the panels to the layout
        add(resourcesTable);
        add(consumersTable);
        add(producersTable);
    }

    //  Thread-Safe: Methods to update each table
    public void updatePanel1(Object[][] data) { resourcesTable.updateTableData(data); }
    public void updatePanel2(Object[][] data) { consumersTable.updateTableData(data); }
    public void updatePanel3(Object[][] data) { producersTable.updateTableData(data); }

}
