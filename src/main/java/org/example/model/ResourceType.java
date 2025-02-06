package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ResourceType {
    private int quantity = 0;
    private Integer minQuantity;
    private Integer maxQuantity;
    //THINK entonces tiene una lista de consumers y producers
    private ArrayList<Producer> producers;
    private ArrayList<Consumer> consumers;

    public synchronized void addResource(){
       //System.out.println("addResource quantity++" + quantity);
        System.out.println("Thread ID in add: " + Thread.currentThread().threadId());



        quantity++;
    }

    public synchronized void removeResource(){
       //System.out.println("removeResource quantity--" + quantity);
        System.out.println("Thread ID in remove: " + Thread.currentThread().threadId());
        quantity--;
    }

    public void startTheThing(){ //THINK este deberia ser el que pida los parametros de delay?
        List<Thread> threads = new ArrayList<>(); //TODO cambiar a una lista de cada

        for (Producer producer : producers) {
            Thread t = new Thread(producer);
            threads.add(t);
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

    public synchronized int getQuantity() {
        return quantity;
    }

    public synchronized void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public ArrayList<Producer> getProducers() {
        return producers;
    }

    public void setProducers(ArrayList<Producer> producers) {
        this.producers = producers;
    }

    public ArrayList<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(ArrayList<Consumer> consumers) {
        this.consumers = consumers;
    }

}
