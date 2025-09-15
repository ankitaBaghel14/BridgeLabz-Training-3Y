import java.util.Scanner;

public class BMICalculator {

    public static double[][] calculateBMI(double[][] personData) {
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0]; // kg
            double heightCm = personData[i][1]; // cm
            double heightM = heightCm / 100.0; // convert cm to m
            if (heightM > 0) {
                personData[i][2] = weight / (heightM * heightM);
            }
        }
        return personData;
    }

    public static String[] getBMIStatus(double[][] personData) {
        String[] statusArray = new String[personData.length];
        for (int i = 0; i < personData.length; i++) {
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                statusArray[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                statusArray[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 30) {
                statusArray[i] = "Overweight";
            } else {
                statusArray[i] = "Obesity";
            }
        }
        return statusArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] members = new double[10][3];

        System.out.println("Enter weight (kg) and height (cm) for 10 members:");
        for (int i = 0; i < members.length; i++) {
            System.out.print("Member " + (i + 1) + " - Weight (kg): ");
            members[i][0] = scanner.nextDouble();
            System.out.print("Member " + (i + 1) + " - Height (cm): ");
            members[i][1] = scanner.nextDouble();
        }

        members = calculateBMI(members);
        String[] status = getBMIStatus(members);

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < members.length; i++) {
            System.out.printf("Member %d: Weight=%.2f kg, Height=%.2f cm, BMI=%.2f, Status: %s\n",
                    i + 1, members[i][0], members[i][1], members[i][2], status[i]);
        }

        scanner.close();
    }
}