package org.example.model;


import org.example.controller.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Producer implements Runnable {
    private volatile boolean shouldStop = false;
    private Stauts status;
    private LocalDateTime startTime; //TODO un print de time stamp
    private int id;
    private Integer maxDelay;
    private Integer minDelay;

    private ResourceType resourceType;

    public Producer(ResourceType resourceType, int maxDelay, int minDelay, int id, Stauts status) {
        this.resourceType = resourceType;
        this.maxDelay = maxDelay;
        this.minDelay = minDelay;
        this.id = id;
        this.status = status;
        this.startTime = LocalDateTime.now();
    }

    public void syncProduce() {
        this.resourceType.addSyncResource();
    }

    public void produce() {
        this.resourceType.addResource();
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

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        //while (!shouldStop) {
            try {
                for (int i = 0; i < 1000; i++) {
                    this.setStatus(Stauts.RUNNABLE);
                if (shouldStop) {
                    break;
                }
                Thread.sleep(1);  // This makes the thread enter TIMED_WAITING
                    if(Controller.getInstance().getModel().isSynchronize()) {
                        syncProduce();
                    } else {
                        produce();
                    }

                }
                //break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        //}
    }
}
