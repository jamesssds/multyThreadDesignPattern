package readwritelock;

public class ReadThread extends Thread{
    private Data data;

    public ReadThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            try {
                char[] read = data.read();
                System.out.println(Thread.currentThread().getName() + " read " + String.valueOf(read));
            } catch (InterruptedException e) {

            }
        }
    }
}
