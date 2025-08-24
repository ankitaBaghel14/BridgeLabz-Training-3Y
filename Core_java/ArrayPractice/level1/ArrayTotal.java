import java.util.Scanner;
import java.util.Arrays;

public class ArrayTotal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Use a while loop to take user input until a condition is met
        System.out.println("Enter numbers to add to an array (max 10). Enter 0 or a negative number to stop.");
        while (true) {
            System.out.print("Enter a number: ");
            double userEntry = input.nextDouble();

            // Break the loop if the user enters 0 or a negative number
            if (userEntry <= 0) {
                break;
            }

            // Break the loop if the array is full
            if (index >= 10) {
                System.out.println("Array is full. No more numbers can be added.");
                break;
            }

            // Assign the number to the array and increment the index
            numbers[index] = userEntry;
            index++;
        }

        // Calculate the sum of all numbers entered
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        // Display the total sum
        System.out.println("\nSum of all numbers entered: " + total);
    }
}