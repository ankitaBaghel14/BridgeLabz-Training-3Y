import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("8"); // Custom input
        System.out.println("Enter a number:");
        int number = scanner.nextInt();

        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        scanner.close();
    }
}
