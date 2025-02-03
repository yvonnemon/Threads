package org.example.view;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    public ControlPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 0)); // Fixed width for the left panel

        // Table for left panel
        JTable leftTable = new JTable(7, 2); // 7 rows, 2 columns
        JScrollPane leftScrollPane = new JScrollPane(leftTable);
        add(leftScrollPane, BorderLayout.CENTER);

        // Buttons for the left panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5)); // 2x2 grid for buttons
        buttonPanel.setPreferredSize(new Dimension(200, 100)); // Fixed height
        buttonPanel.add(new ButtonPlay());
        buttonPanel.add(new ButtonStop());
        buttonPanel.add(new ButtonConfig());
        buttonPanel.add(new JButton("Button 4"));
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
