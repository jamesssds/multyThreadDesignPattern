package immutable;

public class PersonThread extends Thread {
    private Person person;
    public PersonThread(Person person) {
        this.person = person;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() +"personThread 打印名字" + person);
        }
    }
}
