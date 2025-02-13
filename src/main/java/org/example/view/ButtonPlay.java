package org.example.view;

import org.example.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonPlay extends JButton {

    public ButtonPlay() {
        setText("Play"); // Add Play Icon
        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setBackground(new Color(50, 150, 250)); // Blue color
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addActionListener(e -> {
            try {
                Controller.getInstance().startButton();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Add hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.WHITE);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Create gradient background
            GradientPaint paint = new GradientPaint(0, 0, new Color(50, 150, 250), 0, getHeight(), new Color(104, 196, 245));
            g2.setPaint(paint);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded corners

            g2.dispose();
        }
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No border for a cleaner look
    }
}
