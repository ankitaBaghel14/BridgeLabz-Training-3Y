import java.util.Scanner;

public class BmiCalculator2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = input.nextInt();

        // 2D array to store [weight, height, BMI]
        double[][] personData = new double[numPersons][3];
        String[] weightStatus = new String[numPersons];

        // Take input for weight and height
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nEnter data for Person " + (i + 1));

            // Input validation for height
            double height;
            do {
                System.out.print("Height (in meters): ");
                height = input.nextDouble();
                if (height <= 0) {
                    System.out.println("Invalid height. Please enter a positive value.");
                }
            } while (height <= 0);
            personData[i][0] = height;

            // Input validation for weight
            double weight;
            do {
                System.out.print("Weight (in kg): ");
                weight = input.nextDouble();
                if (weight <= 0) {
                    System.out.println("Invalid weight. Please enter a positive value.");
                }
            } while (weight <= 0);
            personData[i][1] = weight;
        }

        // Calculate BMI and determine status
        for (int i = 0; i < numPersons; i++) {
            double height = personData[i][0];
            double weight = personData[i][1];
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\n--- BMI Results ---");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("Person %d: Height=%.2fm, Weight=%.2fkg, BMI=%.2f, Status=%s\n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}