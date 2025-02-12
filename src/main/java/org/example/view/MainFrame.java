package org.example.view;

import org.example.controller.Controller;
import org.example.model.Model;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Runnable {

    private static MainFrame instance; // Static reference
    private ConfigPanel configPanel;
    private DataPanel dataPanel;

    public MainFrame(Model model) {
        setTitle("ThreadLab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null); // Center on screen

        setLayout(new BorderLayout());

        // Add all panels
        //add(new TitlePanel(), BorderLayout.NORTH); // Title at the top
        add(new ControlPanel(), BorderLayout.CENTER);  // Left panel
        add(new ConfigPanel(), BorderLayout.WEST); // Center panel

        dataPanel = new DataPanel();
        add(new DataPanel(), BorderLayout.EAST); // Right panel
        add(dataPanel, BorderLayout.EAST);

        //TODO
        //startBackgroundUpdates(model);
    }


    public void updateTable(Model model) {

        SwingUtilities.invokeLater(() -> {
            Object[][] tableResources = new Object[model.getTotalResources()][6];
            for (int i = 0; i < tableResources.length; i++) {
                tableResources[i][0] = model.getResources().get(i).toString();
                tableResources[i][1] = model.getResources().get(i).getQuantity();
                tableResources[i][2] = model.getResources().get(i).getMinQuantity();
                tableResources[i][3] = model.getResources().get(i).getMaxQuantity();
                tableResources[i][4] = model.getNumberOfConsumers();
                tableResources[i][5] = model.getNumberOfProducers();
            }

            Object[][] tableProducers = new Object[model.getThreadProducers().size()][5];
            for (int i = 0; i < tableProducers.length; i++) {
                tableProducers[i][0] = model.getProducers().get(i).getId();
                tableProducers[i][1] = model.getThreadProducers().get(i).threadId();
                tableProducers[i][2] = model.getProducers().get(i).getResourceType().getId();
                tableProducers[i][3] = model.getProducers().get(i).getMinDelay();
                tableProducers[i][4] = model.getProducers().get(i).getMinDelay();
            }

            //System.out.println("Starting background updates");
            Object[][] tableConsumers = new Object[model.getThreadConsumer().size()][5];
            for (int i = 0; i < tableConsumers.length; i++) {
                tableConsumers[i][0] = model.getConsumers().get(i).getId();
                tableConsumers[i][1] = model.getThreadConsumer().get(i).threadId();
                tableConsumers[i][2] = model.getConsumers().get(i).getResourceType().getId();
                tableConsumers[i][3] = model.getConsumers().get(i).getMinDelay();
                tableConsumers[i][4] = model.getConsumers().get(i).getMinDelay();
            }

            dataPanel.updatePanel1(tableResources);
            dataPanel.updatePanel2(tableConsumers);

            dataPanel.updatePanel3(tableProducers);
        });


    }

    // Getter for the static instance
    public static MainFrame getInstance() {
        return instance;
    }

    // Getter for the center panel
    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    @Override
    public void run() {
        //TODO updatea la tabla
        Model x = Controller.getInstance().getModel();
        int dormir = 0;
        while (true) {
            try {
                dormir++;
                if(dormir > 1){
                    Thread.sleep(100);
                }
                SwingUtilities.invokeLater(() -> {
                    updateTable(Controller.getInstance().getModel());
                });


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
