import java.util.Scanner;

public class FactorsFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("24"); // Custom input
        System.out.println("Enter a positive integer:");
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.print("The factors of " + number + " are: ");
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Please enter a positive integer.");
        }
        scanner.close();
    }
}
