import java.util.Scanner;

public class PowerOfNumberFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("3\n4"); // Custom input: base and power
        System.out.println("Enter the base number:");
        int number = scanner.nextInt();
        System.out.println("Enter the power:");
        int power = scanner.nextInt();
        long result = 1;

        if (number >= 0 && power >= 0) {
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + " to the power of " + power + " is " + result);
        } else {
            System.out.println("Please enter positive integers for base and power.");
        }
        scanner.close();
    }
}
