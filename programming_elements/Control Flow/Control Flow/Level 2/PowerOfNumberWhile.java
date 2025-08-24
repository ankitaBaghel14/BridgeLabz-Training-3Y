import java.util.Scanner;

public class PowerOfNumberWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("5\n3"); // Custom input: base and power
        System.out.println("Enter the base number:");
        int number = scanner.nextInt();
        System.out.println("Enter the power:");
        int power = scanner.nextInt();
        long result = 1;
        
        if (number >= 0 && power >= 0) {
            int counter = 0;
            while (counter < power) {
                result *= number;
                counter++;
            }
            System.out.println(number + " to the power of " + power + " is " + result);
        } else {
            System.out.println("Please enter positive integers for base and power.");
        }
        scanner.close();
    }
}
