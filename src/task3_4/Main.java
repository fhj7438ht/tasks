package task3_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя первого пользователя:");
        String name = scanner.nextLine();
        System.out.println("Введите возраст первого пользователя");
        int age = scanner.nextInt();
        scanner.nextLine(); //clean /n
        User firstUser = new User(name, age);
        System.out.println("Введите имя второго пользователя:");
        name = scanner.nextLine();
        System.out.println("Введите возраст второго пользователя");
        age = scanner.nextInt();
        scanner.nextLine(); //clean /n
        User secondUser = new User(name, age);

        User youngerUser = (firstUser.getAge() < secondUser.getAge()) ? firstUser : secondUser;
        System.out.println(youngerUser.toString());
    }
}
