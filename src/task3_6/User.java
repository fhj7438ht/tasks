package task3_6;
public class User {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private static String getYearWord(int years) {
        int lastTwoDigits = years % 100;
        int lastDigit = years % 10;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return "лет";
        }

        return switch (lastDigit) {
            case 1 -> "год";
            case 2, 3, 4 -> "года";
            default -> "лет";
        };
    }
    public String toString() {
        return "Имя: " + this.name + ", возраст: " + this.age + " " + getYearWord(this.age);
    }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}