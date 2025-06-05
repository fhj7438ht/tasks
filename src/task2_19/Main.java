package task2_19;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> entered = new HashMap<>();
        System.out.print("Введите 3 числа\n");
        Scanner scanner = new Scanner(System.in);
        entered.put("a", scanner.nextInt());
        entered.put("b", scanner.nextInt());
        entered.put("c", scanner.nextInt());

        boolean wasOutput = false;
        for (Map.Entry<String, Integer> entry : entered.entrySet())
            if(entry.getValue() % 5 == 0){
                System.out.println(entry.getKey() + "=" + entry.getValue());
                wasOutput = true;
            }
        if(!wasOutput)
            System.out.println("Нет значений, кратных 5");

        int a = entered.get("a");
        int b = entered.get("b");
        int c = entered.get("c");

        if (b != 0) {
            System.out.println("Результат целочисленного деления a на b: " + a / b);

            double floatDivision = (double) a / b;
            System.out.println("Результат деления a на b: " + floatDivision);

            int ceilDivision = (int) Math.ceil(floatDivision);
            System.out.println("Результат деления a на b с округлением в большую сторону: " + ceilDivision);

            int floorDivision = (int) Math.floor(floatDivision);
            System.out.println("Результат деления a на b с округлением в меньшую сторону: " + floorDivision);

            int roundDivision = (int) Math.round(floatDivision);
            System.out.println("Результат деления a на b с математическим округлением: " + roundDivision);
        } else {
            System.out.println("Деление a на b невозможно (делитель равен 0)");
        }

        if (c != 0) {
            int remainder = b % c;
            System.out.println("Остаток от деления b на c: " + remainder);
        } else {
            System.out.println("Остаток от деления b на c невозможно вычислить (делитель равен 0)");
        }

        System.out.println("Наименьшее значение из a и b: " + Math.min(a, b));
        System.out.println("Наибольшее значение из b и c: " + Math.max(b, c));
    }
}
