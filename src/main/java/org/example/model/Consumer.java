package org.example.model;

public class Consumer implements Runnable {
    private Stauts status;
    private Integer startTime;
    private Integer maxDelay;
    private Integer minDelay;

    private ResourceType resourceType;

    public Consumer(ResourceType resourceType) {
        this.resourceType = resourceType;
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
        try {
            //System.out.println(Thread.currentThread().getName() + " started, state: " + Thread.currentThread().getState());
            Thread.sleep(1000);  // This makes the thread enter TIMED_WAITING
            //System.out.println(Thread.currentThread().getName() + " finished, state: " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("INTERRUPTEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        }
        status = Stauts.NEW;

        consume();
    }
}
