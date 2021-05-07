package readwritelock;

import java.util.Random;

public class WriteThread extends Thread {
    private Data data;
    private String filler;
    private int index;
    private Random random = new Random();

    public WriteThread(Data data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        while (true) {
            try {
                char c = newChar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private char newChar() {
        char c = filler.charAt(index);
        index ++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}

