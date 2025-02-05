package org.example.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance; // Static reference
    private ConfigPanel configPanel;

    public MainFrame() {
        setTitle("ThreadLab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center on screen

        setLayout(new BorderLayout());

        // Add all panels
        //add(new TitlePanel(), BorderLayout.NORTH); // Title at the top
        add(new ControlPanel(), BorderLayout.WEST);  // Left panel
        add(new ConfigPanel(), BorderLayout.CENTER); // Center panel

        DataPanel dataPanel = new DataPanel();
        add(new DataPanel(), BorderLayout.EAST); // Right panel
        add(dataPanel, BorderLayout.EAST);

        //TODO
        // Add rows dynamically to the tables in JPanel1, JPanel2, and JPanel3
        dataPanel.addRowToPanel1(new Object[]{"Row 1 - Col 1", "Row 1 - Col 2", "Row 1 - Col 3"});
        dataPanel.addRowToPanel1(new Object[]{"Row 2 - Col 1", "Row 2 - Col 2", "Row 2 - Col 3"});

        dataPanel.addRowToPanel2(new Object[]{"Row 1 - Col 1", "Row 1 - Col 2", "Row 1 - Col 3"});

        dataPanel.addRowToPanel3(new Object[]{"Row 1 - Col 1", "Row 1 - Col 2", "Row 1 - Col 3"});
        dataPanel.addRowToPanel3(new Object[]{"Row 2 - Col 1", "Row 2 - Col 2", "Row 2 - Col 3"});
    }

    // Getter for the static instance
    public static MainFrame getInstance() {
        return instance;
    }

    // Getter for the center panel
    public ConfigPanel getConfigPanel() {
        return configPanel;
    }
}
