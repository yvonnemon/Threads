package org.example.view;

import org.example.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStop extends JButton {
    public ButtonStop() {
        setText("Stop");
        addActionListener(e -> {
            Controller.getInstance().stopButton();
        });
    }
}
