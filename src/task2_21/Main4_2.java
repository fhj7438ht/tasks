package task2_21;
import java.util.Scanner;

public class Main4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        String str = scanner.nextLine();

        str = str.replace("кака", "вырезано цензурой");
        str = str.replace("бяка", "вырезано цензурой");

        System.out.println(str);
    }
}
