import java.util.Random;
import java.util.Scanner;

public class StudentVotingEligibility {

    /**
     * Finds the length of a string without using the built-in length() method.
     * (Reused from previous example for tabular display formatting)
     * @param text The input string.
     * @return The length of the string.
     */
    public static int getStringLengthWithoutBuiltIn(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception, ignore
        }
        return count;
    }

    /**
     * Generates a 1D array of random 2-digit ages for a given number of students.
     * @param numStudents The number of students.
     * @return An array of student ages.
     */
    public static int[] generateRandomAges(int numStudents) {
        int[] ages = new int[numStudents];
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            ages[i] = random.nextInt(82) + 18; // Ages between 18 and 99 (inclusive)
        }
        return ages;
    }

    /**
     * Determines voting eligibility for each age in the provided array.
     * @param ages An array of student ages.
     * @return A 2D String array where each row is [age_as_string, "true"/"false"].
     */
    public static String[][] getVotingEligibility(int[] ages) {
        String[][] eligibility = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            eligibility[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) { // Handle negative age as invalid/cannot vote
                eligibility[i][1] = "false (Invalid Age)";
            } else if (ages[i] >= 18) {
                eligibility[i][1] = "true";
            } else {
                eligibility[i][1] = "false";
            }
        }
        return eligibility;
    }

    /**
     * Displays a 2D array of Strings in a tabular format.
     * (Reused from previous example)
     * @param data The 2D array to display.
     * @param headers An array of column headers.
     */
    public static void display2DStringArrayTabular(String[][] data, String[] headers) {
        // Calculate max column widths for formatting
        int[] colWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            colWidths[i] = getStringLengthWithoutBuiltIn(headers[i]);
        }
        for (String[] row : data) {
            for (int j = 0; j < row.length; j++) {
                if (getStringLengthWithoutBuiltIn(row[j]) > colWidths[j]) {
                    colWidths[j] = getStringLengthWithoutBuiltIn(row[j]);
                }
            }
        }

        // Print headers
        for (int i = 0; i < headers.length; i++) {
            System.out.printf("%-" + (colWidths[i] + 2) + "s", headers[i]);
        }
        System.out.println();
        // Print separator
        for (int i = 0; i < headers.length; i++) {
            for (int j = 0; j < colWidths[i] + 2; j++) {
                System.out.print("-");
            }
        }
        System.out.println();

        // Print data
        for (String[] row : data) {
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%-" + (colWidths[j] + 2) + "s", row[j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // We can make this user input or keep it fixed at 10 as per prompt
        // System.out.print("Enter the number of students: ");
        // int numStudents = input.nextInt();
        int numStudents = 10; // Fixed as per prompt

        int[] studentAges = generateRandomAges(numStudents);
        String[][] eligibilityData = getVotingEligibility(studentAges);

        System.out.println("\n--- Student Voting Eligibility ---");
        String[] headers = {"Age", "Can Vote?"};
        display2DStringArrayTabular(eligibilityData, headers);

        input.close();
    }
}