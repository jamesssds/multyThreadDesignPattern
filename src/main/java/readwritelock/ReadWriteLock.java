package readwritelock;

public final class ReadWriteLock {
    private int readingReader = 0;
    private int waitingWriters = 0;
    private int writingWriters = 0;
    private boolean preferWrite = true;

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWrite && waitingWriters > 0)) {
            wait();
        }
        readingReader ++;
    }

    public synchronized void readUnlock() {
        readingReader --;
        preferWrite = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters ++;
        try {
            while (readingReader > 0 && writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters --;
        }
        writingWriters ++;
    }

    public synchronized void writeUnlock() {
        writingWriters --;
        preferWrite = false;
        notifyAll();
    }
}
