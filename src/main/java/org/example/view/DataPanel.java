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

    //  Thread-Safe: Methods to update each table
    public void updatePanel1(Object[][] data) { panel1.updateTableData(data); }
    public void updatePanel2(Object[][] data) { panel2.updateTableData(data); }
    public void updatePanel3(Object[][] data) { panel3.updateTableData(data); }

}
