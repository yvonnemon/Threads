package org.example.view;

import org.example.model.Model;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class ConfigPanel extends JPanel {

    private JTable centerTable;
    private static DefaultTableModel tableModel;

    public ConfigPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 0));

        tableModel = new DefaultTableModel(new Object[]{"Parameter", "Value"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only allow editing of the second column
                return column == 1;
            }
        };

        tableModel.addRow(new Object[]{"Total Resources", 2});
        tableModel.addRow(new Object[]{"Max resources", 2});
        tableModel.addRow(new Object[]{"Min resources", 2});
        tableModel.addRow(new Object[]{"Number of producers", 2});
        tableModel.addRow(new Object[]{"Number of consumers", 2});
        tableModel.addRow(new Object[]{"Start Delay Min", 2});
        tableModel.addRow(new Object[]{"Start Delay Max", 2});
        tableModel.addRow(new Object[]{"Producer Delay Min", 2});
        tableModel.addRow(new Object[]{"Producer Delay Max", 2});
        tableModel.addRow(new Object[]{"Consumer Delay Min", 2});
        tableModel.addRow(new Object[]{"Consumer Delay Max", 2});

        centerTable = new JTable(tableModel);

        // Customize the table (left column plain text, right column editable)
        centerTable.getColumnModel().getColumn(0).setHeaderValue("Plain Text");
        centerTable.getColumnModel().getColumn(1).setHeaderValue("Input Field");


        JScrollPane centerScrollPane = new JScrollPane(centerTable);
        add(centerScrollPane, BorderLayout.CENTER);
    }

    public static Model getConfigData() {
        int rowCount = tableModel.getRowCount();
        int columnCount = tableModel.getColumnCount();
        
        Model data = new Model();

        for (int row = 0; row < rowCount; row++) {
               // data[row][col] = tableModel.getValueAt(row, col);

                if (tableModel.getValueAt(row, 0).equals("Total Resources")) {
                   data.setTotalResources(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Max resources")) {
                    data.setMaxResources(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("Min resources")) {
                    data.setMinResources(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
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
