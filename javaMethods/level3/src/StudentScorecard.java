import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generateRandomScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + random.nextInt(90); // 2-digit scores
            }
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3]; // Total, Average, Percentage
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = (double) total / 3;
            double percentage = (double) total / 300 * 100;

            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("\n--- Student Scorecard ---");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-10s | %-8s | %-8s | %-8s | %-8s | %-8s | %-10s\n", "Student", "Physics", "Chem", "Math", "Total", "Average", "Percentage");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d | %-8d | %-8d | %-8d | %-8.0f | %-8.2f | %-10.2f%%\n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2], stats[i][0], stats[i][1], stats[i][2]);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] scores = generateRandomScores(numStudents);
        double[][] stats = calculateStats(scores);
        displayScorecard(scores, stats);

        scanner.close();
    }
}