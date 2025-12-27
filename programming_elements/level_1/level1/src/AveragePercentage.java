import java.util.Scanner;
class AveragePercentage {
    public static void main(String[] args) {

        // Variables
        String studentName;
        int mathsMarks;
        int physicsMarks;
        int chemistryMarks;
        double averageMarks;

        // Scanner for input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        studentName = input.nextLine();

        System.out.print("Enter Maths Marks: ");
        mathsMarks = input.nextInt();

        System.out.print("Enter Physics Marks: ");
        physicsMarks = input.nextInt();

        System.out.print("Enter Chemistry Marks: ");
        chemistryMarks = input.nextInt();

        // Calculation
        averageMarks = (mathsMarks + physicsMarks + chemistryMarks) / 3.0;

        // Output
        System.out.println(studentName + "'s average mark in PCM is " + averageMarks);

        input.close();
    }
}