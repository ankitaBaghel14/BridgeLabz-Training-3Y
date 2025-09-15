import java.util.Scanner;

public class TrigonometricFunctions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();

        double[] results = calculateTrigonometricFunctions(angleInDegrees);

        System.out.printf("Sine of %.2f degrees: %.4f\n", angleInDegrees, results[0]);
        System.out.printf("Cosine of %.2f degrees: %.4f\n", angleInDegrees, results[1]);
        System.out.printf("Tangent of %.2f degrees: %.4f\n", angleInDegrees, results[2]);
        scanner.close();
    }

    public static double[] calculateTrigonometricFunctions(double angle) {
        double angleInRadians = Math.toRadians(angle);
        double[] results = new double[3];
        results[0] = Math.sin(angleInRadians);
        results[1] = Math.cos(angleInRadians);
        results[2] = Math.tan(angleInRadians);
        return results;
    }
}