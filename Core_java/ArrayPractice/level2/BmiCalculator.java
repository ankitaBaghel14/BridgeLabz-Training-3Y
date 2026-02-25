import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = input.nextInt();

        double[] heights = new double[numPersons];
        double[] weights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];

        // Take input for each person
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nEnter data for Person " + (i + 1));
            System.out.print("Height (in meters): ");
            heights[i] = input.nextDouble();
            System.out.print("Weight (in kg): ");
            weights[i] = input.nextDouble();
        }

        // Calculate BMI and determine status
        for (int i = 0; i < numPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] < 25) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] >= 25 && bmis[i] < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\n--- BMI Results ---");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("Person %d: Height=%.2fm, Weight=%.2fkg, BMI=%.2f, Status=%s\n",
                    i + 1, heights[i], weights[i], bmis[i], statuses[i]);
        }
    }
}