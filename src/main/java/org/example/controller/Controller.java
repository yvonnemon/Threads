package org.example.controller;

import org.example.model.Consumer;
import org.example.model.Producer;
import org.example.model.ResourceType;

import java.util.ArrayList;

public class Controller {
    //THINK aqui tiene que haber los getters y setters del front
    //pero extiende de algo?

    public static void startButton(){ //THINK este deberia tener por parametro: el min y max de recursos
                                       //for i en total > crear resources; for i en resources > crear produces/consumers
                                        //pero el total es un random entre el max y min
        System.out.println("button play clicked");
        ResourceType resourceType = new ResourceType(); //segun la config se pueden crear mas etc
        //THINK a estos dos habria que añadirles parametro al consutrcor, los delays no se donde van
        ArrayList<Consumer> consumers = new ArrayList<>();
        ArrayList<Producer> producers = new ArrayList<>();


        //TODO i < # producers/consumers
        // crear las listas de consumes y producers
        for (int i = 0; i < 10000; i++) {
            consumers.add(new Consumer(resourceType)); //THINK seria añadir el constructor con los randoms datos aqui?
        }
        for (int i = 0; i < 10000; i++) {
            producers.add(new Producer(resourceType));
        }

        resourceType.setConsumers(consumers);
        resourceType.setProducers(producers);

        //TODO play como accion de jugar? en plan empezar? execute?
        resourceType.startTheThing();


        // Define Button 1 functionality here
        // JOptionPane.showMessageDialog(null, "Button 1 clicked!");
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
