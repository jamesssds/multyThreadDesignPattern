package workthread;



public class main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("John", channel).start();
        new ClientThread("James", channel).start();
    }
}
