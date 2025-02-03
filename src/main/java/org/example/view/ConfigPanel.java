package org.example.view;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {

    public ConfigPanel() {
        setLayout(new BorderLayout());

        // Table in the center
        JTable centerTable = new JTable(5, 2); // 5 rows, 2 columns
        JScrollPane centerScrollPane = new JScrollPane(centerTable);

        // Customize the table (left column plain text, right column editable)
        centerTable.getColumnModel().getColumn(0).setHeaderValue("Plain Text");
        centerTable.getColumnModel().getColumn(1).setHeaderValue("Input Field");
        add(centerScrollPane, BorderLayout.CENTER);
    }
}
