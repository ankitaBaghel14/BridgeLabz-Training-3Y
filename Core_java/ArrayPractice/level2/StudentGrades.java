import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        double[][] marks = new double[numStudents][3];

        // Take input for marks
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));
            int tempIndex = i;

            // Input validation for Physics
            double physics;
            do {
                System.out.print("Physics marks: ");
                physics = input.nextDouble();
                if (physics < 0) {
                    System.out.println("Invalid marks. Please enter a positive value.");
                }
            } while (physics < 0);
            marks[i][0] = physics;

            // Input validation for Chemistry
            double chemistry;
            do {
                System.out.print("Chemistry marks: ");
                chemistry = input.nextDouble();
                if (chemistry < 0) {
                    System.out.println("Invalid marks. Please enter a positive value.");
                }
            } while (chemistry < 0);
            marks[i][1] = chemistry;

            // Input validation for Maths
            double maths;
            do {
                System.out.print("Maths marks: ");
                maths = input.nextDouble();
                if (maths < 0) {
                    System.out.println("Invalid marks. Please enter a positive value.");
                }
            } while (maths < 0);
            marks[i][2] = maths;
        }

        // Calculate percentage and grade
        for (int i = 0; i < numStudents; i++) {
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;

            if (percentages[i] >= 90) {
                grades[i] = "A";
            } else if (percentages[i] >= 80) {
                grades[i] = "B";
            } else if (percentages[i] >= 70) {
                grades[i] = "C";
            } else if (percentages[i] >= 60) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        // Display results
        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Student %d: Physics=%.2f, Chemistry=%.2f, Maths=%.2f, Percentage=%.2f%%, Grade=%s\n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}