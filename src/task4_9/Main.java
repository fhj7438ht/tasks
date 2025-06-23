package task4_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();

        System.out.print("Результат сложения: ");
        new Calculator(new Adder()).calc(a, b);
        //Или так. В примере поле operation почему-то не имеет модификатора доступа private
        //System.out.println("Результат сложения: " + new Calculator(new Adder()).operation.getResult(a,b));

        System.out.print("Результат вычитания: ");
        new Calculator(new Subtractor()).calc(a, b);

        System.out.print("Результат умножения: ");
        new Calculator(new Multiplier()).calc(a, b);

        System.out.print("Результат деления: ");
        try {
            new Calculator(new Divider()).calc(a, b);
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        scanner.close();
    }
}