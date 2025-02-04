package org.example.view;

import org.example.controller.Controller;
import org.example.model.Consumer;
import org.example.model.Producer;
import org.example.model.ResourceType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonPlay extends JButton {
    public ButtonPlay() {
        setText("Play");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buttonStart();
                Controller.startButton();
            }
        });
    }

    private static void buttonStart() {
        System.out.println("button play clicked");
        ResourceType resourceType = new ResourceType(); //segun la config se pueden crear mas etc
        ArrayList<Consumer> consumers = new ArrayList<>();
        ArrayList<Producer> producers = new ArrayList<>();


        //crear las listas de consumes y producers
        for (int i = 0; i < 50; i++) {
            consumers.add(new Consumer(resourceType)); //TODO seria añadir el constructor con los randoms datos aqui?
        }
        for (int i = 0; i < 50; i++) {
            producers.add(new Producer(resourceType));
        }

        resourceType.setConsumers(consumers);
        resourceType.setProducers(producers);

        //TODO play como accion de jugar? en plan empezar? execute?
        resourceType.startTheThing();


        // Define Button 1 functionality here
        // JOptionPane.showMessageDialog(null, "Button 1 clicked!");
    }
}
