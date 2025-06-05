package task2_21;
import java.util.Scanner;

public class Main4_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод даты
        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String date = scanner.nextLine();

        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6);

        String formattedDate = year + "-" + month + "-" + day;

        System.out.println(formattedDate);
    }
}
