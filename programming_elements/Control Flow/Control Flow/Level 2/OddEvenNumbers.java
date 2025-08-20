import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("10"); // Custom input
        System.out.println("Enter a number:");
        int number = scanner.nextInt();

        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an even number.");
                } else {
                    System.out.println(i + " is an odd number.");
                }
            }
        } else {
            System.out.println("Please enter a natural number (greater than 0).");
        }
        scanner.close();
    }
}
