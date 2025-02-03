package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonConfig extends JButton {
    public ButtonConfig() {
        setText("Set Config");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define Button 1 functionality here
                JOptionPane.showMessageDialog(null, "Button 1 clicked!");
            }
        });
    }
}
