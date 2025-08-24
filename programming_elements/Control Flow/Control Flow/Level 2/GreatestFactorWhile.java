import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("100"); // Custom input
        System.out.println("Enter an integer:");
        int number = scanner.nextInt();
        int greatestFactor = 1;

        if (number > 1) {
            int counter = number - 1;
            while (counter >= 1) {
                if (number % counter == 0) {
                    greatestFactor = counter;
                    break;
                }
                counter--;
            }
        }
        System.out.println("The greatest factor of " + number + " besides itself is " + greatestFactor);
        scanner.close();
    }
}
