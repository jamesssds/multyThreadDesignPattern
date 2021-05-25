package future;

public class FutureData implements Data {

    private RealData data = null;
    private boolean ready = false;
    public synchronized void setRealData(RealData data) {
        if (ready) {
            return;
        }
        this.data = data;
        this.ready = true;
        notifyAll();
    }

    public synchronized String getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return data.getContent();
    }
}
