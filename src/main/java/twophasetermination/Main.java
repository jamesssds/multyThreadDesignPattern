package twophasetermination;

public class Main {
    public static void main(String[] args) {
        System.out.println("main start");
        try {
            CountupThread t = new CountupThread();
            t.start();
            Thread.sleep(10000);
            System.out.println("main: shutDownRequest");
            t.shutDownRequest();

            System.out.println("main: join");
            t.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main End");

    }
}
