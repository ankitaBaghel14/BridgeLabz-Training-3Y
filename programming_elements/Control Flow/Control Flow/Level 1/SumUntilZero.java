import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double number;
        System.out.println("Enter numbers to sum. Enter 0 to stop.");
        System.out.print("Enter a number: ");
        number = scanner.nextDouble();
        while (number != 0) {
            total += number;
            System.out.print("Enter another number: ");
            number = scanner.nextDouble();
        }
        System.out.println("The sum of the numbers is: " + total);
        scanner.close();
    }
}
