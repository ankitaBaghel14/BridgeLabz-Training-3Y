import java.util.Scanner;

public class MultiplesBelow100For {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12"); // Custom input
        System.out.println("Enter a positive integer less than 100:");
        int number = scanner.nextInt();

        if (number > 0 && number < 100) {
            System.out.println("Multiples of " + number + " below 100 are:");
            for (int i = 99; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Please enter a positive integer between 1 and 99.");
        }
        scanner.close();
    }
}
