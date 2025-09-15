import java.util.Scanner;

public class WindChill {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature (in Fahrenheit): ");
        double temp = scanner.nextDouble();

        System.out.print("Enter the wind speed (in miles per hour): ");
        double windSpeed = scanner.nextDouble();

        double windChill = calculateWindChill(temp, windSpeed);

        System.out.printf("The wind chill temperature is %.2f degrees Fahrenheit.\n", windChill);
        scanner.close();
    }

    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }
}