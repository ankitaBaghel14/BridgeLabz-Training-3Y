import java.util.Scanner;

class VolumeOfEarth {
    public static void main(String[] args) {

        final double PI = 3.14159265359;
        double radiusKm;
        double radiusMiles;
        double volumeKm3;
        double volumeMiles3;
        final double KM_TO_MILES_FACTOR = 1.6;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter radius of Earth in kilometers: ");
        radiusKm = input.nextDouble();

        // Convert radius to miles
        radiusMiles = radiusKm / KM_TO_MILES_FACTOR;

        // Volume of a sphere formula
        volumeKm3 = (4.0 / 3.0) * PI * Math.pow(radiusKm, 3);
        volumeMiles3 = (4.0 / 3.0) * PI * Math.pow(radiusMiles, 3);

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 +
                " and cubic miles is " + volumeMiles3);

        input.close();
    }
}
