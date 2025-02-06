package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    public TablePanel(String title) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(title));

        // Create table model with 3 columns
        tableModel = new DefaultTableModel(new Object[]{"Thread ID", "Column 2", "Column 3"}, 0);
        table = new JTable(tableModel);

        // Wrap table in a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to dynamically add rows to the table
    public void addRow(Object[] rowData) {
        tableModel.addRow(rowData);
    }

    // Optional: Getter for the table if further customization is needed
    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void updateTableData(Object[][] newData) {
        SwingUtilities.invokeLater(() -> {
            tableModel.setRowCount(0); // Clear table before updating
            for (Object[] row : newData) {
                tableModel.addRow(row);
            }
        });
    }
}
