package org.example.model;

import org.example.view.ConfigPanel;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Model {

    //THINK aqui tiene que haber los getters y setters del front
    //pero extiende de algo?
    private int totalResources = 5;

    private int maxResources;
    private int minResources;

    private int numberOfProducers;
    private int numberOfConsumers;

    private int startDelayMin;
    private int startDelayMax;

    private int producerDelayMin = 5;
    private int producerDelayMax;

    private int consumerDelayMin;
    private int consumerDelayMax;

    private ArrayList<Consumer> consumers = new ArrayList<>();
    private ArrayList<Producer> producers = new ArrayList<>();

    public Model() {
    }

    public Model(int totalResources, int maxResources, int minResources, int numberOfProducers, int numberOfConsumers, int startDelayMin,
                 int startDelayMax, int producerDelayMin, int producerDelayMax, int consumerDelayMin, int consumerDelayMax) {
        this.totalResources = totalResources;
        this.maxResources = maxResources;
        this.minResources = minResources;
        this.numberOfProducers = numberOfProducers;
        this.numberOfConsumers = numberOfConsumers;
        this.startDelayMin = startDelayMin;
        this.startDelayMax = startDelayMax;
        this.producerDelayMin = producerDelayMin;
        this.producerDelayMax = producerDelayMax;
        this.consumerDelayMin = consumerDelayMin;
        this.consumerDelayMax = consumerDelayMax;

        startButton();
    }

    private void startButton(){
        //for i en total > crear resources; for i en resources > crear produces/consumers
        //pero el total es un random entre el max y min


        System.out.println("button play clicked");
         //segun la config se pueden crear mas etc
        for (int i = 0; i < this.totalResources; i++) {
            ResourceType resourceType = new ResourceType();

            //THINK los delays no se donde van

            //TODO crear las listas de consumes y producers
            int consumersNumber = this.numberOfConsumers;
            int producerNumbers = this.numberOfProducers;

            for (int c = 0; c < consumersNumber; c++) {
                consumers.add(new Consumer(resourceType, this.consumerDelayMax, this.consumerDelayMin));
            }
            for (int p = 0; p < producerNumbers; p++) {
                producers.add(new Producer(resourceType, this.producerDelayMax, this.producerDelayMin));
            }

            resourceType.setConsumers(consumers);
            resourceType.setProducers(producers);

            //THINK a lo mejor esto tendria que estar aqui, tbh lo pondria en el controller
            resourceType.startTheThing();
        }
    }

    public int getStartDelayMin() {
        return startDelayMin;
    }

    public void setStartDelayMin(int startDelayMin) {
        this.startDelayMin = startDelayMin;
    }

    public int getStartDelayMax() {
        return startDelayMax;
    }

    public void setStartDelayMax(int startDelayMax) {
        this.startDelayMax = startDelayMax;
    }

    public int getProducerDelayMin() {
        return producerDelayMin;
    }

    public void setProducerDelayMin(int producerDelayMin) {
        this.producerDelayMin = producerDelayMin;
    }

    public int getProducerDelayMax() {
        return producerDelayMax;
    }

    public void setProducerDelayMax(int producerDelayMax) {
        this.producerDelayMax = producerDelayMax;
    }

    public int getConsumerDelayMin() {
        return consumerDelayMin;
    }

    public void setConsumerDelayMin(int consumerDelayMin) {
        this.consumerDelayMin = consumerDelayMin;
    }

    public int getConsumerDelayMax() {
        return consumerDelayMax;
    }

    public void setConsumerDelayMax(int consumerDelayMax) {
        this.consumerDelayMax = consumerDelayMax;
    }

    public int getTotalResources() {
        return totalResources;
    }

    public void setTotalResources(int totalResources) {
        this.totalResources = totalResources;
    }

    public int getMaxResources() {
        return maxResources;
    }

    public void setMaxResources(int maxResources) {
        this.maxResources = maxResources;
    }

    public int getMinResources() {
        return minResources;
    }

    public void setMinResources(int minResources) {
        this.minResources = minResources;
    }

    public int getNumberOfProducers() {
        return numberOfProducers;
    }

    public void setNumberOfProducers(int numberOfProducers) {
        this.numberOfProducers = numberOfProducers;
    }

    public int getNumberOfConsumers() {
        return numberOfConsumers;
    }

    public void setNumberOfConsumers(int numberOfConsumers) {
        this.numberOfConsumers = numberOfConsumers;
    }
}
