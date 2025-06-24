package tasks.task4_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Adder implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a + b;
    }
}
