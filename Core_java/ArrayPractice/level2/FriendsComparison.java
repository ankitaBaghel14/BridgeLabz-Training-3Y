import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take user input for age and height
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter data for " + names[i] + ":");
            System.out.print("Age: ");
            ages[i] = input.nextInt();
            System.out.print("Height (in meters): ");
            heights[i] = input.nextDouble();
        }

        // Find the youngest friend
        int youngestAge = ages[0];
        String youngestFriend = names[0];
        for (int i = 1; i < 3; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
                youngestFriend = names[i];
            }
        }

        // Find the tallest friend
        double tallestHeight = heights[0];
        String tallestFriend = names[0];
        for (int i = 1; i < 3; i++) {
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                tallestFriend = names[i];
            }
        }

        System.out.println("\n--- Results ---");
        System.out.println("The youngest friend is " + youngestFriend + " at " + youngestAge + " years old.");
        System.out.println("The tallest friend is " + tallestFriend + " at " + tallestHeight + " meters tall.");
    }
}