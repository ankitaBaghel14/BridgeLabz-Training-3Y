import java.util.Scanner;

public class TriangularPark {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);

        System.out.printf("The athlete must complete %.2f rounds to run 5 km.\n", rounds);
        scanner.close();
    }

    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        if (perimeter == 0) {
            return 0;
        }
        double distanceInMeters = 5000;
        return distanceInMeters / perimeter;
    }
}