import java.util.Scanner;
import java.util.Arrays;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to reverse: ");
        int number = input.nextInt();
        int tempNumber = number;

        // Find the count of digits
        int digitCount = 0;
        if (number == 0) {
            digitCount = 1;
        } else {
            while (tempNumber != 0) {
                tempNumber /= 10;
                digitCount++;
            }
        }

        // Store the digits in an array
        int[] digits = new int[digitCount];
        int index = 0;
        tempNumber = number;
        while (tempNumber != 0) {
            digits[index] = tempNumber % 10;
            tempNumber /= 10;
            index++;
        }

        // Display the digits in reverse order
        System.out.println("\nOriginal number: " + number);
        System.out.print("Reversed number: ");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}