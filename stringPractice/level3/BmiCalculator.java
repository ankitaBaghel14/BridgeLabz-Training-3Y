import java.util.Scanner;
import java.util.Arrays;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numMembers = 10;
        double[][] personData = new double[numMembers][2]; // [weight_kg, height_cm]

        // Take user input for weight and height
        System.out.println("Enter weight (kg) and height (cm) for 10 team members:");
        for (int i = 0; i < numMembers; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Weight (kg): ");
            personData[i][0] = input.nextDouble();
            System.out.print("  Height (cm): ");
            personData[i][1] = input.nextDouble();
        }

        // Call method to compute BMI and status
        String[][] bmiData = getBmiAndStatus(personData);

        // Display results
        displayBmiTable(bmiData);

        input.close();
    }

    /**
     * Calculates BMI and status for each person.
     * @param personData 2D array with weight (kg) and height (cm).
     * @return 2D String array with Height, Weight, BMI, and Status.
     */
    public static String[][] getBmiAndStatus(double[][] personData) {
        String[][] bmiStatusArray = new String[personData.length][4]; // [height, weight, bmi, status]

        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double heightCm = personData[i][1];

            // Convert cm to meters
            double heightM = heightCm / 100.0;

            // Calculate BMI
            double bmi = weight / (heightM * heightM);

            // Determine status
            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 25) {
                status = "Normal weight";
            } else if (bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            bmiStatusArray[i][0] = String.format("%.2f", heightCm);
            bmiStatusArray[i][1] = String.format("%.2f", weight);
            bmiStatusArray[i][2] = String.format("%.2f", bmi);
            bmiStatusArray[i][3] = status;
        }
        return bmiStatusArray;
    }

    /**
     * Displays a 2D String array in a tabular format.
     * @param data The data to be displayed.
     */
    public static void displayBmiTable(String[][] data) {
        String[] headers = {"Height (cm)", "Weight (kg)", "BMI", "Status"};
        System.out.println("\n--- BMI Report ---");

        // Print headers
        System.out.printf("%-15s %-15s %-10s %-15s\n", headers[0], headers[1], headers[2], headers[3]);
        System.out.println("----------------------------------------------------------------");

        // Print data rows
        for (String[] row : data) {
            System.out.printf("%-15s %-15s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }
}