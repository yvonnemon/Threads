package org.example.view;

import org.example.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
