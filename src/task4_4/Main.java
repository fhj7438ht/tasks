package task4_4;

public class Main {
    public static void main(String[] args) {
        new StudentWithTimer(new StudentWithClock(new Student())).learn();
        //new StudentWithClock2().learn();
    }
}
