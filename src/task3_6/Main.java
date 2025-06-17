package task3_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, List<User>> users = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String name; int age;
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            name = scanner.nextLine();
            System.out.println("Введите возраст пользователя " + (i + 1));
            age = scanner.nextInt();
            scanner.nextLine(); //clean /n
            if (!users.containsKey(age))
                users.put(age, new ArrayList<>(List.of(new User(name, age))));
            else
                users.get(age).add(new User(name, age));
        }
        System.out.println("Введите требуемый возраст");
        age = scanner.nextInt();
        scanner.nextLine(); //clean /n
        if (!users.containsKey(age))
            System.out.println("Пользователей с указанным возрастом не найдено");
        else{
            users.get(age).sort(new Comparator<User>() {
                public int compare(User a, User b) {
                    return a.getName().compareTo(b.getName());
                }
            });
            for(User user : users.get(age)){
                System.out.println(user.toString());
            }
        }
    }
}
