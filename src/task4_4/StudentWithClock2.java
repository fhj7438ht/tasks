package task4_4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * class that does not use the decorator pattern
 */
public class StudentWithClock2 extends Student {
    @Override
    public void learn(){
        long start = System.currentTimeMillis();
        super.learn();
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);
        System.out.println("Текущее время: " + formattedTime);
    }
}
