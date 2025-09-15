import java.util.Scanner;

public class LineProperties {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates for point 1 (x1, y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter coordinates for point 2 (x2, y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double distance = findEuclideanDistance(x1, y1, x2, y2);
        System.out.printf("The Euclidean distance is: %.2f\n", distance);

        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        if (lineEquation != null) {
            double m = lineEquation[0];
            double b = lineEquation[1];
            System.out.printf("The equation of the line is: y = %.2fx + %.2f\n", m, b);
        }

        scanner.close();
    }

    public static double findEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        if (x2 == x1) {
            System.out.println("The line is vertical (x = " + x1 + "), slope is undefined.");
            return null;
        }

        double[] equation = new double[2];
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;

        equation[0] = m;
        equation[1] = b;
        return equation;
    }
}