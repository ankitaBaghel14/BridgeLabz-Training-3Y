import java.util.Scanner;

public class StudentVoteChecker {

    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentAges = new int[10];

        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            studentAges[i] = scanner.nextInt();
        }

        System.out.println("\n--- Voting Eligibility Status ---");
        for (int i = 0; i < studentAges.length; i++) {
            boolean canVote = canStudentVote(studentAges[i]);
            String status = canVote ? "can vote." : "cannot vote.";
            System.out.println("Student " + (i + 1) + " (Age: " + studentAges[i] + ") " + status);
        }

        scanner.close();
    }
}