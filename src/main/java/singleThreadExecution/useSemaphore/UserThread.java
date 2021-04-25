package singleThreadExecution.useSemaphore;

import java.util.Random;

public class UserThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;
    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {

        }
    }
}
