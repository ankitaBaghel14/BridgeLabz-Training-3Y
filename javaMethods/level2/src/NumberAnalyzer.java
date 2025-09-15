import java.util.Scanner;

public class NumberAnalyzer {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Analysis of Numbers ---");
        for (int number : numbers) {
            if (isPositive(number)) {
                System.out.print("The number " + number + " is positive and ");
                if (isEven(number)) {
                    System.out.println("is an even number.");
                } else {
                    System.out.println("is an odd number.");
                }
            } else {
                System.out.println("The number " + number + " is negative.");
            }
        }

        System.out.println("\n--- Comparison of First and Last Element ---");
        int result = compare(numbers[0], numbers[numbers.length - 1]);
        if (result == 1) {
            System.out.println("The first number (" + numbers[0] + ") is greater than the last number (" + numbers[numbers.length - 1] + ").");
        } else if (result == -1) {
            System.out.println("The first number (" + numbers[0] + ") is less than the last number (" + numbers[numbers.length - 1] + ").");
        } else {
            System.out.println("The first number (" + numbers[0] + ") is equal to the last number (" + numbers[numbers.length - 1] + ").");
        }

        scanner.close();
    }
}