package task4_5;

import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        int a = 10_000_000;
        int b = 1_000_000_000;

        long sum = getArithmeticProgressionSum(a, b);
        System.out.println("Сумма: " + sum);
    }

    public static long getArithmeticProgressionSum(int a, int b) {
        return LongStream.range(a, b).sum();
    }
}