package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainFrame extends JFrame {

    private static MainFrame instance; // Static reference
    private ConfigPanel configPanel;
    private DataPanel dataPanel;

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

        dataPanel = new DataPanel();
        add(new DataPanel(), BorderLayout.EAST); // Right panel
        add(dataPanel, BorderLayout.EAST);

        //TODO
        startBackgroundUpdates();
    }
    private void startBackgroundUpdates() {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                Random random = new Random();
                while (true) {
                    try {
                        Thread.sleep(2000); // Update every 2 seconds

                        // 🟢 Generate Random Data for Testing
                        Object[][] data1 = {
                                {"Item A", random.nextInt(100), "✓"},
                                {"Item B", random.nextInt(100), "✓"}
                        };

                        Object[][] data2 = {
                                {"Process X", random.nextInt(50), "Running"},
                                {"Process Y", random.nextInt(50), "Stopped"}
                        };

                        Object[][] data3 = {
                                {"Task 1", random.nextInt(10), "Pending"},
                                {"Task 2", random.nextInt(10), "Completed"}
                        };

                        // 🟢 Update Tables in RightPanel (Thread-Safe)
                        SwingUtilities.invokeLater(() -> {
                            dataPanel.updatePanel1(data1);
                            dataPanel.updatePanel2(data2);
                            dataPanel.updatePanel3(data3);
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.execute();
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
