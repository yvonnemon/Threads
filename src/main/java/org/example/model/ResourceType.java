package org.example.model;

import java.util.List;

public class ResourceType {
    private int quantity = 0;
    private Integer minQuantity;
    private Integer maxQuantity;
    private int id;

    private List<Producer> producers;
    private List<Consumer> consumers;

    public synchronized void addSyncResource(){
        System.out.println("produce");
        quantity++;
    }

    public synchronized void removeSyncResource(){
        System.out.println("consume");
        quantity--;
    }

    public void addResource(){
        quantity++;
    }

    public void removeResource(){
        quantity--;
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

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Consumer> consumers) {
        this.consumers = consumers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RType " +
                "id=" + id;
    }
}
