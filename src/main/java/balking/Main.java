package balking;

public class Main {
    public static void main(String[] args) {
        Data data = new Data("C:\\Users\\james\\Desktop\\新的.txt", "新的");
        new SaveThread(data, "SaveThread").start();
        new ChangerThread(data, "ChangerThread").start();
    }
}
