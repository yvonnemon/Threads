package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStop extends JButton {
    public ButtonStop() {
        setText("Stop");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define Button 2 functionality here
                JOptionPane.showMessageDialog(null, "Button 2 clicked!");
            }
        });
    }
}
