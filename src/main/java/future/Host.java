package future;

public class Host {

    public Data request(final int count, final char c) {
        final FutureData futureData = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData(count, c);
            futureData.setRealData(realData);
        }).start();

        System.out.println("    request(" + count + "," + c + ") END");
        return futureData;
    }
}
