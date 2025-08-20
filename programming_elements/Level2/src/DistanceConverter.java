import java.util.Scanner;

class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Enter distance in feet: ");
        double distanceFeet = input.nextDouble();

        // Conversion factors
        double feetPerYard = 3;
        double yardsPerMile = 1760;

        // Calculations
        double distanceYards = distanceFeet / feetPerYard;
        double distanceMiles = distanceYards / yardsPerMile;

        // Output
        System.out.println("The distance in yards is " + distanceYards + " while the distance in miles is " + distanceMiles);

        input.close();
    }
}
