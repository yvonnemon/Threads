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
}
