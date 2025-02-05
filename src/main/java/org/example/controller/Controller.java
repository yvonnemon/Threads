package org.example.controller;

import org.example.model.Consumer;
import org.example.model.Model;
import org.example.model.Producer;
import org.example.model.ResourceType;
import org.example.view.ConfigPanel;
import org.example.view.DataPanel;
import org.example.view.MainFrame;

import java.util.ArrayList;

public class Controller {
    //todo CONSUMIDORES Y PRODUCTORES SE CREAN EN EL MODELO
    public static void startButton(){
        //TODO get data
        Model x = ConfigPanel.getConfigData(); //THINK es un array doble: [0-primer objeto][0-field name]
        System.out.println("hola");
        Model model = new Model(
                x.getTotalResources(),
                x.getMaxResources(),
                x.getMinResources(),
                x.getNumberOfProducers(),
                x.getNumberOfConsumers(),
                x.getStartDelayMin(),
                x.getStartDelayMax(),
                x.getProducerDelayMin(),
                x.getProducerDelayMax(),
                x.getConsumerDelayMin(),
                x.getConsumerDelayMax()
        );

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
}
