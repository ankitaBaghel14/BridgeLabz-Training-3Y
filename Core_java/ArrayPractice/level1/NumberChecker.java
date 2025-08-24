import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        // Take user input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Check each number for positive, negative, or zero, and even or odd
        System.out.println("\nChecking the numbers:");
        for (int number : numbers) {
            if (number > 0) {
                System.out.print(number + " is a positive number, and it is ");
                if (number % 2 == 0) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else if (number < 0) {
                System.out.println(number + " is a negative number.");
            } else {
                System.out.println(number + " is zero.");
            }
        }

        // Compare the first and last elements
        System.out.println("\nComparing the first and last elements:");
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("The first and last elements are equal.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("The first element is greater than the last element.");
        } else {
            System.out.println("The first element is less than the last element.");
        }
    }
}