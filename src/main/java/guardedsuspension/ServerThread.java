package guardedsuspension;

public class ServerThread extends Thread {
    private RequestQueue queue;

    public ServerThread(RequestQueue queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i<100;i++){
            Request request = queue.getRequest();
            System.out.println(Thread.currentThread().getName() + "获取请求" + request);
        }
    }
}
