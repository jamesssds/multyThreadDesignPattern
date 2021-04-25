package singleThreadExecution.usesync;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing gate...");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
