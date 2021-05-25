package workthread.theadpool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class ClientThread extends Thread {
    private final ExecutorService executorService;
    private static final Random random = new Random();
    private final String name;
    public ClientThread(String name, ExecutorService executorService) {
        super(name);
        this.name = name;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(name, i);
                executorService.execute(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RejectedExecutionException e) {
            System.out.println(name + " : " + e);
        }
    }
}
