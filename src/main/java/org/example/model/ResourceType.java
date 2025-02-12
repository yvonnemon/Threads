package org.example.model;

import org.example.controller.Controller;

import java.util.List;
import java.util.List;

public class ResourceType {
    private int quantity = 0;
    private Integer minQuantity;
    private Integer maxQuantity;
    private int id;
    //THINK entonces tiene una lista de consumers y producers
    private List<Producer> producers;
    private List<Consumer> consumers;

    public synchronized void addResource(){
       //System.out.println("addResource quantity++" + quantity);
        //if(Thread.currentThread().threadId() ==40){

       // }
        quantity++;
        //System.out.println(quantity + "Thread ID in add: " + Thread.currentThread().threadId());
    }

    public synchronized void removeResource(){
       //System.out.println("removeResource quantity--" + quantity);
        //if(Thread.currentThread().threadId() ==40){

        //}
        quantity--;
      // System.out.println(quantity + "Thread ID in remove: " + Thread.currentThread().threadId());
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
