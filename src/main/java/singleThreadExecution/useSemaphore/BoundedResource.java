package singleThreadExecution.useSemaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundedResource {
    private final int permits;
    private final Semaphore semaphore;
    private final static Random ramdom = new Random();

    public BoundedResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }

    }

    protected void doUse() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +" : Begin use = " + (permits - semaphore.availablePermits()));
        Thread.sleep(ramdom.nextInt(500));
        System.out.println(Thread.currentThread().getName() +" : End use = " + (permits - semaphore.availablePermits()));
    }
}
