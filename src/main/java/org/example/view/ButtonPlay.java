package org.example.view;

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
                ResourceType resourceType = new ResourceType();
                ArrayList<Consumer> consumers = new ArrayList<>();
                ArrayList<Producer> producers = new ArrayList<>();

                for (int i = 0; i < 5; i++) {
                    consumers.add(new Consumer()); //TODO seria añadir el constructor con los randoms datos aqui?
                }
                for (int i = 0; i < 5; i++) {
                    producers.add(new Producer());
                }

                resourceType.setConsumers(consumers);
                resourceType.setProducers(producers);


                // Define Button 1 functionality here
               // JOptionPane.showMessageDialog(null, "Button 1 clicked!");
            }
        });
    }
}
