package org.example.view;

import org.example.controller.Controller;
import org.example.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class MainFrame extends JFrame implements Runnable {

    private static MainFrame instance; // Static reference
    private ConfigPanel configPanel;
    private DataPanel dataPanel;

    public MainFrame(Model model) {
        setTitle("ThreadLab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null); // Center on screen

        setLayout(new BorderLayout());

        // Add all panels

        ControlPanel controlPanel = new ControlPanel();
        Controller.getInstance().setControlPanel(controlPanel);

        add(controlPanel, BorderLayout.CENTER);  // Left panel
        add(new ConfigPanel(), BorderLayout.WEST); // Center panel

        dataPanel = new DataPanel();
        add(new DataPanel(), BorderLayout.EAST); // Right panel
        add(dataPanel, BorderLayout.EAST);

    }


    public void updateTable(Model model) {

        SwingUtilities.invokeLater(() -> {
            Object[][] tableResources = new Object[model.getTotalResources()][8];
            for (int i = 0; i < tableResources.length; i++) {
                tableResources[i][0] = model.getResources().get(i).toString();
                // TODO revisar este para que no se vea si hay under/over flow

                tableResources[i][2] = model.getResources().get(i).getMinQuantity();
                tableResources[i][3] = model.getResources().get(i).getMaxQuantity();
                tableResources[i][4] = model.getNumberOfConsumers();
                tableResources[i][5] = model.getNumberOfProducers();
                if(model.getResources().get(i).getQuantity() > model.getResources().get(i).getMaxQuantity()) { //si cantidad > maxQ pinta overflow
                   // System.out.println("DEBERIA OVERFLOW");
                    tableResources[i][6] = model.getResources().get(i).getQuantity() -
                            model.getResources().get(i).getMaxQuantity(); //overflow
                    tableResources[i][7] = 0; //underflow
                    tableResources[i][1] = model.getResources().get(i).getMaxQuantity();// quantity
                } else if (model.getResources().get(i).getQuantity() < model.getResources().get(i).getMinQuantity()) { //si cantidad < minQ pinta underflow
                    //System.out.println(" DEBERIA UNDERFLOW");
                    tableResources[i][6] = 0;
                    tableResources[i][7] = model.getResources().get(i).getMinQuantity() - model.getResources().get(i).getQuantity();
                    tableResources[i][1] = model.getResources().get(i).getMinQuantity();
                } else {
                   // System.out.println("TAMOS ENTRE LOS NUMEROS");
                    tableResources[i][1] = model.getResources().get(i).getQuantity();
                    tableResources[i][6] = 0;
                    tableResources[i][7] = 0;
                }
            }

            Object[][] tableProducers = new Object[model.getThreadProducers().size()][7];
            for (int i = 0; i < tableProducers.length; i++) {
                tableProducers[i][0] = model.getProducers().get(i).getId();
                tableProducers[i][1] = model.getThreadProducers().get(i).threadId();
                tableProducers[i][2] = model.getProducers().get(i).getResourceType().getId();
                tableProducers[i][3] = model.getProducers().get(i).getMinDelay();
                tableProducers[i][4] = model.getProducers().get(i).getMaxDelay();
                tableProducers[i][5] = model.getProducers().get(i).getStatus();
                tableProducers[i][6] = model.getProducers().get(i).toString();
            }

            //System.out.println("Starting background updates");
            Object[][] tableConsumers = new Object[model.getThreadConsumer().size()][7];
            for (int i = 0; i < tableConsumers.length; i++) {
                tableConsumers[i][0] = model.getConsumers().get(i).getId();
                tableConsumers[i][1] = model.getThreadConsumer().get(i).threadId();
                tableConsumers[i][2] = model.getConsumers().get(i).getResourceType().getId();
                tableConsumers[i][3] = model.getConsumers().get(i).getMinDelay();
                tableConsumers[i][4] = model.getConsumers().get(i).getMaxDelay();
                tableConsumers[i][5] = model.getConsumers().get(i).getStatus();
                tableConsumers[i][6] = model.getConsumers().get(i).toString();
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
