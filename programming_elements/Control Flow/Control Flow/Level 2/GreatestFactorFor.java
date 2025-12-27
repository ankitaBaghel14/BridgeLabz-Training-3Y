import java.util.Scanner;

public class GreatestFactorFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("100"); // Custom input
        System.out.println("Enter an integer:");
        int number = scanner.nextInt();
        int greatestFactor = 1;

        if (number > 1) {
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }
        }
        System.out.println("The greatest factor of " + number + " besides itself is " + greatestFactor);
        scanner.close();
    }
}
