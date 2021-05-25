package twophasetermination;

public class CountupThread extends Thread {
    private int count;
    private volatile boolean shutDownRequest = false;

    public void shutDownRequest() {
        shutDownRequest = true;
        interrupt();
    }

    @Override
    public void run() {
        try {
            while (!shutDownRequest) {
                doWork();
            }
        } catch (InterruptedException e) {

        } finally {
            doShutDown();
        }

    }

    private void doShutDown() {
        System.out.println("doShutDown: count = " + count);
    }

    private void doWork() throws InterruptedException {
        count ++;
        System.out.println("doWork: count = " + count);
        Thread.sleep(500);
    }
}
