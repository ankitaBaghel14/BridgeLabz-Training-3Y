import java.util.Scanner;

public class CollinearChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates for point A (x1, y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter coordinates for point B (x2, y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.println("Enter coordinates for point C (x3, y3):");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        System.out.println("\nChecking for collinearity using slope formula...");
        if (areCollinearBySlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear.");
        } else {
            System.out.println("Points are not collinear.");
        }

        System.out.println("\nChecking for collinearity using triangle area formula...");
        if (areCollinearByArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear.");
        } else {
            System.out.println("Points are not collinear.");
        }
        scanner.close();
    }

    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        return Math.abs(slopeAB - slopeBC) < 1e-9; // Using a small epsilon for floating-point comparison
    }

    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return Math.abs(area) < 1e-9;
    }
}