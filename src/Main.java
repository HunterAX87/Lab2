import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите свое имя");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.println("Hello, "+username);

    }
}