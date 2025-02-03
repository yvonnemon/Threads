package org.example.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
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
        add(new DataPanel(), BorderLayout.EAST); // Right panel
    }
}
