package org.example.model;

public class Producer implements Runnable {
    private Stauts status;
    private Integer startTime;

    private Integer maxDelay;
    private Integer minDelay;

    private ResourceType resourceType;

    public Producer(ResourceType resourceType) {
        this.resourceType = resourceType;
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

        //System.out.println(Thread.currentThread().getName() + " started, state: " + Thread.currentThread().getState());
        //TODO cada producer/consumer repite su accion x veces

        try {
            for (int i = 0; i < 1000; i++) {
                //System.out.println(Thread.currentThread().getName() + " started, state: " + Thread.currentThread().getState());
                Thread.sleep(1);  // This makes the thread enter TIMED_WAITING
                //System.out.println(Thread.currentThread().getName() + " finished, state: " + Thread.currentThread().getState());
                //status = Stauts.NEW;
                produce();  // Calls ClassA.add()

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("INTERRUPTEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        }
    }
}
