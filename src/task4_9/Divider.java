package task4_9;

public class Divider implements Operation {
    @Override
    public double getResult(double a, double b) {
        if (b == 0) {
            throw new RuntimeException("Деление на ноль недопустимо");
        }
        return a / b;
    }
}