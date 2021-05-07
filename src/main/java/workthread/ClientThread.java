package workthread;


import java.util.Random;

public class ClientThread extends Thread {
    private final Channel channel;
    private String name;
    private static final Random random = new Random();
    public ClientThread(String name, Channel channel) {
        super(name);
        this.name  = name;
        this.channel = channel;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            Request request = new Request(this.name, i);
            channel.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
    }
}
