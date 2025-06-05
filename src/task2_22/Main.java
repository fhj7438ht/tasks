package task2_22;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String dateStr = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dateFormat.parse(dateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 45);
        System.out.println("Дата после увеличения на 45 дней: " + dateFormat.format(calendar.getTime()));

        calendar.setTime(date);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Дата после сдвига на начало года: " + dateFormat.format(calendar.getTime()));

        calendar.setTime(date);
        int addedDays = 0;
        while (addedDays < 10) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                addedDays++;
            }
        }
        System.out.println("Дата после увеличения на 10 рабочих дней: " + dateFormat.format(calendar.getTime()));

        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        String secondDateStr = scanner.nextLine();
        Date secondDate = dateFormat.parse(secondDateStr);

        long diffInMillis = secondDate.getTime() - date.getTime();
        long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);

        int workingDaysCount = 0;
        calendar.setTime(date);
        for (long i = 0; i < diffInDays; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workingDaysCount++;
            }
        }

        System.out.println("Количество рабочих дней между введенными датами: " + workingDaysCount);
    }
}