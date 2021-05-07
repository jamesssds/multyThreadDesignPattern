package readwritelock;

import java.util.Arrays;

public class Data {
    private final char[] buffered;
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size) {
        this.buffered = new char[size];
        Arrays.fill(buffered, '*');
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();
        } finally {
            lock.readUnlock();
        }

    }

    public void write(char c) throws InterruptedException  {
        lock.writeLock();
        try {
            doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) throws InterruptedException {
        for (int i = 0;i <buffered.length; i++) {
            buffered[i] = c;
            slowly();
        }
    }

    private char[] doRead() {
        char[] newBuffered = new char[buffered.length];
        System.arraycopy(buffered, 0, newBuffered, 0, buffered.length);
        slowly();
        return newBuffered;

    }
    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {

        }
    }
}
