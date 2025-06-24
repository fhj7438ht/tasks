package tasks.task4_10;

import org.springframework.stereotype.Component;

@Component
public class Multiplier implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a * b;
    }
}