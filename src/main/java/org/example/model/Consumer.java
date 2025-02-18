package org.example.model;

import org.example.controller.Controller;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private volatile boolean shouldStop = false;

    private Stauts status;
    private LocalDateTime startTime;
    private Integer maxDelay;
    private Integer minDelay;
    private int id;

    private ResourceType resourceType;

    public Consumer(ResourceType resourceType, int maxDelay, int minDelay, int id, Stauts status) {
        this.resourceType = resourceType;
        this.maxDelay = maxDelay;
        this.minDelay = minDelay;
        this.id = id;
        this.status = status;
        this.startTime = LocalDateTime.now();
    }

    public void syncConsume() {
        this.resourceType.removeSyncResource();
    }

    public void consume() {
        this.resourceType.removeResource();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return startTime.format(formatter);
    }

    public void stop() {
        shouldStop = true;
    }

    @Override
    public void run() {
        System.out.println("aaa");
        Random r = new Random();
        System.out.println(Controller.getInstance().getModel().getConsumerDelayMax() +"-"+ Controller.getInstance().getModel().getConsumerDelayMin());
        //int random = r.nextInt(Controller.getInstance().getModel().getConsumerDelayMax() - Controller.getInstance().getModel().getConsumerDelayMin()) + Controller.getInstance().getModel().getConsumerDelayMin();
        int randomValue = ThreadLocalRandom.current().nextInt(Controller.getInstance().getModel().getConsumerDelayMin(), Controller.getInstance().getModel().getProducerDelayMax() + 1);
       // while (!shouldStop) {
            try {
                if (Controller.getInstance().getModel().isStock()) { //stock esta checked
                    System.out.println("aaa1");
                    int a = Controller.getInstance().getModel().getMinQuantity();
                    System.out.println(a+"  min   "+resourceType.getQuantity());

                    itsStock(randomValue);
                } else { //aqui no
                    System.out.println("aaa2");
                    notStock(randomValue);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       // }
    }

    private void itsStock(int randomValue) throws InterruptedException { //si es sync viene aqui
        //aqui la condicion que dice cuando hacer accion si no hay stock
        if(resourceType.getQuantity() <= Controller.getInstance().getModel().getMinQuantity()){
            System.out.println("aaa3");
            //System.out.println("cantidad minima alcanzada, sudo de tragar cual perra");
            doAction(randomValue);
        }
    }

    private void notStock(int randomValue) throws InterruptedException { //no sync
        System.out.println("aaa4");
        doAction(randomValue);
    }

    private void doAction(int randomValue) throws InterruptedException {
        if (Controller.getInstance().getModel().getCyclesAmount() != 0) {
            System.out.println("aaa5");
            for (int i = 0; i < Controller.getInstance().getModel().getCyclesAmount(); i++) {
                this.setStatus(Stauts.RUNNABLE);
                if (shouldStop) {
                    break;
                }
                Thread.sleep(randomValue);  // This makes the thread enter TIMED_WAITING
                if (Controller.getInstance().getModel().isSynchronize()) {
                    System.out.println("CONSUMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                    syncConsume();
                } else {
                    consume();
                }
            }
        } else {
            System.out.println("aaa6");
            while (!shouldStop) {
                this.setStatus(Stauts.RUNNABLE);

                Thread.sleep(randomValue);  // This makes the thread enter TIMED_WAITING

                if (Controller.getInstance().getModel().isSynchronize()) {
                    System.out.println("CONSUMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                    syncConsume();
                } else {
                    consume();
                }
            }
        }
    }
    /*private void doAction(int randomValue) throws InterruptedException {
        if (Controller.getInstance().getModel().getCyclesAmount() != 0) {
            for (int i = 0; i < Controller.getInstance().getModel().getCyclesAmount(); i++) {
                this.setStatus(Stauts.RUNNABLE);
                if (shouldStop) {
                    break;
                }

                synchronized (resourceType) {
                    while (resourceType.getQuantity() <= 0) { // Wait if there's no stock
                        System.out.println("Consumer waiting: No resources available...");
                        resourceType.wait();
                        resourceType.notifyAll();
                    }
                    if (Controller.getInstance().getModel().isSynchronize()) {
                        syncConsume();
                    } else {
                        consume();
                    }
                    // Consume after waking up
                    resourceType.notifyAll(); // Wake up producer if it was waiting
                }

                Thread.sleep(randomValue);  // Simulating consumption delay
            }
        } else {
            while (!shouldStop) {
                this.setStatus(Stauts.RUNNABLE);

                synchronized (resourceType) {
                    while (resourceType.getQuantity() <= 0) { // Wait if stock is empty
                        System.out.println("2Consumer waiting: No resources available...");
                        resourceType.wait();
                        resourceType.notifyAll();
                    }
                    if (Controller.getInstance().getModel().isSynchronize()) {
                        syncConsume();
                    } else {
                        consume();
                    }

                    resourceType.notifyAll(); // Wake up producer
                }

                Thread.sleep(randomValue);  // Simulating consumption delay
            }
        }
    }*/



    private void dostuff3(){

    }
    private void dostuff4(){

    }

    public boolean isShouldStop() {
        return shouldStop;
    }

    public void setShouldStop(boolean shouldStop) {
        this.shouldStop = shouldStop;
    }

    public Stauts getStatus() {
        return status;
    }

    public void setStatus(Stauts status) {
        this.status = status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Integer getMaxDelay() {
        return maxDelay;
    }

    public void setMaxDelay(Integer maxDelay) {
        this.maxDelay = maxDelay;
    }

    public Integer getMinDelay() {
        return minDelay;
    }

    public void setMinDelay(Integer minDelay) {
        this.minDelay = minDelay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }
}
