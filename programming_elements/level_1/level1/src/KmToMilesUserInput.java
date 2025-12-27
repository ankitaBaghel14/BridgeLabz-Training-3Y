import java.util.Scanner;

class KmToMilesUserInput {
    public static void main(String[] args) {

        double kilometers;
        double miles;
        final double KM_TO_MILE_FACTOR = 1.6;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        kilometers = input.nextDouble();

        miles = kilometers / KM_TO_MILE_FACTOR;

        System.out.println("The total miles is " + miles + " mile for the given " + kilometers + " km");

        input.close();
    }
}
