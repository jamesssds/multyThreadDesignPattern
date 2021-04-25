package guardedsuspension;

public class ClientThread extends Thread {
    private RequestQueue queue;

    public ClientThread(RequestQueue queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Request request = new Request("No."+i);
            queue.putRequest(request);
            System.out.println(Thread.currentThread().getName() + "放入请求" + request);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
