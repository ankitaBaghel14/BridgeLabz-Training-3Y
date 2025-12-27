import java.util.Scanner;

class FeetToYardsMiles {
    public static void main(String[] args) {

        double distanceFeet;
        double distanceYards;
        double distanceMiles;
        final double FEET_IN_YARD = 3.0;
        final double YARDS_IN_MILE = 1760.0;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        distanceFeet = input.nextDouble();

        distanceYards = distanceFeet / FEET_IN_YARD;
        distanceMiles = distanceYards / YARDS_IN_MILE;

        System.out.println("The distance is " + distanceYards + " yards and " + distanceMiles + " miles");

        input.close();
    }
}
