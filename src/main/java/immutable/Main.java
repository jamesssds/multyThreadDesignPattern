package immutable;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("19", "json");
        new PersonThread(person).start();
        new PersonThread(person).start();
        new PersonThread(person).start();
    }
}
