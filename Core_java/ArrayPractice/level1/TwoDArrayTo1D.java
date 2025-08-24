import java.util.Scanner;
import java.util.Arrays;

public class TwoDArrayTo1D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user input for rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = input.nextInt();

        // Create and populate the 2D array (Matrix)
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at [" + i + "][" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }

        // Create a 1D array to copy the elements into
        int[] singleDimensionArray = new int[rows * columns];
        int index = 0;

        // Loop through the 2D array and copy elements to the 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                singleDimensionArray[index] = matrix[i][j];
                index++;
            }
        }

        // Display the original 2D array
        System.out.println("\nOriginal 2D Array (Matrix):");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        // Display the copied 1D array
        System.out.println("\nCopied 1D Array:");
        System.out.println(Arrays.toString(singleDimensionArray));
    }
}