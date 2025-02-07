package org.example;

import org.example.controller.Controller;
import org.example.view.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Controller controller = new Controller();
        controller.startSwing();
    }
}