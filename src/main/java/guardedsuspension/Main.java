package guardedsuspension;

import com.sun.security.ntlm.Server;

public class Main {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "client").start();
        new ServerThread(queue, "server").start();

    }
}
