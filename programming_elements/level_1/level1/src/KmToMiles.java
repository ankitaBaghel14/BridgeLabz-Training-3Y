import java.util.Scanner;
class KmToMiles {
    public static void main(String[] args) {

        double kilometers;
        final double KM_TO_MILE_FACTOR = 1.6;
        double miles;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        kilometers = input.nextDouble();

        miles = kilometers / KM_TO_MILE_FACTOR;

        System.out.println("The distance " + kilometers + " km in miles is " + miles);

        input.close();
    }
}
