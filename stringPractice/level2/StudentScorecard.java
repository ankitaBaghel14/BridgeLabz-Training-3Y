import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class StudentScorecard {

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
     * Generates random 2-digit scores (0-100) for Physics, Chemistry, and Math
     * for a given number of students.
     * @param numStudents The number of students.
     * @return A 2D array where each row is [Physics, Chemistry, Math] scores.
     */
    public static int[][] generateRandomPcmScores(int numStudents) {
        int[][] pcmScores = new int[numStudents][3];
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            pcmScores[i][0] = random.nextInt(101); // Physics score (0-100)
            pcmScores[i][1] = random.nextInt(101); // Chemistry score (0-100)
            pcmScores[i][2] = random.nextInt(101); // Math score (0-100)
        }
        return pcmScores;
    }

    /**
     * Calculates total, average, and percentage for each student.
     * @param pcmScores A 2D array of PCM scores for all students.
     * @return A 2D array where each row is [total, average, percentage].
     * Values are rounded to 2 decimal places.
     */
    public static double[][] calculateStudentPerformance(int[][] pcmScores) {
        double[][] performanceData = new double[pcmScores.length][3]; // [total, average, percentage]

        for (int i = 0; i < pcmScores.length; i++) {
            int total = pcmScores[i][0] + pcmScores[i][1] + pcmScores[i][2];
            double average = (double) total / 3;
            double percentage = (double) total / 300 * 100;

            performanceData[i][0] = Math.round(total * 100.0) / 100.0; // Total (not strictly needed to round but for consistency)
            performanceData[i][1] = Math.round(average * 100.0) / 100.0; // Rounded average
            performanceData[i][2] = Math.round(percentage * 100.0) / 100.0; // Rounded percentage
        }
        return performanceData;
    }

    /**
     * Calculates the grade for each student based on their percentage.
     * @param performanceData A 2D array containing student performance data,
     * where performanceData[i][2] is the percentage.
     * @return A 2D String array where each row is [grade].
     */
    public static String[][] calculateGrades(double[][] performanceData) {
        String[][] grades = new String[performanceData.length][1];

        for (int i = 0; i < performanceData.length; i++) {
            double percentage = performanceData[i][2];
            if (percentage >= 90) {
                grades[i][0] = "A";
            } else if (percentage >= 80) {
                grades[i][0] = "B";
            } else if (percentage >= 70) {
                grades[i][0] = "C";
            } else if (percentage >= 60) {
                grades[i][0] = "D";
            } else {
                grades[i][0] = "F";
            }
        }
        return grades;
    }

    /**
     * Displays the complete student scorecard in a tabular format.
     * @param pcmScores 2D array of PCM scores.
     * @param performanceData 2D array of total, average, percentage.
     * @param gradesData 2D array of grades.
     * @param studentNames An array of student names (e.g., "Student 1", "Student 2").
     */
    public static void displayStudentScorecard(int[][] pcmScores, double[][] performanceData, String[][] gradesData, String[] studentNames) {
        int numStudents = pcmScores.length;
        // Prepare data for tabular display
        String[][] displayData = new String[numStudents][8]; // Name, Phy, Chem, Math, Total, Avg, %, Grade

        for (int i = 0; i < numStudents; i++) {
            displayData[i][0] = studentNames[i];
            displayData[i][1] = String.valueOf(pcmScores[i][0]);
            displayData[i][2] = String.valueOf(pcmScores[i][1]);
            displayData[i][3] = String.valueOf(pcmScores[i][2]);
            displayData[i][4] = String.format("%.0f", performanceData[i][0]); // Display total as integer
            displayData[i][5] = String.format("%.2f", performanceData[i][1]);
            displayData[i][6] = String.format("%.2f%%", performanceData[i][2]);
            displayData[i][7] = gradesData[i][0];
        }

        String[] headers = {"Student", "Phy", "Chem", "Math", "Total", "Avg", "Perc", "Grade"};

        // Calculate max column widths for formatting
        int[] colWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            colWidths[i] = getStringLengthWithoutBuiltIn(headers[i]);
        }
        for (String[] row : displayData) {
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
        for (String[] row : displayData) {
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%-" + (colWidths[j] + 2) + "s", row[j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        // Generate random scores
        int[][] pcmScores = generateRandomPcmScores(numStudents);

        // Calculate performance
        double[][] performanceData = calculateStudentPerformance(pcmScores);

        // Calculate grades
        String[][] grades = calculateGrades(performanceData);

        // Prepare student names for display
        String[] studentNames = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            studentNames[i] = "Student " + (i + 1);
        }

        System.out.println("\n--- Student Scorecard ---");
        displayStudentScorecard(pcmScores, performanceData, grades, studentNames);

        input.close();
    }
}