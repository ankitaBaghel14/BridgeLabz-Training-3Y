import java.util.Scanner;

public class FriendFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] friends = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < friends.length; i++) {
            System.out.print("Enter age for " + friends[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height (in meters) for " + friends[i] + ": ");
            heights[i] = scanner.nextDouble();
        }

        System.out.println("\nYoungest friend: " + findYoungest(friends, ages));
        System.out.println("Tallest friend: " + findTallest(friends, heights));

        scanner.close();
    }

    public static String findYoungest(String[] friends, int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return friends[youngestIndex];
    }

    public static String findTallest(String[] friends, double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return friends[tallestIndex];
    }
}