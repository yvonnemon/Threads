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

       /* // Table in the center
        centerTable = new JTable(5, 2); // 5 rows, 2 columns*/


        tableModel = new DefaultTableModel(new Object[]{"Parameter", "Value"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only allow editing of the second column
                return column == 1;
            }
        };
        tableModel.addRow(new Object[]{"Total Resources", 5});
        tableModel.addRow(new Object[]{"Max resources", 5});
        tableModel.addRow(new Object[]{"Min resources", 5});
        tableModel.addRow(new Object[]{"Number of producers", 5});
        tableModel.addRow(new Object[]{"Number of consumers", 5});
        tableModel.addRow(new Object[]{"Start Delay Min", 5});
        tableModel.addRow(new Object[]{"Start Delay Max", 5});
        tableModel.addRow(new Object[]{"Producer Delay Min", 5});
        tableModel.addRow(new Object[]{"Producer Delay Max", 5});
        tableModel.addRow(new Object[]{"Consumer Delay Min", 5});
        tableModel.addRow(new Object[]{"Consumer Delay Max", 5});

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
                
                if (tableModel.getValueAt(row, 0).equals("totalResources")) {
                    data.setTotalResources(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("maxResources")) {
                    data.setMaxResources(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("minResources")) {
                    data.setMinResources(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("numberOfProducers")) {
                    data.setNumberOfProducers(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("numberOfConsumers")) {
                    data.setNumberOfConsumers(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("startDelayMin")) {
                    data.setStartDelayMin(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("startDelayMax")) {
                    data.setStartDelayMax(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("producerDelayMin")) {
                    data.setProducerDelayMin(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("producerDelayMax")) {
                    data.setProducerDelayMax(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("consumerDelayMin")) {
                    data.setConsumerDelayMin(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else if (tableModel.getValueAt(row, 0).equals("consumerDelayMax")) {
                    data.setConsumerDelayMax(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                } else {
                    System.out.println("Invalid variable name: " + tableModel.getValueAt(row, 0).toString());
                }
            
        }
        return data;
    }

}
