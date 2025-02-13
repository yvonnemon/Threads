package org.example.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Model {

    private int totalResources;

    private int maxQuantity;
    private int minQuantity;

    private int numberOfProducers;
    private int numberOfConsumers;

    private int startDelayMin;
    private int startDelayMax;

    private int producerDelayMin;
    private int producerDelayMax;

    private int consumerDelayMin;
    private int consumerDelayMax;

    private boolean synchronize;

    private List<Consumer> consumers = new ArrayList<>();
    private List<Producer> producers = new ArrayList<>();
    private List<ResourceType> resources = new ArrayList<>();

    private List<Thread> threadConsumer = new ArrayList<>();
    private List<Thread> threadProducers = new ArrayList<>();


    public Model() {
    }

    public void startButton() throws InterruptedException {
        System.out.println(synchronize);
        //for i en total > crear resources; for i en resources > crear produces/consumers
        //pero el total es un random entre el max y min

        System.out.println("button play clicked");
        //segun la config se pueden crear mas etc
        Random random = new Random();
        //int randomResources = random.nextInt(maxResources - minResources + 2);

       // int randomResources = random.nextInt(10) + 1;

        //this.totalResources = randomResources;
        for (int i = 0; i < this.totalResources; i++) {
            ResourceType resourceType = new ResourceType();
            int quantity = random.nextInt(maxQuantity - minQuantity + 2);
            resourceType.setMaxQuantity(maxQuantity);
            resourceType.setMinQuantity(minQuantity);
            resourceType.setId(i);
            resources.add(resourceType);
            System.out.println("creando " + random + " resources");
        }

        for (int i = 0; i < resources.size(); i++) {
            Random random2 = new Random();
            int randomIndex = random2.nextInt(resources.size());
            System.out.println("asignando resources  " + randomIndex);
            createConsumers(resources.get(randomIndex));
            createProducers(resources.get(randomIndex));
        }

        startTheKnitting();

        System.out.println("Producers: " + producers.size());
        System.out.println("Consumers: " + consumers.size());
        System.out.println("Active threads: " + Thread.activeCount());
    }

    private void startTheKnitting() throws InterruptedException {

        // crear una lista de resources, #? user input -> por cada recurso, crear producer/consumer, #? user input

        // Create producer threads
        for (Producer producer : producers) {
            System.out.println("Creating producer threads");
            Thread t = new Thread(producer);
            threadProducers.add(t);
        }

        // Create consumer threads
        for (Consumer consumer : consumers) {
            System.out.println("Creating consumer threads");
            Thread t = new Thread(consumer);
            threadConsumer.add(t);
        }

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                // Start producer threads with delay
                for (Thread thread : threadProducers) {
                    try {
                        int delay = ThreadLocalRandom.current().nextInt(startDelayMin, startDelayMax + 1);
                        Thread.sleep(delay * 100L);
                        System.out.println("Starting producer thread");
                        thread.start();
                    } catch (InterruptedException ignored) {
                    }
                }
                System.out.println("All threads have finished creation.");
                return null;
            }

            @Override
            protected void done() {
                System.out.println("SwingWorker finished!");

            }
        };
        SwingWorker<Void, Void> worker2 = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {

                // Start consumer threads with delay
                for (Thread thread : threadConsumer) {
                    try {
                        int delay = ThreadLocalRandom.current().nextInt(startDelayMin, startDelayMax + 1);
                        Thread.sleep(delay * 100L);
                        System.out.println("Starting consumer thread");
                        thread.start();
                    } catch (InterruptedException ignored) {
                    }
                }
                System.out.println("All threads have finished creation.");
                return null;
            }
            @Override
            protected void done() {
                System.out.println("SwingWorker finished!");
            //TODO
            }

        };

        worker.execute();
        worker2.execute();// Runs in a background thread
    }

    private void createConsumers(ResourceType resourceType) {
        System.out.println("creado consumers");
        for (int c = 0; c < numberOfConsumers; c++) {
            this.consumers.add(new Consumer(resourceType, this.consumerDelayMax, this.consumerDelayMin, c, Stauts.NEW));
        }
    }

    private void createProducers(ResourceType resourceType) {
        System.out.println("creado producers");
        for (int p = 0; p < numberOfProducers; p++) {
            this.producers.add(new Producer(resourceType, this.producerDelayMax, this.producerDelayMin, p, Stauts.NEW));
        }
    }

    public void stopAllThreads() {
        System.out.println("Stopping all threads...");

        // Stop all producers
        for (Producer producer : producers) {
            producer.setStatus(Stauts.TERMINATED);
            producer.stop();  // Set the stop flag
        }

        // Stop all consumers
        for (Consumer consumer : consumers) {
            consumer.setStatus(Stauts.TERMINATED);
            consumer.stop();
        }

        // Wait for all threads to finish
        for (Thread thread : threadProducers) {
            try {
                thread.join();  // Wait for thread to terminate
            } catch (InterruptedException ignored) {
            }
        }

        for (Thread thread : threadConsumer) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
        }

        System.out.println("All threads have been stopped.");
    }

    public boolean isSynchronize() {
        return synchronize;
    }

    public void setSynchronize(boolean synchronize) {
        this.synchronize = synchronize;
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

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
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
