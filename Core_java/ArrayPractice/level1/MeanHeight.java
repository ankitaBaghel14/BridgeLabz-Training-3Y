import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        // Get height values for 11 players from the user
        System.out.println("Enter the heights of 11 football players in meters:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
        }

        // Find the sum of all elements in the array
        for (double height : heights) {
            sum += height;
        }

        // Calculate the mean height
        double mean = sum / heights.length;

        // Print the mean height
        System.out.printf("\nThe mean height of the football team is: %.2f meters\n", mean);
    }
}