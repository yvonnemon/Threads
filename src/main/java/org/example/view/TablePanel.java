package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    public TablePanel(String title, DefaultTableModel columnNames) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(title));


        // Create table model with 3 columns
        tableModel = columnNames;
        //tableModel = new DefaultTableModel(new Object[]{"Thread ID", "Column 2", "Column 3"}, 0);
        table = new JTable(tableModel);

        // Wrap table in a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void updateTableData(Object[][] newData) {
        //SwingUtilities.invokeLater(() -> {
            tableModel.setRowCount(0); // Clear table before updating
            for (Object[] row : newData) {

                tableModel.addRow(row);
            }
       //});
    }
}
