package org.example.model;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private Stauts status;
    private Integer startTime;
    private Integer maxDelay;
    private Integer minDelay;

    private ResourceType resourceType;

    public Consumer(ResourceType resourceType, int maxDelay, int minDelay) {
        this.resourceType = resourceType;
        this.maxDelay = maxDelay;
        this.minDelay = minDelay;
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

    @Override
    public void run() {
        //THINK porque esta cosa era un loop infinito quje solo se tenia que parar con el boton de stop
        try {
            int delay = ThreadLocalRandom.current().nextInt(this.minDelay, this.maxDelay + 1);
            Thread.sleep(100L *delay);
            for (int i = 0; i < 1000; i++) {
                //System.out.println(Thread.currentThread().getName() + " started, state: " + Thread.currentThread().getState());
                Thread.sleep(1);  // This makes the thread enter TIMED_WAITING
                //System.out.println(Thread.currentThread().getName() + " finished, state: " + Thread.currentThread().getState());
                //status = Stauts.NEW;
                consume();  // Calls ClassA.add()

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("INTERRUPTEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        }
    }
}
