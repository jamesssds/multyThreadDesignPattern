package guardedsuspension;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {

    private Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        while(queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
