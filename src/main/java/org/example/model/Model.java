package org.example.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Model {

    private int totalResources;

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

    private List<Thread> threadConsumer = new ArrayList<>();
    private List<Thread> threadProducers = new ArrayList<>();



    public Model() {
    }

    public void startButton() throws InterruptedException {
        //for i en total > crear resources; for i en resources > crear produces/consumers
        //pero el total es un random entre el max y min

        //THINK este bucle esta mal
        System.out.println("button play clicked");
         //segun la config se pueden crear mas etc
        //THINK esto se podria meter a una lista de resources para verlo en el swing
        for (int i = 0; i < this.totalResources; i++) {
            ResourceType resourceType = new ResourceType();
            resourceType.setId(i);
            resources.add(resourceType);
            createConsumers(resourceType);
            createProducers(resourceType);

            //THINK a lo mejor esto tendria que estar aqui, tbh lo pondria en el controller
            startTheKnitting();
        }
        System.out.println("Producers: " + producers.size());
        System.out.println("Consumers: " + consumers.size());
        System.out.println("Active threads: " + Thread.activeCount());
    }

    private void startTheKnitting() throws InterruptedException {

        //THINK a ver, crear una lista de resources, #? user input -> por cada recurso, crear producer/consumer, #? user input

        for (int i = 0; i < numberOfProducers; i++) {
            Thread t = new Thread(producers.get(i));
            threadProducers.add(t);
            //threads.add(t);


            t.start();
        }

        for (int i = 0; i < numberOfConsumers; i++) {
            Thread t = new Thread(consumers.get(i));
            threadConsumer.add(t);
            //threads.add(t);

            //TODO creo que aqui va el start delay, no en el run
            t.start();
        }

        System.out.println("All threads have finished creation.");
    }

    private void createConsumers(ResourceType resourceType){

        for (int c = 0; c < numberOfConsumers; c++) {
            this.consumers.add(new Consumer(resourceType, this.consumerDelayMax, this.consumerDelayMin, c));
        }
    }

    private void createProducers(ResourceType resourceType){

        for (int p = 0; p < numberOfProducers; p++) {
            this.producers.add(new Producer(resourceType, this.producerDelayMax, this.producerDelayMin, p));
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

    public synchronized List<Thread> getThreadConsumer() {
        return threadConsumer;
    }

    public void setThreadConsumer(List<Thread> threadConsumer) {
        this.threadConsumer = threadConsumer;
    }

    public synchronized List<Thread> getThreadProducers() {
        return threadProducers;
    }

    public void setThreadProducers(List<Thread> threadProducers) {
        this.threadProducers = threadProducers;
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Consumer> consumers) {
        this.consumers = consumers;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    public List<ResourceType> getResources() {
        return resources;
    }

    public void setResources(List<ResourceType> resources) {
        this.resources = resources;
    }
}
