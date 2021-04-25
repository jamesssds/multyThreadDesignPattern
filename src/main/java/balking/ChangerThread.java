package balking;

import java.util.Random;

public class ChangerThread extends Thread {
    private Data data;
    Random random = new Random();

    public ChangerThread(Data data, String threadName) {
        super(threadName);
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++){

            try {
                data.change("No." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            } catch (InterruptedException e) {
            }
        }
    }
}
