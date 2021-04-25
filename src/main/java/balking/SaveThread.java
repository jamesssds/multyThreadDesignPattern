package balking;

public class SaveThread extends Thread {
    private Data data;
    public SaveThread(Data data, String threadName) {
        super(threadName);
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            data.save();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
