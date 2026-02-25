import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take integer input from the user
        System.out.print("Enter a number to find its multiplication table from 6 to 9: ");
        int number = input.nextInt();

        // Define an array to store the multiplication results
        int[] multiplicationResult = new int[4];

        // Using a for loop, find the multiplication table from 6 to 9 and save the result
        for (int i = 0; i < 4; i++) {
            multiplicationResult[i] = number * (i + 6);
        }

        // Display the result from the array
        System.out.println("Multiplication table for " + number + " (from 6 to 9):");
        for (int i = 0; i < 4; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + multiplicationResult[i]);
        }
    }
}