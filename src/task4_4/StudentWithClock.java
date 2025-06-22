package task4_4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Extending the functionality of a class as in the example using the decorator pattern
 */
public class StudentWithClock implements Learner {
    private Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        long start = System.currentTimeMillis();
        learner.learn();
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);
        System.out.println("Текущее время: " + formattedTime);
    }
}
