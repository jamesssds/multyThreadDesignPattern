package readwritelock;

public class Main {
    public static void main(String[] args) {
        Data data = new Data(10);
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data, "ABCDEFGHIJKLMN").start();
        new WriteThread(data, "abcdefghijklmn").start();

    }
}
