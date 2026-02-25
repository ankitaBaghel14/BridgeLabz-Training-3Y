import java.util.Scanner;
import java.util.Arrays;

public class LargestSecondLargestAdvanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = input.nextLong(); // Use long for large numbers
        long originalNumber = number;

        int maxDigits = 10;
        int[] digits = new int[maxDigits];
        int index = 0;

        // Store all digits in a dynamically sized array
        while (number != 0) {
            if (index == digits.length) {
                // Increase the size of the array
                maxDigits += 10;
                int[] temp = new int[maxDigits];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
            int digit = (int) (number % 10);
            digits[index] = digit;
            number /= 10;
            index++;
        }

        // Trim the array to the actual number of digits
        int[] finalDigits = new int[index];
        System.arraycopy(digits, 0, finalDigits, 0, index);

        int largest = -1;
        int secondLargest = -1;

        // Find largest and second largest
        for (int i = 0; i < finalDigits.length; i++) {
            if (finalDigits[i] > largest) {
                secondLargest = largest;
                largest = finalDigits[i];
            } else if (finalDigits[i] > secondLargest && finalDigits[i] != largest) {
                secondLargest = finalDigits[i];
            }
        }

        System.out.println("\nFor the number " + originalNumber + ":");
        System.out.println("Digits: " + Arrays.toString(finalDigits));
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}