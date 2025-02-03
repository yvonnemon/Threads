package org.example.model;

import java.util.ArrayList;

public class ResourceType {
    private Integer quantity = 0;
    private Integer minQuantity;
    private Integer maxQuantity;
    //TODO entonces tiene una lista de consumers y producers
    private ArrayList<Producer> producers = new ArrayList<Producer>();
    private ArrayList<Consumer> consumers = new ArrayList<Consumer>();

    public synchronized void addResource(){
        quantity++;
    }

    public synchronized void removeResource(){
        quantity--;
    }

    public synchronized Integer getQuantity() {
        return quantity;
    }

    public synchronized void setQuantity(Integer quantity) {
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
