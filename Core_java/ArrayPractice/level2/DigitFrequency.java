import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to find the frequency of its digits: ");
        int number = input.nextInt();

        // Frequency array to store counts for digits 0-9
        int[] frequency = new int[10];

        // Handle the case of the number 0
        if (number == 0) {
            frequency[0] = 1;
        } else {
            // Find the frequency of each digit
            int tempNumber = number;
            while (tempNumber != 0) {
                int digit = tempNumber % 10;
                frequency[digit]++;
                tempNumber /= 10;
            }
        }

        // Display the frequency of each digit
        System.out.println("\n--- Digit Frequencies ---");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("The digit " + i + " appears " + frequency[i] + " time(s).");
            }
        }
    }
}