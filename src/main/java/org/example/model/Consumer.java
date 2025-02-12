package org.example.model;

import org.example.controller.Controller;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private volatile boolean shouldStop = false;

    private Stauts status;
    private Integer startTime;
    private Integer maxDelay;
    private Integer minDelay;
    private int id;

    private ResourceType resourceType;

    public Consumer(ResourceType resourceType, int maxDelay, int minDelay, int id) {
        this.resourceType = resourceType;
        this.maxDelay = maxDelay;
        this.minDelay = minDelay;
        this.id = id;
    }

    public void consume() {
        this.resourceType.removeResource();
    }

    public Stauts getStatus() {
        return status;
    }

    public void setStatus(Stauts status) {
        this.status = status;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
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

    public void stop() {
        shouldStop = true;
    }

    @Override
    public void run() {
        //while (!shouldStop) {
            try {
                for (int i = 0; i < 1000; i++) {
                    if (shouldStop) {
                        break;
                    }
                    Thread.sleep(1);  // This makes the thread enter TIMED_WAITING
                consume();  // Calls ClassA.add()
                 }
              //  break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

       // }
    }


}
