package task2_21;
import java.util.Scanner;

public class Main4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        String str = scanner.nextLine();

        System.out.println("Введите подстроку");
        String substring = scanner.nextLine();

        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        System.out.println("Подстрока '" + substring + "' встречается " + count + " раза");
    }
}