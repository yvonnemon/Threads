package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int totalResources = 5;

    private int maxResources;
    private int minResources;

    private int numberOfProducers;
    private int numberOfConsumers;

    private int startDelayMin;
    private int startDelayMax;

    private int producerDelayMin;
    private int producerDelayMax;

    private int consumerDelayMin;
    private int consumerDelayMax;

    private List<Consumer> consumers = new ArrayList<>();
    private List<Producer> producers = new ArrayList<>();
    private List<ResourceType> resources = new ArrayList<>();


    public Model() {
    }

    public void startButton(){
        //for i en total > crear resources; for i en resources > crear produces/consumers
        //pero el total es un random entre el max y min

        //THINK este bucle esta mal
        System.out.println("button play clicked");
         //segun la config se pueden crear mas etc
        //THINK esto se podria meter a una lista de resources para verlo en el swing
        for (int i = 0; i < this.totalResources; i++) {
            ResourceType resourceType = new ResourceType();

            //crear las listas de consumes y producers
            createConsumers(resourceType);
            createProducers(resourceType);

            resourceType.setConsumers(this.consumers);
            resourceType.setProducers(this.producers);

            //THINK a lo mejor esto tendria que estar aqui, tbh lo pondria en el controller
            startTheKnitting();
        }
        System.out.println("Producers: " + producers.size());
        System.out.println("Consumers: " + consumers.size());

    }

    private void startTheKnitting(){

        List<Thread> threads = new ArrayList<>(); //TODO cambiar a una lista de cada porque creo que los necesito para pintarlos

        //THINK a ver, crear una lista de resources, #? user input -> por cada recurso, crear producer/consumer, #? user input

        for (Producer producer : producers) {
            Thread t = new Thread(producer);
            threads.add(t);
            //TODO creo que aqui va el start delay, no en el run
            t.start();
        }
        for (Consumer consumer : consumers) {
            Thread t = new Thread(consumer);
            threads.add(t);
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            try {
                t.join();  // Waits for thread t to complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads have finished execution.");
    }

    private void createConsumers(ResourceType resourceType){

        for (int c = 0; c < numberOfConsumers; c++) {
            this.consumers.add(new Consumer(resourceType, this.consumerDelayMax, this.consumerDelayMin));
        }
    }

    private void createProducers(ResourceType resourceType){

        for (int p = 0; p < numberOfProducers; p++) {
            this.producers.add(new Producer(resourceType, this.producerDelayMax, this.producerDelayMin));
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
