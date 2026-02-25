import java.util.Scanner;
import java.util.Arrays;

public class LargestSecondLargestDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int originalNumber = number;

        int maxDigits = 10;
        int[] digits = new int[maxDigits];
        int index = 0;

        // Store digits in an array
        while (number != 0) {
            if (index == maxDigits) {
                break; // Break if array is full
            }
            int digit = number % 10;
            digits[index] = digit;
            number /= 10;
            index++;
        }

        int largest = -1;
        int secondLargest = -1;

        // Find largest and second largest
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("\nFor the number " + originalNumber + ":");
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}