package org.example.controller;

import org.example.model.Consumer;
import org.example.model.Model;
import org.example.model.Producer;
import org.example.model.ResourceType;
import org.example.view.ConfigPanel;
import org.example.view.DataPanel;
import org.example.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    private static Controller instance;
    private Model model;
    private MainFrame mainFrame;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void startSwing(){
        SwingUtilities.invokeLater(() -> {
            mainFrame = new MainFrame(model);
            mainFrame.setVisible(true);
            System.out.println("startSwing");
        });
    }

    public void startButton(){
        //TODO get data
        Model x = ConfigPanel.getConfigData(); //THINK es un array doble: [0-primer objeto][0-field name]
        this.model = x;
        System.out.println("hola");
        //mainFrame.startBackgroundUpdates(x);

        x.startButton();

//        mainFrame.revalidate();
//        mainFrame.repaint();

    }

    public static void stopButton(){
        //TODO todo
    }

    public static void randomButton(){
        //TODO todo
    }

    public static void defaultButton(){
        //TODO todo
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
