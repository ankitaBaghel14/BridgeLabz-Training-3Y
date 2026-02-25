import java.util.Scanner;
import java.util.Arrays;

public class FactorFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for a number
        System.out.print("Enter a number to find its factors: ");
        int number = input.nextInt();

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Find the factors and save them in an array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // If the array needs more space, resize it
                if (index == factors.length) {
                    maxFactor *= 2;
                    factors = Arrays.copyOf(factors, maxFactor);
                }
                factors[index] = i;
                index++;
            }
        }

        // Create a new array to hold only the factors
        int[] finalFactors = new int[index];
        for (int i = 0; i < index; i++) {
            finalFactors[i] = factors[i];
        }

        // Display the factors
        System.out.println("The factors of " + number + " are: " + Arrays.toString(finalFactors));
    }
}