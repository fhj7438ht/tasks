package task3_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>(5);
        Scanner scanner = new Scanner(System.in);
        String name; int age;
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            name = scanner.nextLine();
            System.out.println("Введите возраст пользователя " + (i + 1));
            age = scanner.nextInt();
            scanner.nextLine(); //clean /n
            users.add(new User(name, age));
        }
        users.sort(new Comparator<User>() {
            public int compare(User a, User b) {
                return a.getAge() - b.getAge();
            }
        });
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
