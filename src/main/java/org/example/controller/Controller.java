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
    private Model model;
    private MainFrame mainFrame;

    public Controller() {
        this.model = new Model();
    }

    public void startSwing(){
        SwingUtilities.invokeLater(() -> {
            mainFrame = new MainFrame(model);
            mainFrame.setVisible(true);

        });
    }

    public void startButton(){
        //TODO get data
        Model x = ConfigPanel.getConfigData(); //THINK es un array doble: [0-primer objeto][0-field name]
        this.model = x;
        System.out.println("hola");
        x.startButton();
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.startBackgroundUpdates(x);
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
}
