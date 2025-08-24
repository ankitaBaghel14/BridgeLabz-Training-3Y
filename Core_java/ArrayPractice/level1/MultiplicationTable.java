import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get an integer input from the user
        System.out.print("Enter a number to get its multiplication table: ");
        int number = input.nextInt();

        // Define an array to store the results
        int[] multiplicationResults = new int[10];

        // Run a loop from 1 to 10 and store the results
        for (int i = 1; i <= 10; i++) {
            multiplicationResults[i - 1] = number * i;
        }

        // Display the results from the array
        System.out.println("Multiplication table for " + number + ":");
        for (int i = 0; i < multiplicationResults.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationResults[i]);
        }
    }
}