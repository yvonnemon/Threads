package org.example.view;

import org.example.model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainFrame extends JFrame {

    private static MainFrame instance; // Static reference
    private ConfigPanel configPanel;
    private DataPanel dataPanel;

    public MainFrame(Model model) {
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
        //startBackgroundUpdates(model);
    }

//    public void startBackgroundUpdates(Model model) {
//        new SwingWorker<Void, Void>() {
//            @Override
//            protected Void doInBackground() {
//                Random random = new Random();
//                while (true) {
//                    //System.out.println("Starting background updates");
//                    try {
//                        Thread.sleep(1000); // Update every 2 seconds
//
//                        // 🟢 Generate Random Data for Testing
//                        Object[][] data1 = {
//                                {"model.get", random.nextInt(100), "✓"},
//                                {"Item B", random.nextInt(100), "✓"}
//                        };
//
//                        Object[][] data2 = new Object[2][3];
//                        for (int i = 0; i < data2.length; i++) {
//                            data2[i][0] = model.getThreadConsumer().get(i).threadId();
//                            data2[i][1] = model.getConsumers().get(i).getResourceType().getQuantity();
//                            data2[i][2] = model.getConsumers().get(i).getMinDelay();
//                        }
//
//
//                        Object[][] data3 = {
//                                {"Task 1", random.nextInt(10), "Pending"},
//                                {"Task 2", random.nextInt(10), "Completed"}
//                        };
//
//                        //  Update Tables in RightPanel (Thread-Safe)
//                        SwingUtilities.invokeLater(() -> {
//                            dataPanel.updatePanel1(data1);
//                            dataPanel.updatePanel2(data2);
//                            dataPanel.updatePanel3(data3);
//                        });
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.execute();
//    }

    public void jajxd(Model model) {


        //System.out.println("Starting background updates");
        Object[][] data2 = new Object[2][3];
        for (int i = 0; i < data2.length; i++) {
            data2[i][0] = model.getThreadConsumer().get(i).threadId();
            data2[i][1] = model.getConsumers().get(i).getResourceType().getQuantity();
            data2[i][2] = model.getConsumers().get(i).getMinDelay();
        }
//                        Object[][] data3 = {
//                                {"Task 1", 3, "Pending"},
//                                {"Task 2", 3, "Completed"}
//                        };
        //  Update Tables in RightPanel (Thread-Safe)

        //dataPanel.updatePanel1(data1);
        dataPanel.updatePanel2(data2);

        //dataPanel.updatePanel3(data3);
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
