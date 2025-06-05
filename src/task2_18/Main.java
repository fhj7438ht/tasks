package task2_18;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Как тебя зовут?\n");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.print("Привет," + name);
    }
}
