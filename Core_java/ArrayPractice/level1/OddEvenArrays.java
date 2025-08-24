import java.util.Scanner;
import java.util.Arrays;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get an integer input from the user
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Check if the number is a natural number (positive integer)
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number (positive integer).");
            return;
        }

        // Create arrays for even and odd numbers
        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];

        // Create index variables for the arrays
        int evenIndex = 0;
        int oddIndex = 0;

        // Iterate from 1 to the number and save numbers into the corresponding array
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print the odd numbers array
        System.out.println("\nOdd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print the even numbers array
        System.out.println("\nEven numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
    }
}