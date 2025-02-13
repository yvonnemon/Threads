package org.example.view;

import org.example.model.Model;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ConfigPanel extends JPanel {

    private final JTable centerTable;
    private static DefaultTableModel tableModel;

    public ConfigPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(350, 0)); // Slightly wider for better visibility
        setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding

        // Table Model (Only the "Value" column is editable, except for headers)
        tableModel = new DefaultTableModel(new Object[]{"Parameter", "Value"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1 && !isHeaderRow(row); // Prevent editing section headers
            }
        };

        // Add Configurable Parameters with Headers
        addRow("Total Resources", "2");

        addHeader("Resource Settings");
        addRow("Max Quantity", "200");
        addRow("Min Quantity", "10");

        addRow("Number of producers", "2");
        addRow("Number of consumers", "2");

        addHeader("Starting config");
        addRow("Start Delay Min", "2");
        addRow("Start Delay Max", "2");

        addHeader("Action Delay");
        addRow("Producer Delay Min", "2");
        addRow("Producer Delay Max", "2");

        addRow("Consumer Delay Min", "2");
        addRow("Consumer Delay Max", "2");

        centerTable = new JTable(tableModel);
        styleTable(centerTable);  // Apply custom styles

        JScrollPane centerScrollPane = new JScrollPane(centerTable);
        add(centerScrollPane, BorderLayout.CENTER);
    }

    // Method to add a normal row
    private void addRow(String name, String value) {
        tableModel.addRow(new Object[]{name, value});
    }

    // Method to add a header row
    private void addHeader(String name) {
        tableModel.addRow(new Object[]{name, ""}); // Empty value column
    }

    // Check if a row is a section header (Non-editable)
    private boolean isHeaderRow(int row) {
        return tableModel.getValueAt(row, 1).equals(""); // Headers have an empty second column
    }

    // Apply modern table styling
    private void styleTable(JTable table) {
        table.setRowHeight(25);  // Increase row height
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(60, 63, 65)); // Dark header
        table.getTableHeader().setForeground(Color.WHITE); // White text
        table.setSelectionBackground(new Color(184, 207, 229)); // Highlight selection color

        // Alternate row colors
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Style headers differently
                if (isHeaderRow(row)) {
                    c.setFont(new Font("Arial", Font.BOLD, 14));
                    c.setBackground(new Color(220, 220, 220)); // Light gray for headers
                } else {
                    c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
                }
                return c;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    public static Model getConfigData() {
        int rowCount = tableModel.getRowCount();

        Model data = new Model();

        for (int row = 0; row < rowCount; row++) {
               // data[row][col] = tableModel.getValueAt(row, col);

                if (tableModel.getValueAt(row, 0).equals("Total Resources")) {
                   data.setTotalResources(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Max Quantity")) {
                    data.setMaxQuantity(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Min Quantity")) {
                    data.setMinQuantity(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Number of producers")) {
                    data.setNumberOfProducers(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Number of consumers")) {
                    data.setNumberOfConsumers(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Start Delay Min")) {
                    data.setStartDelayMin(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Start Delay Max")) {
                    data.setStartDelayMax(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Producer Delay Min")) {
                    data.setProducerDelayMin(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Producer Delay Max")) {
                    data.setProducerDelayMax(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Consumer Delay Min")) {
                    data.setConsumerDelayMin(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Consumer Delay Max")) {
                    data.setConsumerDelayMax(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else {
                    System.out.println("Invalid variable name: " + tableModel.getValueAt(row, 1).toString());
                }
        }
        return data;
    }

}
