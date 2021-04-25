package balking;

import java.io.FileWriter;
import java.io.IOException;

public class Data {
    private final String fileName;
    private String content;
    private boolean change;

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        change = true;
    }

    public synchronized void change(String content) {
        this.content = content;
        change = true;
    }

    public synchronized void save() {
        if (!change) {
            return;
        }
        doSave();
        change = false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName() + "call doSave, content" + content);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
